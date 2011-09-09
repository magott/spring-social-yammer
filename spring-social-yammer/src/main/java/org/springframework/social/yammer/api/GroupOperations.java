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
public interface GroupOperations {

	/**
	 * Convenience constant for sorting by privacy
	 */
	public static final String SORT_BY_PRIVACY = "privacy";

	/**
	 * Convenience constant for sorting by created at
	 */
	public static final String SORT_BY_CREATED_AT = "created_at";

	/**
	 * Convenience constant for sorting by messages
	 */
	public static final String SORT_BY_MESSAGES = "messages";

	/**
	 * Convenience constant for sorting by creator
	 */
	public static final String SORT_BY_CREATOR = "creator";

	/**
	 * Convenience constant for sorting by members
	 */
	public static final String SORT_BY_MEMBERS = "members";

	/**
	 * Retrieves a list of groups as specified by the parameters. Groups are
	 * returned on pages with each page having a maximum of 20 groups.
	 * 
	 * @param page
	 *            number. First page = 1
	 * @param letter
	 *            return groups beginning with the given letter
	 * @param sortBy
	 *            sort key. Valid values are messages | members | privacy |
	 *            created_at | creator
	 * @param reverse
	 *            indicating whether sort should be reversed
	 * @return
	 */
	List<Group> getGroups(int page, Character letter, String sortBy, boolean reverse);

	/**
	 * Returns the group with the given id
	 * 
	 * @param groupId
	 * @return
	 */
	Group getGroup(long groupId);
	
	void createGroup(String name, boolean isPrivate);

	public abstract void leaveGroup(long groupId);

	public abstract void joinGroup(long groupId);

}
