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

import java.util.List;

/**
 * @author Morten Andersen-Gott
 *
 */
public class SearchResults {

	private MessageInfo messages;
	private List<YammerProfile> users;
	private List<Group> groups;
	private SearchStats stats;
	private List<Topic> topics;
	
	public SearchResults(MessageInfo messages, List<YammerProfile> users, List<Group> groups, SearchStats searchStats, List<Topic> topics) {
		this.messages = messages;
		this.users = users;
		this.groups = groups;
		this.stats=searchStats;
		this.topics=topics;
	}

	public MessageInfo getMessages() {
		return messages;
	}

	public List<YammerProfile> getUsers() {
		return users;
	}

	public List<Group> getGroups() {
		return groups;
	}
	
	public List<Topic> getTopics() {
		return topics;
	}
	
	public int getUserCount(){
		return stats.userCount;
	}
	public int getGroupCount(){
		return stats.groupCount;
	}
	public int getMessageCount(){
		return stats.messageCount;
	}
	public int getTopicCount(){
		return stats.topicCount;
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchResults [messages=").append(messages).append(", users=").append(users)
				.append(", groups=").append(groups).append(", stats=").append(stats).append(", topics=").append(topics)
				.append("]");
		return builder.toString();
	}



	public static class SearchStats{
		private int groupCount;
		private int messageCount;
		private int topicCount;
		private int userCount;
		public SearchStats(int groupCount, int messageCount, int topicCount, int userCount) {
			this.groupCount = groupCount;
			this.messageCount = messageCount;
			this.topicCount = topicCount;
			this.userCount = userCount;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("SearchStats [groupCount=").append(groupCount).append(", messageCount=")
					.append(messageCount).append(", topicCount=").append(topicCount).append(", userCount=")
					.append(userCount).append("]");
			return builder.toString();
		}
		
	}
	
	
}
