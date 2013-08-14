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

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.yammer.api.GroupOperations;
import org.springframework.social.yammer.api.MessageOperations;
import org.springframework.social.yammer.api.SearchOperations;
import org.springframework.social.yammer.api.SubscriptionOperations;
import org.springframework.social.yammer.api.ThreadOperations;
import org.springframework.social.yammer.api.TopicOperations;
import org.springframework.social.yammer.api.UserOperations;
import org.springframework.social.yammer.api.Yammer;
import org.springframework.social.yammer.api.impl.json.YammerModule;
import org.springframework.web.client.RestTemplate;

/**
 * @author Morten Andersen-Gott
 *
 */
public class YammerTemplate extends AbstractOAuth2ApiBinding implements Yammer{
	
	private UserOperations userOperations;
	private MessageOperations messageOperations;
	private GroupOperations groupOperations;
	private SearchOperations searchOperations;
	private TopicOperations topicOperations;
	private SubscriptionOperations subscriptionOperations;
	private ThreadOperations threadOperations;
	
	public YammerTemplate(String accessToken) {
		super(accessToken);
		initSubApis();
	}

	public UserOperations userOperations(){
		return userOperations;
	}
	
	public MessageOperations messageOperations(){
		return messageOperations;
	}
	
	public GroupOperations groupOperations(){
		return groupOperations;
	}
	
	public SearchOperations searchOperations(){
		return searchOperations;
	}
	
	public TopicOperations topicOperations(){
		return topicOperations;
	}
	
	public SubscriptionOperations subscriptionOperations(){
		return subscriptionOperations;
	}
	
	public ThreadOperations threadOperations(){
		return threadOperations;
	}
	
	@Override
	protected void configureRestTemplate(RestTemplate restTemplate) {
		restTemplate.setErrorHandler(new YammerErrorHandler());
	}
	
	private void initSubApis() {
		userOperations = new UserTemplate(getRestTemplate());
		messageOperations = new MessageTemplate(getRestTemplate());
		groupOperations = new GroupTemplate(getRestTemplate());
		searchOperations = new SearchTemplate(getRestTemplate());
		topicOperations = new TopicTemplate(getRestTemplate());
		subscriptionOperations = new SubscriptionTemplate(getRestTemplate());
		threadOperations = new ThreadTemplate(getRestTemplate());
	}

    @Override
    protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
        MappingJackson2HttpMessageConverter jsonMessageConverter = super.getJsonMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new YammerModule());
        jsonMessageConverter.setObjectMapper(objectMapper);
        return jsonMessageConverter;
    }

}
