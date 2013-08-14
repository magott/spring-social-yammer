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
import org.springframework.http.MediaType;
import org.springframework.social.yammer.api.YammerThread;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Morten Andersen-Gott
 *
 */
public class ThreadTemplateTest extends AbstractYammerApiTest {

	@Test
	public void testGetThread(){
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/threads/123.json")).andExpect(method(GET))
				.andRespond(withSuccess(jsonResource("testdata/yammer-thread"), MediaType.APPLICATION_JSON));
		YammerThread thread = yammerTemplate.threadOperations().getThread(123L);
		assertThat(thread, notNullValue());
		assertThread(thread);
	}

	/**
	 * @param thread
	 */
	private void assertThread(YammerThread thread) {
		assertThat(thread.hasAttachements(), equalTo(true));
		assertThat(thread.getId(), equalTo(110012127L));
		assertThat(thread.getPrivacy(), equalTo("public"));
		assertThat(thread.getThreadStarterId(), equalTo(110012127L));
		assertThat(thread.getTopics().size(), equalTo(2));
		assertThat(thread.getType(), equalTo("thread"));
		assertThat(thread.getWebUrl(), equalTo("https://www.yammer.com/company.com#/Threads/show?threadId=110012127"));
		assertThat(thread.getMessageCount(), equalTo(8));
		assertThat(thread.getFirstReplyId(), equalTo(110016003L));
		assertThat(thread.getLatestReplyId(), equalTo(110323619L));
		assertThat(thread.getFirstReplyDate().getTime(), equalTo(1314170067000L));
		assertThat(thread.getLatestReplyDate().getTime(), equalTo(1314272305000L));
	}
	
}
