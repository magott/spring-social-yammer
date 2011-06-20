package org.springframework.social.yammer.api.impl;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;

public class MessageTemplateTest extends AbstractYammerApiTest {

	@Test
	public void testGetUserInfoById() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages.json")).andExpect(method(GET))
				.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessages(0, 0, null, 0);
		assertMessageInfo(messageInfo);
	}

	/**
	 * @param messageInfo
	 */
	private void assertMessageInfo(MessageInfo messageInfo) {
		// TODO Auto-generated method stub

	}

}
