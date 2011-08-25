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

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.social.yammer.api.SubscriptionOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @author Morten Andersen-Gott
 *
 */
public class SubscriptionTemplate extends AbstractYammerOperations implements SubscriptionOperations {

	private RestTemplate restTemplate;

	public SubscriptionTemplate(RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
	}
	
	public void followUser(long userId) {
		follow("user",userId);
	}

	public void followTopic(long topicId) {
		follow("tag", topicId);
	}
	
	public void unfollowUser(long userId) {
		unfollow("user",userId);
	}
	
	public void unfollowTopic(long topicId) {
		unfollow("tag", topicId);
	}

	public boolean isFollowingUser(long userId) {
		return isFollowing(buildUri("subscriptions/to_user/"+ userId + ".json"));
	}
	public boolean isFollowingTopic(long topicId) {
		return isFollowing(buildUri("subscriptions/to_topic/"+ topicId + ".json"));
	}
	
	public boolean isFollowingThread(long threadId) {
		return isFollowing(buildUri("subscriptions/to_thread/"+ threadId + ".json"));
	}
	
	private void follow(String targetType, long id){
		MultiValueMap<String, String> params = toParams(targetType, id);
		restTemplate.postForObject(buildUri("subscriptions"), params, String.class);
	}
	
	private void unfollow(String targetType, long id){
		MultiValueMap<String, String> params = toParams(targetType, id);
		restTemplate.delete(buildUri("subscriptions",params));
	}

	private MultiValueMap<String, String> toParams(String targetType, long id) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("target_type", targetType);
		params.set("target_id", String.valueOf(id));
		return params;
	}

	private boolean isFollowing(URI url) {
		try{
			restTemplate.getForObject(url, String.class);
			return true;
		}catch(HttpClientErrorException ex){
			if(ex.getStatusCode() == HttpStatus.NOT_FOUND){
				return false;
			}else{
				throw ex;
			}
		}
	}


}
