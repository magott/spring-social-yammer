package org.springframework.social.yammer.api.impl;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.RequestMatchers.method;
import static org.springframework.test.web.client.RequestMatchers.requestTo;
import static org.springframework.test.web.client.ResponseCreators.withResponse;

import java.io.IOException;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.social.NotAuthorizedException;
import org.springframework.social.RateLimitExceededException;

public class ApiErrorTest extends AbstractYammerApiTest{

	@Test(expected=RateLimitExceededException.class)
	public void testRateLimitExceeded() throws IOException{
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/users.json?page=1&reverse=false"))
				.andExpect(method(GET))
				.andRespond(withResponse(jsonResource("testdata/rate-limit-error"), responseHeaders, HttpStatus.valueOf(401),""));
		yammerTemplate.userOperations().getUsers(1);		
	}
	
	@Test(expected=NotAuthorizedException.class)
	public void testNotAutorizedException(){
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/users.json?page=1&reverse=false"))
		.andExpect(method(GET))
		.andRespond(withResponse("", responseHeaders, HttpStatus.valueOf(401),""));
		yammerTemplate.userOperations().getUsers(1);		
	}
}
