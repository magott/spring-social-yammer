package org.springframework.social.yammer.api.impl;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.TOO_MANY_REQUESTS;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import java.io.IOException;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.social.NotAuthorizedException;
import org.springframework.social.RateLimitExceededException;

public class ApiErrorTest extends AbstractYammerApiTest{


    @Test(expected=RateLimitExceededException.class)
	public void testRateLimitExceeded_whenForbidden() throws IOException{
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/users.json?page=1&reverse=false"))
				.andExpect(method(GET))
				.andRespond(withStatus(TOO_MANY_REQUESTS));
		yammerTemplate.userOperations().getUsers(1);
	}
	
	@Test(expected=NotAuthorizedException.class)
	public void testNotAutorizedException(){
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/users.json?page=1&reverse=false"))
		.andExpect(method(GET))
		.andRespond(withStatus(UNAUTHORIZED));
		yammerTemplate.userOperations().getUsers(1);		
	}
}
