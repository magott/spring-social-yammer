package org.springframework.social.yammer.api.impl;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.*;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;
import java.util.Map;

public class YammerErrorHandler extends DefaultResponseErrorHandler {

	private static final String RATE_LIMIT_EXCEEDED_MESSAGE_TEXT = "Rate limited due to excessive requests.";
	private static final String ERROR_MESSAGE_KEY = "message";
    private static final String YAMMER_PROVIDER_ID = "yammer";

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		HttpStatus statusCode = response.getStatusCode();
		if (statusCode.series() == Series.SERVER_ERROR) {
			handleServerErrors(statusCode);
		} else if (statusCode.series() == Series.CLIENT_ERROR) {
			handleClientErrors(response);
		}

		// if not otherwise handled, do default handling and wrap with
		// UncategorizedApiException
		try {
			super.handleError(response);
		} catch (Exception e) {
			throw new UncategorizedApiException(YAMMER_PROVIDER_ID, "Error consuming Yammer REST API", e);
		}

	}

	private void handleClientErrors(ClientHttpResponse response) throws IOException {
		HttpStatus statusCode = response.getStatusCode();

		if (statusCode == HttpStatus.UNAUTHORIZED) {
			chekForRateLimitError(response);
			// Falls back to default 401 handling
			throw new NotAuthorizedException(YAMMER_PROVIDER_ID, response.getStatusText());

		} else if (statusCode == HttpStatus.FORBIDDEN) {
			// When Yammer fixes it's bug in the returned error code for rate
			// limits, 403 will be returned
			throw new RateLimitExceededException(YAMMER_PROVIDER_ID);
		} else if (statusCode == HttpStatus.NOT_FOUND) {
			throw new ResourceNotFoundException(YAMMER_PROVIDER_ID, statusCode.toString()+" Resources does not exists or you were trying to create a duplicate ");
		}else if(statusCode == HttpStatus.BAD_REQUEST){
			throw new OperationNotPermittedException(YAMMER_PROVIDER_ID, "The resources does not exist or you don't have permission to do that (HTTP 400)");
		}
	}

	private void chekForRateLimitError(ClientHttpResponse response) {
		Map<String, Object> body;
		try{
			body = extractErrorDetailsFromResponse(response);
			if(body==null){
				return;
			}
		}catch(IOException e){
			return; //An IOException is thrown in the case of a empty message body
		}
		
		@SuppressWarnings("unchecked")
		Map<String, String> errorDetails = (Map<String, String>) body.get("response");
		if (errorDetails.containsKey(ERROR_MESSAGE_KEY)) {
			String errorMessage = errorDetails.get(ERROR_MESSAGE_KEY);
			if (errorMessage.equals(RATE_LIMIT_EXCEEDED_MESSAGE_TEXT)) {
				// While the API doc says it will return 403 for rate limits
				// Yammer returns 401 with special message text
				throw new RateLimitExceededException(YAMMER_PROVIDER_ID);
			}
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
			return null;
		}
	}

	private void handleServerErrors(HttpStatus statusCode) {
		// TODO Auto-generated method stub

	}
}
