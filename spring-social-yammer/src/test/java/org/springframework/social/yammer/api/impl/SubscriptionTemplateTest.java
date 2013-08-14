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

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Morten Andersen-Gott
 *
 */
public class SubscriptionTemplateTest extends AbstractYammerApiTest {

	@Test
	public void testFollowUser(){
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/subscriptions"))
		.andExpect(method(POST))
		.andExpect(content().string("target_type=user&target_id=111"))
        .andRespond(withSuccess("", MediaType.TEXT_PLAIN));
		yammerTemplate.subscriptionOperations().followUser(111L);		
	}
	@Test
	public void testUnfollowUser(){
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/subscriptions?target_type=user&target_id=111"))
		.andExpect(method(DELETE))
        .andRespond(withSuccess("", MediaType.TEXT_PLAIN));
		yammerTemplate.subscriptionOperations().unfollowUser(111L);		
	}
	@Test
	public void testFollowTopic(){
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/subscriptions"))
		.andExpect(method(POST))
		.andExpect(content().string("target_type=tag&target_id=123"))
		.andRespond(withSuccess("", APPLICATION_JSON));
		yammerTemplate.subscriptionOperations().followTopic(123L);		
	}
	@Test
	public void testUnfollowTopic(){
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/subscriptions?target_type=tag&target_id=123"))
		.andExpect(method(DELETE))
		.andRespond(withSuccess("", APPLICATION_JSON));
		yammerTemplate.subscriptionOperations().unfollowTopic(123L);		
	}
	
	@Test
	public void testIsFollowingUser(){
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/subscriptions/to_user/123.json"))
		.andExpect(method(GET))
		.andRespond(withSuccess("",APPLICATION_JSON));
		boolean followingUser = yammerTemplate.subscriptionOperations().isFollowingUser(123L);
		assertThat(followingUser, is(true));
	}
	@Test
	public void testIsFollowingUser_404Respons(){
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/subscriptions/to_user/123.json"))
		.andExpect(method(GET))
		.andRespond(withStatus(HttpStatus.NOT_FOUND));
		boolean followingUser = yammerTemplate.subscriptionOperations().isFollowingUser(123L);
		assertThat(followingUser, is(false));
	}
	@Test
	public void testIsFollowingTopic(){
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/subscriptions/to_topic/123.json"))
		.andExpect(method(GET))
		.andRespond(withSuccess("",APPLICATION_JSON));
		boolean followingUser = yammerTemplate.subscriptionOperations().isFollowingTopic(123L);
		assertThat(followingUser, is(true));
	}
	@Test
	public void testIsFollowingTopic_404Respons(){
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/subscriptions/to_topic/123.json"))
		.andExpect(method(GET))
		.andRespond(withStatus(HttpStatus.NOT_FOUND));
		boolean followingUser = yammerTemplate.subscriptionOperations().isFollowingTopic(123L);
		assertThat(followingUser, is(false));
	}
	
}
