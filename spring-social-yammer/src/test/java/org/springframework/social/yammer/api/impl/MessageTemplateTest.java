package org.springframework.social.yammer.api.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import static org.springframework.social.yammer.api.MessageOperations.NO_THREADING;
import static org.springframework.social.yammer.api.MessageOperations.THREADED;
import static org.springframework.social.yammer.api.MessageOperations.THREADED_EXTENDED;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;

public class MessageTemplateTest extends AbstractYammerApiTest {

	@Test
	public void testGetMessages() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages.json")).andExpect(method(GET))
				.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessages(0, 0, null, 0);
		assertMessageInfo(messageInfo);
	}

	@Test
	public void testGetMessages_withParams() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages.json?older_than=10000&newer_than=1&threaded=true&limit=10")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessages(10000, 1, THREADED, 10);
		assertMessageInfo(messageInfo);
	}

	@Test
	public void testGetMessagesFollowing() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/following.json")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesFollowing(0,0,null,0);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesFollowing_withParams() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/following.json?older_than=10000&newer_than=1&threaded=true&limit=10")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesFollowing(10000, 1, THREADED, 10);
		assertMessageInfo(messageInfo);
	}

	@Test
	public void testGetMessagesSent() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/sent.json")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesSent(0,0,null,0);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesSent_withParams() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/sent.json?older_than=10000&newer_than=1&threaded=extended&limit=10")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesSent(10000, 1, THREADED_EXTENDED, 10);
		assertMessageInfo(messageInfo);
	}
	@Test
	public void testGetMessagesPrivate() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/private.json")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesPrivate(0,0,null,0);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesPrivate_withParams() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/private.json?older_than=10000&newer_than=1&threaded=true&limit=10")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesPrivate(10000, 1,THREADED, 10);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesReceived() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/received.json")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesReceived(0,0,null,0);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesReceived_withParams() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/received.json?older_than=10000&newer_than=1&threaded=true&limit=10")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesReceived(10000, 1, "true", 10);
		assertMessageInfo(messageInfo);
	}
	@Test
	public void testGetMessagesFromUser() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/from_user/"+123+".json")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesFromUser(123,0,0,null,0);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesFromUser_withParams() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/from_user/"+123+".json?older_than=10000&newer_than=1&threaded=true&limit=10")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesFromUser(123,10000, 1, "true", 10);
		assertMessageInfo(messageInfo);
	}
	@Test
	public void testGetMessagesAboutTopic() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/about_topic/"+123+".json")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesAboutTopic(123,0,0,null,0);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesAboutTopic_withParams() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/about_topic/"+123+".json?older_than=10000&newer_than=1&threaded=true&limit=10")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesAboutTopic(123,10000, 1, "true", 10);
		assertMessageInfo(messageInfo);
	}
	@Test
	public void testGetMessagesLikedBy() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/liked_by/"+123+".json")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesLikedByUser(123,0,0,NO_THREADING,0);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesLikedBy_withParams() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/liked_by/"+123+".json?older_than=10000&newer_than=1&threaded=true&limit=10")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesLikedByUser(123,10000, 1, THREADED, 10);
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
