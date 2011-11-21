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

import org.springframework.social.OperationNotPermittedException;
import org.springframework.social.yammer.api.impl.YammerPostDetails;

/**
 * Sub-API for all message related operations
 * @author Morten Andersen-Gott
 * 
 */
public interface MessageOperations {

	/**
	 * Convenience constant for viewing messages by thread. Will return first
	 * message of each thread.
	 */
	public static final String THREADED = "true";

	/**
	 * Convenience constant for viewing messages as extended threads. Will
	 * return first message of each thread and the last two messages of each
	 * thread.
	 */
	public static final String THREADED_EXTENDED = "extended";

	/**
	 * Convenience constant not threading Will return first message of each
	 * thread and the last two messages of each thread.
	 */
	public static final String NO_THREADING = null;

	/**
	 * Gets messages from the company feed, essentially all messages posted in a Yammer network
	 * 
	 * @param olderThan
	 *            return only messages older than this message id
	 * @param newerThan
	 *            return only messages newer than this message id
	 * @param threadedView
	 *            type of threaded view or null if no threaded view is required.
	 *            Valid values are: 
	 *            {@link #THREADED_EXTENDED}: return first message of thread and two most recent messages of thread,
	 *            {@link #THREADED}: returns first message of each thread,
	 *            {@link #NO_THREADING}: no threading
	 * @param limit the limit of number of messages returned (50 max)
	 * @return MessageInfo containing meta data and a list of messages
	 * 
	 * @see #THREADED
	 * @see #THREADED_EXTENDED
	 * @see #NO_THREADING
	 */	
	MessageInfo getMessages(long olderThan, long newerThan, String threadedView, int limit);

	/**
	 * Lets the logged in user like a message
	 * @param messageId id to like
	 */
	void like(long messageId);

	/**
	 * Unlike a message that has previously been liked by logged in user
	 * @param messageId id to unlike
	 */
	void unlike(long messageId);

	/**
	 * Gets the message posted by a given user
	 * 
	 * @param userId
	 *            the user id you want to see the messages for
	 * @param olderThan
	 *            return only messages older than this message id
	 * @param newerThan
	 *            return only messages newer than this message id
	 * @param threadedView
	 *            type of threaded view or null if no threaded view is required.
	 *            Valid values are: 
	 *            {@link #THREADED_EXTENDED}: return first message of thread and two most recent messages of thread,
	 *            {@link #THREADED}: returns first message of each thread,
	 *            {@link #NO_THREADING}: no threading
	 * @param limit the limit of number of messages returned (50 max)
	 * @return MessageInfo containing meta data and a list of messages
	 * 
	 * @see #THREADED
	 * @see #THREADED_EXTENDED
	 * @see #NO_THREADING
	 */
	MessageInfo getMessagesFromUser(long userId, long olderThan, long newerThan, String threadedView, int limit);

	/**
	 * Gets your private messages
	 * 
	 * @param olderThan
	 *            return only messages older than this message id
	 * @param newerThan
	 *            return only messages newer than this message id
	 * @param threadedView
	 *            type of threaded view or null if no threaded view is required.
	 *            Valid values are: 
	 *            {@link #THREADED_EXTENDED}: return first message of thread and two most recent messages of thread,
	 *            {@link #THREADED}: returns first message of each thread,
	 *            {@link #NO_THREADING}: no threading
	 * @param limit the limit of number of messages returned (50 max)
	 * @return MessageInfo containing meta data and a list of messages
	 * 
	 * @see #THREADED
	 * @see #THREADED_EXTENDED
	 * @see #NO_THREADING
	 */
	MessageInfo getMessagesPrivate(long olderThan, long newerThan, String threadedView, int limit);

	/**
	 * Gets your sent messages
	 * 
	 * @param olderThan
	 *            return only messages older than this message id
	 * @param newerThan
	 *            return only messages newer than this message id
	 * @param threadedView
	 *            type of threaded view or null if no threaded view is required.
	 *            Valid values are: 
	 *            {@link #THREADED_EXTENDED}: return first message of thread and two most recent messages of thread,
	 *            {@link #THREADED}: returns first message of each thread,
	 *            {@link #NO_THREADING}: no threading
	 * @param limit the limit of number of messages returned (50 max)
	 * @return MessageInfo containing meta data and a list of messages
	 * 
	 * @see #THREADED
	 * @see #THREADED_EXTENDED
	 * @see #NO_THREADING
	 */	
	MessageInfo getMessagesSent(long olderThan, long newerThan, String threadedView, int limit);

	/**
	 * Gets messages from groups, topics and users you are following
	 * 
	 * @param olderThan
	 *            return only messages older than this message id
	 * @param newerThan
	 *            return only messages newer than this message id
	 * @param threadedView
	 *            type of threaded view or null if no threaded view is required.
	 *            Valid values are: 
	 *            {@link #THREADED_EXTENDED}: return first message of thread and two most recent messages of thread,
	 *            {@link #THREADED}: returns first message of each thread,
	 *            {@link #NO_THREADING}: no threading
	 * @param limit the limit of number of messages returned (50 max)
	 * @return MessageInfo containing meta data and a list of messages
	 * 
	 * @see #THREADED
	 * @see #THREADED_EXTENDED
	 * @see #NO_THREADING
	 */
	MessageInfo getMessagesFollowing(long olderThan, long newerThan, String threadedView, int limit);

	/**
	 * Gets messages you've received
	 * 
	 * @param olderThan
	 *            return only messages older than this message id
	 * @param newerThan
	 *            return only messages newer than this message id
	 * @param threadedView
	 *            type of threaded view or null if no threaded view is required.
	 *            Valid values are: 
	 *            {@link #THREADED_EXTENDED}: return first message of thread and two most recent messages of thread,
	 *            {@link #THREADED}: returns first message of each thread,
	 *            {@link #NO_THREADING}: no threading
	 * @param limit the limit of number of messages returned (50 max)
	 * @return MessageInfo containing meta data and a list of messages
	 * 
	 * @see #THREADED
	 * @see #THREADED_EXTENDED
	 * @see #NO_THREADING
	 */
	MessageInfo getMessagesReceived(long olderThan, long newerThan, String threadedView, int limit);

	/**
	 * Gets messages on a specified topic
	 * 
	 * @param topicId the id of the topic for which you want to see messages
	 * @param olderThan
	 *            return only messages older than this message id
	 * @param newerThan
	 *            return only messages newer than this message id
	 * @param threadedView
	 *            type of threaded view or null if no threaded view is required.
	 *            Valid values are: 
	 *            {@link #THREADED_EXTENDED}: return first message of thread and two most recent messages of thread,
	 *            {@link #THREADED}: returns first message of each thread,
	 *            {@link #NO_THREADING}: no threading
	 * @param limit the limit of number of messages returned (50 max)
	 * @return MessageInfo containing meta data and a list of messages
	 * 
	 * @see #THREADED
	 * @see #THREADED_EXTENDED
	 * @see #NO_THREADING
	 */
	MessageInfo getMessagesAboutTopic(long topicId, long olderThan, long newerThan, String threadedView, int limit);

	/**
	 * Gets messages liked by a specified user
	 * 
	 * @param userId of the person who've liked the messages
	 * @param olderThan
	 *            return only messages older than this message id
	 * @param newerThan
	 *            return only messages newer than this message id
	 * @param threadedView
	 *            type of threaded view or null if no threaded view is required.
	 *            Valid values are: 
	 *            {@link #THREADED_EXTENDED}: return first message of thread and two most recent messages of thread,
	 *            {@link #THREADED}: returns first message of each thread,
	 *            {@link #NO_THREADING}: no threading
	 * @param limit the limit of number of messages returned (50 max)
	 * @return MessageInfo containing meta data and a list of messages
	 * 
	 * @see #THREADED
	 * @see #THREADED_EXTENDED
	 * @see #NO_THREADING
	 */	
	MessageInfo getMessagesLikedByUser(long userId, long olderThan, long newerThan, String threadedView, int limit);

	/**
	 * Get all messages for a thread
	 * @param threadId id of the thread for which messages will be returned
	 * @param olderThan
	 *            return only messages older than this message id
	 * @param newerThan
	 *            return only messages newer than this message id
	 * @param limit the limit of number of messages returned (50 max)
	 * @return MessageInfo containing meta data and a list of messages
	 */
	MessageInfo getMessagesInThread(long threadId, long olderThan, long newerThan, int limit);

	/**
	 * Post an update to your network with details (ie attachments etc)
	 * @param message the text part of your message
	 * @param details additional details for your message
	 * @return MessageInfo containing meta data and your newly posted message
	 */
	MessageInfo postUpdate(String message, YammerPostDetails details);

	/**
	 * Post a textual message to your network
	 * @param message
	 * @return MessageInfo containing meta data and your newly posted message
	 */
	MessageInfo postUpdate(String message);

	/**
	 * Deletes a message, current user must be owner
	 * 
	 * @param messageId
	 * @throws OperationNotPermittedException if the message does not exist or you are not the owner of that message
	 */
	void delete(long messageId);


}
