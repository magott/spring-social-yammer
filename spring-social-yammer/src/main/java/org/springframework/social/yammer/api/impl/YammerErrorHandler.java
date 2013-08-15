package org.springframework.social.yammer.api.impl;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.*;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class YammerErrorHandler extends DefaultResponseErrorHandler {

    public static final String PROVIDER_ID = "yammer";


	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		HttpStatus statusCode = response.getStatusCode();
		if (statusCode.series() == Series.SERVER_ERROR) {
			handleServerErrors(statusCode, response);
		} else if (statusCode.series() == Series.CLIENT_ERROR) {
			handleClientErrors(response);
		}

		// if not otherwise handled, do default handling and wrap with
		// UncategorizedApiException
		try {
			super.handleError(response);
		} catch (Exception e) {
			throw new UncategorizedApiException(PROVIDER_ID,"Error consuming Yammer REST API", e);
		}

	}

	private void handleClientErrors(ClientHttpResponse response) throws IOException {
		HttpStatus statusCode = response.getStatusCode();

		if (statusCode == HttpStatus.UNAUTHORIZED) {
			//TODO: Handle token expired/revoked
			// Falls back to default 401 handling
			throw new NotAuthorizedException(PROVIDER_ID,response.getStatusText());

		} else if (statusCode == HttpStatus.TOO_MANY_REQUESTS) {
			throw new RateLimitExceededException(PROVIDER_ID);
		} else if (statusCode == HttpStatus.NOT_FOUND) {
			throw new ResourceNotFoundException(PROVIDER_ID,statusCode.toString()+" Resources does not exists or you were trying to create a duplicate ");
		}else if(statusCode == HttpStatus.BAD_REQUEST){
			throw new OperationNotPermittedException(PROVIDER_ID,"The resources does not exist or you don't have permission to do that (HTTP 400)");
		}
	}


	/**
	 * Error details are returned in the message body as JSON. Extract these in
	 * a map
	 * 
	 * @param response
	 *            from yammer
	 * @return json body as a map
	 * @throws IOException
	 *             if ItemStream is closed
	 */
	private Map<String, Object> extractErrorDetailsFromResponse(ClientHttpResponse response) throws IOException {
		ObjectMapper mapper = new ObjectMapper(new JsonFactory());
		try {
			return mapper.<Map<String, Object>> readValue(response.getBody(), new TypeReference<Map<String, Object>>() {
			});
		} catch (JsonParseException e) {
			return Collections.emptyMap();
		}
	}

	private void handleServerErrors(HttpStatus statusCode, ClientHttpResponse response) {
        Map<String, Object> responseData;
        try {
            responseData = extractErrorDetailsFromResponse(response);
        } catch (IOException e) {
            throw new ServerException(PROVIDER_ID, "Status code: "+statusCode);
        }
        String message = (responseData.get("message") != null) ? responseData.get("message").toString() : "";
        throw new ServerException(PROVIDER_ID, "Status code: "+statusCode + "Message "+message);
	}

}
