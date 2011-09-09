package org.springframework.social.yammer.api.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.social.yammer.api.UserOperations;
import org.springframework.social.yammer.api.YammerProfile;
import org.springframework.util.StringUtils;

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

	@Test
	public void testGetUserInfoByEmail() throws UnsupportedEncodingException{
		String email = "ilya@users.yammer.com";
		String encodedEmail = StringUtils.replace(email, "@", "%40");
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/users/by_email.json?email="+encodedEmail))
		.andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-users.json", getClass()), responseHeaders));
		YammerProfile yProfile = yammerTemplate.userOperations().getUserByEmail(email);
		assertYammerProfile(yProfile);
	}
	
	@Test
	public void testGetUsers() throws UnsupportedEncodingException{
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/users.json?page=1&sort_by=messages&reverse=false&letter=A"))
		.andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-users.json", getClass()), responseHeaders));
		List<YammerProfile> users = yammerTemplate.userOperations().getUsers(1, UserOperations.SORT_BY_MESSAGES, false, 'A');
		assertYammerProfile(users.get(0));
	}
	@Test
	public void testGetUsers_page() throws UnsupportedEncodingException{
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/users.json?page=1&reverse=false"))
		.andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-users.json", getClass()), responseHeaders));
		List<YammerProfile> users = yammerTemplate.userOperations().getUsers(1);
		assertYammerProfile(users.get(0));
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
		assertThat(yProfile.isAdmin(), is(true));
		assertThat(yProfile.getFullName(), notNullValue());
		assertThat(yProfile.getName(), notNullValue());
		assertThat(yProfile.getUrl(), notNullValue());
		assertThat(yProfile.getSchools(), notNullValue());
		assertThat(yProfile.getSchools().isEmpty(), is(false));
		assertThat(yProfile.getExternalUrls(), notNullValue());
		assertThat(yProfile.getExternalUrls().isEmpty(), is(false));
		assertThat(yProfile.getContact(), notNullValue());
		assertThat(yProfile.getContact(), notNullValue());
		assertThat(yProfile.getJobTitle(), equalTo("Social animal"));
	}
	
	
}
