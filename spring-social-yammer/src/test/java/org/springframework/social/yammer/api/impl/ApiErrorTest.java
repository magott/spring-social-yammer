package org.springframework.social.yammer.api.impl;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.social.RateLimitExceededException;

public class ApiErrorTest extends AbstractYammerApiTest{

	@Test(expected=RateLimitExceededException.class)
	public void testRateLimitExceeded(){
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/users.json?page=1&reverse=false"))
				.andExpect(method(GET))
				.andRespond(withResponse(jsonResource("rate-limit-error.json"), responseHeaders, HttpStatus.valueOf(401),""));
		yammerTemplate.userOperations().getUsers(1);		
	}
	
	@Test
	public void test(){
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/users.json?page=1&reverse=false"))
		.andExpect(method(GET))
		.andRespond(withResponse("", responseHeaders, HttpStatus.valueOf(401),""));
		yammerTemplate.userOperations().getUsers(1);		
	}
}
