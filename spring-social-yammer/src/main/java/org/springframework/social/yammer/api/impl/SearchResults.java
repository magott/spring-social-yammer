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
public class SearchResults {

	private MessageInfo messages;
	private List<YammerProfile> users;
	private List<Group> groups;
	
	public SearchResults(MessageInfo messages, List<YammerProfile> users, List<Group> groups) {
		this.messages = messages;
		this.users = users;
		this.groups = groups;
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
	
	
}
