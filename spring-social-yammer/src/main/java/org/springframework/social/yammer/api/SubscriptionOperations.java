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

/**
 * Sub-API for subscriptions (following/unfollowing).
 * @author Morten Andersen-Gott
 *
 */
public interface SubscriptionOperations {

	/**
	 * Follow a user with the given id
	 * @param userId
	 * @throws OperationNotPermittedException if user does not exist
	 */
	void followUser(long userId);
	
	/**
	 * Follow a topic with the given id
	 * @param topicId
	 * @throws OperationNotPermittedException if user does not exist
	 */	
	void followTopic(long topicId);
	
	/**
	 * Check whether you are following the given user
	 * @param userId
	 * @return <code>true</code> if you are following the user, otherwise <code>false</code>
	 */
	boolean isFollowingUser(long userId);
	
	/**
	 * Check whether you are following the given topic
	 * @param topicId
	 * @return <code>true</code> if you are following the topic, otherwise <code>false</code>
	 */	
	boolean isFollowingTopic(long topicId);

	/**
	 * Check whether you are following the given thread
	 * @param threadId
	 * @return <code>true</code> if you are following the thread, otherwise <code>false</code>
	 */
	boolean isFollowingThread(long threadId);

	/**
	 * Stop following a topic
	 * @param topicId
	 */
	void unfollowTopic(long topicId);

	/**
	 * Stop following a user
	 * @param userId
	 */
	void unfollowUser(long userId);
	
}
