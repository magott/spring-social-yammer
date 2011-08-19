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
package org.springframework.social.yammer.api;

import org.springframework.social.yammer.api.impl.MessageInfo;
import org.springframework.social.yammer.api.impl.YammerPostDetails;

/**
 * @author Morten Andersen-Gott
 *
 */
public interface MessageOperations {
	
	/**
	 * Convenience constant for viewing messages by thread.
	 * Will return first message of each thread.
	 */
	public static final String THREADED = "true";
	
	/**
	 * Convenience constant for viewing messages as extended threads.
	 * Will return first message of each thread and the last two messages of each thread.
	 */
	public static final String THREADED_EXTENDED = "extended";
	
	/**
	 * Convenience constant not threading
	 * Will return first message of each thread and the last two messages of each thread.
	 */
	public static final String NO_THREADING = null;

	MessageInfo getMessages(long olderThan, long newerThan, String threadedView, int limit);

	void like(long messageId);
	
	void unlike(long messageId);
	
	/**
	 * 
	 * @param userId
	 * @param olderThan
	 * @param newerThan
	 * @param threadedView type of threaded view or null if no threaded view is required. 
	 * @param limit
	 * @return MessageInfo containing meta data and a list of messages
	 * 
	 * @see #THREADED
	 * @see #THREADED_EXTENDED
	 */
	MessageInfo getMessagesFromUser(long userId, long olderThan, long newerThan, String threadedView, int limit);

	MessageInfo getMessagesPrivate(long olderThan, long newerThan, String threadedView, int limit);

	MessageInfo getMessagesSent(long olderThan, long newerThan, String threaded, int limit);

	MessageInfo getMessagesFollowing(long olderThan, long newerThan, String threaded, int limit);

	MessageInfo getMessagesReceived(long olderThan, long newerThan, String threaded, int limit);

	MessageInfo getMessagesAboutTopic(long topicId, long olderThan, long newerThan, String threaded, int limit);

	MessageInfo getMessagesLikedByUser(long userId, long olderThan, long newerThan, String threaded, int limit);

	MessageInfo postUpdate(String message, YammerPostDetails details);

	MessageInfo postUpdate(String message);
	
	/**
	 * Deletes a message, current user must be owner
	 * Bad request (400) in case of not owner or no such message
	 * @param messageId
	 */
	void delete(long messageId);

}
