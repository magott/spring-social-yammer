package org.springframework.social.yammer.api.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
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
import org.springframework.social.yammer.api.MessageInfo;
import org.springframework.social.yammer.api.YammerMessage;
import org.springframework.social.yammer.api.YammerMessage.Attachment;
import org.springframework.social.yammer.api.YammerMessageMeta;
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
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/following.json")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesFollowing(0,0,null,0);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesFollowing_withParams() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/following.json?older_than=10000&newer_than=1&threaded=true&limit=10")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesFollowing(10000, 1, THREADED, 10);
		assertMessageInfo(messageInfo);
	}

	@Test
	public void testGetMessagesSent() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/sent.json")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesSent(0,0,null,0);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesSent_withParams() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/sent.json?older_than=10000&newer_than=1&threaded=extended&limit=10")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesSent(10000, 1, THREADED_EXTENDED, 10);
		assertMessageInfo(messageInfo);
	}
	@Test
	public void testGetMessagesPrivate() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/private.json")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesPrivate(0,0,null,0);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesPrivate_withParams() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/private.json?older_than=10000&newer_than=1&threaded=true&limit=10")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesPrivate(10000, 1,THREADED, 10);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesReceived() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/received.json")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesReceived(0,0,null,0);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesReceived_withParams() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/received.json?older_than=10000&newer_than=1&threaded=true&limit=10")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesReceived(10000, 1, "true", 10);
		assertMessageInfo(messageInfo);
	}
	@Test
	public void testGetMessagesFromUser() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/from_user/"+123+".json")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesFromUser(123,0,0,null,0);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesFromUser_withParams() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/from_user/"+123+".json?older_than=10000&newer_than=1&threaded=true&limit=10")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesFromUser(123,10000, 1, "true", 10);
		assertMessageInfo(messageInfo);
	}
	@Test
	public void testGetMessagesAboutTopic() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/about_topic/"+123+".json")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesAboutTopic(123,0,0,null,0);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesAboutTopic_withParams() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/about_topic/"+123+".json?older_than=10000&newer_than=1&threaded=true&limit=10")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesAboutTopic(123,10000, 1, "true", 10);
		assertMessageInfo(messageInfo);
	}
	@Test
	public void testGetMessagesLikedBy() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/liked_by/"+123+".json")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesLikedByUser(123,0,0,NO_THREADING,0);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesLikedBy_withParams() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/liked_by/"+123+".json?older_than=10000&newer_than=1&threaded=true&limit=10")).andExpect(method(GET))
		.andRespond(withResponse(new ClassPathResource("yammer-messages.json", getClass()), responseHeaders));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesLikedByUser(123,10000, 1, THREADED, 10);
		assertMessageInfo(messageInfo);
	}
	@Test
	public void testLikeMessage() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/liked_by/current.json?message_id=123"))
		.andExpect(method(POST))
		.andRespond(withResponse("", responseHeaders));
		yammerTemplate.messageOperations().like(123L);
	}
	@Test
	public void testUnlikeMessage() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/liked_by/current.json?message_id=123"))
		.andExpect(method(DELETE))
		.andRespond(withResponse("", responseHeaders));
		yammerTemplate.messageOperations().unlike(123L);
	}
	@Test
	public void testDeleteMessage() {
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/123"))
		.andExpect(method(DELETE))
		.andRespond(withResponse("", responseHeaders));
		yammerTemplate.messageOperations().delete(123L);
	}

	private void assertMessageInfo(MessageInfo messageInfo) {
		List<YammerMessage> messages = messageInfo.getMessages();
		YammerMessageMeta metadata = messageInfo.getMetadata();
		assertFirstMessage(messageInfo.getMessages().get(0));
		assertCollectionNotEmpty(messages);
		assertCollectionNotEmpty(metadata.getBookmarkedMessageIds());

	}
	
	private void assertFirstMessage(YammerMessage yammerMessage) {
		assertThat(yammerMessage.getBody().getPlain(), equalTo("message with photo attachment."));
		assertThat(yammerMessage.getBody().getParsed(), equalTo("message with photo attachment."));
		assertThat(yammerMessage.getClientType(), equalTo("Web"));
		assertThat(yammerMessage.getClientUrl(), equalTo("https://www.yammer.com/"));
		assertThat(yammerMessage.isDirectMessage(), is(false));
		assertThat(yammerMessage.isSystemMessage(), is(false));
		assertThat(yammerMessage.getSenderType(), equalTo("user"));
		assertThat(yammerMessage.getNetworkId(), equalTo(104604L));
		assertThat(yammerMessage.getThreadId(), equalTo(84402777L));
		assertThat(yammerMessage.getId(), equalTo(84402777L));
		assertThat(yammerMessage.getSenderId(), equalTo(4022984L));
		assertThat(yammerMessage.getRepliedToId(), nullValue());
		assertThat(yammerMessage.getMessageType(), equalTo("update"));
		assertThat(yammerMessage.getLikedBy().getCount(), equalTo(0));
		assertThat(yammerMessage.getLikedBy().getNames().size(), equalTo(0));
		assertCollectionNotEmpty(yammerMessage.getAttachments());
		assertFirstAttachment(yammerMessage.getAttachments().get(0));
	}

	/**
	 * @param attachment
	 */
	private void assertFirstAttachment(Attachment attachment) {
		assertThat(attachment.getType(), equalTo("image"));
		assertThat(attachment.getId(), equalTo(974915L));
		assertThat(attachment.getyId(), equalTo(857663L));
		assertThat(attachment.getImage(), notNullValue());
		assertThat(attachment.getImage().getUrl(), equalTo("https://www.yammer.com/api/v1/file/857663/Firefly.jpg"));
		assertThat(attachment.getName(), equalTo("Firefly.jpg"));
		assertThat(attachment.getImage().getThumbnailUrl(), equalTo("https://www.yammer.com/api/v1/file/857663/Firefly.jpg?view=thumbnail"));
		assertThat(attachment.getImage().getSize(), equalTo(0L));
	}

	private void assertCollectionNotEmpty(Collection<?> collection){
		assertThat(CollectionUtils.isEmpty(collection), is(false));
	}

}
