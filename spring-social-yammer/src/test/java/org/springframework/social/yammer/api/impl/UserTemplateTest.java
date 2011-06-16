package org.springframework.social.yammer.api.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;

public class UserTemplateTest extends AbstractYammerApiTest{
	
	@Test
	public void canGetUserInfoForId(){
		Long id = 4022983L;
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/users/"+id+".json"))
				.andExpect(method(GET))
				.andRespond(withResponse(new ClassPathResource("yammer-user.json", getClass()), responseHeaders));
		YammerProfile yProfile = yammerTemplate.userOperations().getUser(id);
		assertThat(yProfile.getId(), equalTo(id));
	}
	
	
}
