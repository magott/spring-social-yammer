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

import org.springframework.social.yammer.api.MessageOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author Morten Andersen-Gott
 *
 */
public class MessageTemplate extends AbstractYammerOperations implements MessageOperations {

	private RestTemplate restTemplate;
	
	/**
	 * @param restTemplate
	 */
	public MessageTemplate(RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
	}

	public MessageInfo getMessages(long olderThan, long newerThan, String threaded, int limit){
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		if(olderThan!=0){
			params.set("older_than", String.valueOf(olderThan));
		}
		if(newerThan!=0){
			params.set("newer_than", String.valueOf(newerThan));
		}
		if(threaded!=null){
			params.set("threaded", String.valueOf(threaded));
		}
		if(limit!=0){
			params.set("limit", String.valueOf(limit));
		}
		return restTemplate.getForObject(buildUri("messages.json"), MessageInfo.class);
	}
	
}
