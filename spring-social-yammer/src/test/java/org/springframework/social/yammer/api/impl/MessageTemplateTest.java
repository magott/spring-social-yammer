package org.springframework.social.yammer.api.impl;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.social.yammer.api.MessageInfo;
import org.springframework.social.yammer.api.YammerMessage;
import org.springframework.social.yammer.api.YammerMessage.Attachment;
import org.springframework.social.yammer.api.YammerMessageMeta;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.social.yammer.api.MessageOperations.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class MessageTemplateTest extends AbstractYammerApiTest {

	@Test
	public void testGetMessages() {
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages.json")).andExpect(method(GET))
				.andRespond(withSuccess(jsonResource("testdata/yammer-messages"), APPLICATION_JSON));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessages(0, 0, null, 0);
		assertMessageInfo(messageInfo);
	}

	@Test
	public void testGetMessages_withParams() {
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages.json?older_than=10000&newer_than=1&threaded=true&limit=10")).andExpect(method(GET))
		.andRespond(withSuccess(jsonResource("testdata/yammer-messages"), APPLICATION_JSON));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessages(10000, 1, THREADED, 10);
		assertMessageInfo(messageInfo);
	}

	@Test
	public void testGetMessagesFollowing() {
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/following.json")).andExpect(method(GET))
		.andRespond(withSuccess(jsonResource("testdata/yammer-messages"), APPLICATION_JSON));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesFollowing(0,0,null,0);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesFollowing_withParams() {
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/following.json?older_than=10000&newer_than=1&threaded=true&limit=10")).andExpect(method(GET))
		.andRespond(withSuccess(jsonResource("testdata/yammer-messages"), APPLICATION_JSON));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesFollowing(10000, 1, THREADED, 10);
		assertMessageInfo(messageInfo);
	}

	@Test
	public void testGetMessagesSent() {
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/sent.json")).andExpect(method(GET))
		.andRespond(withSuccess(jsonResource("testdata/yammer-messages"), APPLICATION_JSON));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesSent(0,0,null,0);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesSent_withParams() {
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/sent.json?older_than=10000&newer_than=1&threaded=extended&limit=10")).andExpect(method(GET))
		.andRespond(withSuccess(jsonResource("testdata/yammer-messages"), APPLICATION_JSON));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesSent(10000, 1, THREADED_EXTENDED, 10);
		assertMessageInfo(messageInfo);
	}
	@Test
	public void testGetMessagesPrivate() {
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/private.json")).andExpect(method(GET))
		.andRespond(withSuccess(jsonResource("testdata/yammer-messages"), APPLICATION_JSON));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesPrivate(0,0,null,0);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesPrivate_withParams() {
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/private.json?older_than=10000&newer_than=1&threaded=true&limit=10")).andExpect(method(GET))
		.andRespond(withSuccess(jsonResource("testdata/yammer-messages"), APPLICATION_JSON));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesPrivate(10000, 1,THREADED, 10);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesReceived() {
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/received.json")).andExpect(method(GET))
		.andRespond(withSuccess(jsonResource("testdata/yammer-messages"), APPLICATION_JSON));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesReceived(0,0,null,0);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesReceived_withParams() {
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/received.json?older_than=10000&newer_than=1&threaded=true&limit=10")).andExpect(method(GET))
		.andRespond(withSuccess(jsonResource("testdata/yammer-messages"), APPLICATION_JSON));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesReceived(10000, 1, "true", 10);
		assertMessageInfo(messageInfo);
	}
	@Test
	public void testGetMessagesFromUser() {
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/from_user/"+123+".json")).andExpect(method(GET))
		.andRespond(withSuccess(jsonResource("testdata/yammer-messages"), APPLICATION_JSON));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesFromUser(123,0,0,null,0);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesFromUser_withParams() {
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/from_user/"+123+".json?older_than=10000&newer_than=1&threaded=true&limit=10")).andExpect(method(GET))
		.andRespond(withSuccess(jsonResource("testdata/yammer-messages"), APPLICATION_JSON));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesFromUser(123,10000, 1, "true", 10);
		assertMessageInfo(messageInfo);
	}
	@Test
	public void testGetMessagesAboutTopic() {
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/about_topic/"+123+".json")).andExpect(method(GET))
		.andRespond(withSuccess(jsonResource("testdata/yammer-messages"), APPLICATION_JSON));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesAboutTopic(123,0,0,null,0);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesAboutTopic_withParams() {
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/about_topic/"+123+".json?older_than=10000&newer_than=1&threaded=true&limit=10")).andExpect(method(GET))
		.andRespond(withSuccess(jsonResource("testdata/yammer-messages"), APPLICATION_JSON));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesAboutTopic(123,10000, 1, "true", 10);
		assertMessageInfo(messageInfo);
	}
	@Test
	public void testGetMessagesLikedBy() {
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/liked_by/"+123+".json")).andExpect(method(GET))
		.andRespond(withSuccess(jsonResource("testdata/yammer-messages"), APPLICATION_JSON));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesLikedByUser(123,0,0,NO_THREADING,0);
		assertMessageInfo(messageInfo);
	}
	
	@Test
	public void testGetMessagesLikedBy_withParams() {
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/liked_by/"+123+".json?older_than=10000&newer_than=1&threaded=true&limit=10")).andExpect(method(GET))
		.andRespond(withSuccess(jsonResource("testdata/yammer-messages"), APPLICATION_JSON));
		MessageInfo messageInfo = yammerTemplate.messageOperations().getMessagesLikedByUser(123,10000, 1, THREADED, 10);
		assertMessageInfo(messageInfo);
	}
	@Test
	public void testLikeMessage() {
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/liked_by/current.json?message_id=123"))
		.andExpect(method(POST))
        .andRespond(withSuccess("", MediaType.TEXT_PLAIN));
		yammerTemplate.messageOperations().like(123L);
	}
	@Test
	public void testUnlikeMessage() {
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/liked_by/current.json?message_id=123"))
		.andExpect(method(DELETE))
		.andRespond(withSuccess());
		yammerTemplate.messageOperations().unlike(123L);
	}
	@Test
	public void testDeleteMessage() {
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages/123"))
		.andExpect(method(DELETE))
		.andRespond(withSuccess());
		yammerTemplate.messageOperations().delete(123L);
	}
	
	@Test
	public void testPostUpdate(){
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages.json"))
		.andExpect(content().string("body=Hello"))
		.andExpect(method(POST))
		.andRespond(withSuccess(jsonResource("testdata/yammer-messages"), APPLICATION_JSON));
		yammerTemplate.messageOperations().postUpdate("Hello");
	}
	@Test
	public void testPostUpdate_withParams(){
		mockServer.expect(requestTo("https://www.yammer.com/api/v1/messages.json"))
		.andExpect(content().string("body=Hello&replied_to_id=1"))
		.andExpect(method(POST))
		.andRespond(withSuccess(jsonResource("testdata/yammer-messages"), APPLICATION_JSON));
		YammerPostDetails details = new YammerPostDetails();
		details.setReplyToId(1L);
		yammerTemplate.messageOperations().postUpdate("Hello",details);
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
		assertThat(yammerMessage.getSharedMessageId(), equalTo(0L));
		assertThat(yammerMessage.getSenderId(), equalTo(4022984L));
		assertThat(yammerMessage.getRepliedToId(), nullValue());
		assertThat(yammerMessage.getMessageType(), equalTo("update"));
		assertThat(yammerMessage.getLikedBy().getCount(), equalTo(1));
		assertThat(yammerMessage.getLikedBy().getNames().get(0).getUserId(), equalTo(5700203L));
		assertThat(yammerMessage.getLikedBy().getNames().size(), equalTo(1));
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
