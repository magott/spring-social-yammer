package org.springframework.social.yammer.api.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
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
	public void testGetUserInfoById(){
		Long id = 4022983L;
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/users/"+id+".json"))
				.andExpect(method(GET))
				.andRespond(withResponse(new ClassPathResource("yammer-user.json", getClass()), responseHeaders));
		YammerProfile yProfile = yammerTemplate.userOperations().getUser(id);
		assertThat(yProfile.getId(), equalTo(id));
		assertYammerProfile(yProfile);
	}

	private void assertYammerProfile(YammerProfile yProfile) {
		assertThat(yProfile.getStats(), notNullValue());
		assertThat(yProfile.getStats().getFollowers(), equalTo(1L));
		assertThat(yProfile.getStats().getFollowing(), equalTo(1L));
		assertThat(yProfile.getStats().getUpdates(), equalTo(1L));
		assertThat(yProfile.getMugshotUrl(), notNullValue());
		assertThat(yProfile.getExpertise(), equalTo("Socializing"));
		assertThat(yProfile.getSummary(), equalTo("A summary"));
		assertThat(yProfile.getType(), notNullValue());
		assertThat(yProfile.getFullName(), notNullValue());
		assertThat(yProfile.getName(), notNullValue());
		assertThat(yProfile.getUrl(), notNullValue());
		assertThat(yProfile.getSchools(), notNullValue());
		assertThat(yProfile.getSchools().isEmpty(), is(false));
		assertThat(yProfile.getExternalUrls(), notNullValue());
		assertThat(yProfile.getExternalUrls().isEmpty(), is(false));
		assertThat(yProfile.getJobTitle(), equalTo("Social animal"));
	}
	
	
}
