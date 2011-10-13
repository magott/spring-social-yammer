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

import org.springframework.social.ResourceNotFoundException;

/**
 * Sub-API for all Group related methods
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
	 *            sort key. Valid values are {@value #SORT_BY_CREATOR} | {@value #SORT_BY_MEMBERS} | {@value #SORT_BY_PRIVACY} |
	 *             {@value #SORT_BY_CREATED_AT} | {@value #SORT_BY_MESSAGES}.
	 *            Use convenience constants
	 * @param reverse
	 *            indicating whether sort should be reversed
	 * @return <code>List</code> of {@link Group}s
	 */
	List<Group> getGroups(int page, Character letter, String sortBy, boolean reverse);

	/**
	 * Returns the group with the given id
	 * 
	 * @param groupId
	 * @return Group for given id
	 * @throws ResourceNotFoundException if there is no group with the given id in the network
	 */
	Group getGroup(long groupId);

	/**
	 * Create a new group
	 * @param name of group
	 * @param isPrivate whether the group is public (anyone can join) or private
	 */
	void createGroup(String name, boolean isPrivate);

	/**
	 * Join group with given group id
	 * @param groupId
	 * @throws ResourceNotFoundException if you are not a member of that group or group does not exist
	 */
	void leaveGroup(long groupId);

	/**
	 * Join a group with given group id
	 * @param groupId
	 * @throws ResourceNotFoundException if that group does not exist in your network 
	 */
	void joinGroup(long groupId);

}
