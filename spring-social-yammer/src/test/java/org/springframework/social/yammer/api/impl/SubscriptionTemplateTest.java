/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.yammer.api.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.test.web.client.RequestMatchers.method;
import static org.springframework.test.web.client.RequestMatchers.body;
import static org.springframework.test.web.client.RequestMatchers.requestTo;
import static org.springframework.test.web.client.ResponseCreators.withResponse;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

/**
 * @author Morten Andersen-Gott
 *
 */
public class SubscriptionTemplateTest extends AbstractYammerApiTest {

	@Test
	public void testFollowUser(){
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/subscriptions"))
		.andExpect(method(POST))
		.andExpect(body("target_type=user&target_id=111"))
		.andRespond(withResponse("", responseHeaders));
		yammerTemplate.subscriptionOperations().followUser(111L);		
	}
	@Test
	public void testUnfollowUser(){
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/subscriptions?target_type=user&target_id=111"))
		.andExpect(method(DELETE))
		.andRespond(withResponse("", responseHeaders));
		yammerTemplate.subscriptionOperations().unfollowUser(111L);		
	}
	@Test
	public void testFollowTopic(){
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/subscriptions"))
		.andExpect(method(POST))
		.andExpect(body("target_type=tag&target_id=123"))
		.andRespond(withResponse("", responseHeaders));
		yammerTemplate.subscriptionOperations().followTopic(123L);		
	}
	@Test
	public void testUnfollowTopic(){
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/subscriptions?target_type=tag&target_id=123"))
		.andExpect(method(DELETE))
		.andRespond(withResponse("", responseHeaders));
		yammerTemplate.subscriptionOperations().unfollowTopic(123L);		
	}
	
	@Test
	public void testIsFollowingUser(){
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/subscriptions/to_user/123.json"))
		.andExpect(method(GET))
		.andRespond(withResponse("", responseHeaders));	
		boolean followingUser = yammerTemplate.subscriptionOperations().isFollowingUser(123L);
		assertThat(followingUser, is(true));
	}
	@Test
	public void testIsFollowingUser_404Respons(){
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/subscriptions/to_user/123.json"))
		.andExpect(method(GET))
		.andRespond(withResponse("", responseHeaders,HttpStatus.NOT_FOUND,""));	
		boolean followingUser = yammerTemplate.subscriptionOperations().isFollowingUser(123L);
		assertThat(followingUser, is(false));
	}
	@Test
	public void testIsFollowingTopic(){
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/subscriptions/to_topic/123.json"))
		.andExpect(method(GET))
		.andRespond(withResponse("", responseHeaders));	
		boolean followingUser = yammerTemplate.subscriptionOperations().isFollowingTopic(123L);
		assertThat(followingUser, is(true));
	}
	@Test
	public void testIsFollowingTopic_404Respons(){
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/subscriptions/to_topic/123.json"))
		.andExpect(method(GET))
		.andRespond(withResponse("", responseHeaders,HttpStatus.NOT_FOUND,""));	
		boolean followingUser = yammerTemplate.subscriptionOperations().isFollowingTopic(123L);
		assertThat(followingUser, is(false));
	}
	
}
