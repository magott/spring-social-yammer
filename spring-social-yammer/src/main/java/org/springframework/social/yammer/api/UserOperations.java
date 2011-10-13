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
 * Sub-API for User related operations
 * @author Morten Andersen-Gott
 *
 */
public interface UserOperations {

	/**
	 * Convenience constant for sorting by messages
	 */
	public static final String SORT_BY_MESSAGES = "messages";
	
	/**
	 * Convenience constant for sorting by followers
	 */
	public static final String SORT_BY_FOLLOWERS = "followers";

	/**
	 * Get the user profile of the logged in user
	 * @return {@link YammerProfile} of the logged in user
	 */
    YammerProfile getUserProfile();
	
    /**
     * Get user with the given user id
     * @param id of user
     * @return {@link YammerProfile}
     * @throws ResourceNotFoundException if no user corresponds to that Id in your network
     */
	YammerProfile getUser(long id);

	/**
	 * Get user by e-mail
	 * @param email address
	 * @return {@link YammerProfile} with given e-mail or <code>null</code> if no user exists with that e-mail
	 * 
	 */
	YammerProfile getUserByEmail(String email);

	/**
	 * List users
	 * @param page the page number in the result set
	 * @param sortBy sorting key. Valid values are  {@link #SORT_BY_FOLLOWERS} (default) or {@link #SORT_BY_MESSAGES} 
	 * @param reverse <code>true</code> if you want the results in reversed order
	 * @param letter the letter you want the user to start with, or <code>null</code> if you don't want to filter by letter
	 * @return List of {@link YammerProfile}s matching criteria
	 */
	List<YammerProfile> getUsers(int page, String sortBy, boolean reverse, Character letter);

	/**
	 * List users using the yammer defaults by followers.
	 * @param page the page number in the result set
	 * @return List of {@link YammerProfile}s matching criteria
	 */
	List<YammerProfile> getUsers(int page);

	/**
	 * Update user profile
	 * @param userId your user id
	 * @param userInfo your user info
	 */
	void updateProfile(long userId, UserInfo userInfo);

}
