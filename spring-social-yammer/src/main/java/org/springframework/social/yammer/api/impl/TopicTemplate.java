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

import org.springframework.social.yammer.api.TopicOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @author Morten Andersen-Gott
 *
 */
public class TopicTemplate extends AbstractYammerOperations implements TopicOperations {

	private RestTemplate restTemplate;

	public TopicTemplate(RestTemplate restTemplate){
		this.restTemplate = restTemplate;
	}
	
	public Topic getTopic(long id) {
		return restTemplate.getForObject(buildUri("topics/"+String.valueOf(id)+".json"), Topic.class);
	}

}
