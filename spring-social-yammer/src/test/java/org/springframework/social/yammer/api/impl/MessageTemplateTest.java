package org.springframework.social.yammer.api.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;

public class MessageTemplateTest extends AbstractYammerApiTest {

	@Test
	public void testGetUserInfoById() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages.json")).andExpect(method(GET))
				.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessages(0, 0, null, 0);
		assertMessageInfo(messageInfo);
	}

	@Test
	public void testGetUserInfoById_withParams() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages.json?older_than=10000&newer_than=1&threaded=true&limit=10")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessages(10000, 1, "true", 10);
		assertMessageInfo(messageInfo);
	}

	/**
	 * @param messageInfo
	 */
	private void assertMessageInfo(MessageInfo messageInfo) {
		List<YammerMessage> messages = messageInfo.getMessages();
		YammerMessageMeta metadata = messageInfo.getMetadata();
		assertCollectionNotEmpty(messages);
		assertCollectionNotEmpty(metadata.getBookmarkedMessageIds());

	}
	
	private void assertCollectionNotEmpty(Collection<?> collection){
		assertThat(CollectionUtils.isEmpty(collection), is(false));
	}

}
