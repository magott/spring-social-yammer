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

import java.util.List;

/**
 * @author Morten Andersen-Gott
 *
 */
public class YammerMessageMeta {

	private long currentUserId;
	private String feedName;
	private String feedDescription;
	private int unseenMessageCountFollowing;
	private int unseenMessageCountReceived;
	private List<Long> likedMessageIds;
	private List<Long> favoriteMessageIds;
	private List<Long> followedUserIds;
	private List<Long> bookmarkedMessageIds;
	
	public YammerMessageMeta(long currentUserId, String feedName, String feedDescription,
			int unseenMessageCountFollowing, int unseenMessageCountReceived, List<Long> likedMessageIds,
			List<Long> favoriteMessageIds, List<Long> followedUserIds, List<Long> bookmarkedMessageIds) {
		this.currentUserId = currentUserId;
		this.feedName = feedName;
		this.feedDescription = feedDescription;
		this.unseenMessageCountFollowing = unseenMessageCountFollowing;
		this.unseenMessageCountReceived = unseenMessageCountReceived;
		this.likedMessageIds = likedMessageIds;
		this.favoriteMessageIds = favoriteMessageIds;
		this.followedUserIds = followedUserIds;
		this.bookmarkedMessageIds = bookmarkedMessageIds;
	}

	public long getCurrentUserId() {
		return currentUserId;
	}

	public String getFeedName() {
		return feedName;
	}

	public String getFeedDescription() {
		return feedDescription;
	}

	public int getUnseenMessageCountFollowing() {
		return unseenMessageCountFollowing;
	}

	public int getUnseenMessageCountReceived() {
		return unseenMessageCountReceived;
	}

	public List<Long> getLikedMessageIds() {
		return likedMessageIds;
	}

	public List<Long> getFavoriteMessageIds() {
		return favoriteMessageIds;
	}

	public List<Long> getFollowedUserIds() {
		return followedUserIds;
	}

	public List<Long> getBookmarkedMessageIds() {
		return bookmarkedMessageIds;
	}
	
	
	
	
	
	
}
