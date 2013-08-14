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
import org.springframework.social.yammer.api.Topic;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Morten Andersen-Gott
 *
 */
public class TopicTemplateTest extends AbstractYammerApiTest{

	@Test
	public void testGetTopic(){
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/topics/123.json")).andExpect(method(GET))
				.andRespond(withSuccess(jsonResource("testdata/yammer-topic"), APPLICATION_JSON));
		
		Topic topic = yammerTemplate.topicOperations().getTopic(123L);
		assertThat(topic, notNullValue());
		assertThat(topic.getId(), equalTo(712836L));
		
	}



}
