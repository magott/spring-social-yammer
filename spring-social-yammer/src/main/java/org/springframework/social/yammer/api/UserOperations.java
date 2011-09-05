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

import org.springframework.social.yammer.api.impl.YammerProfile;

/**
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

    YammerProfile getUserProfile();
	
	YammerProfile getUser(long id);

	YammerProfile getUserByEmail(String email);

	List<YammerProfile> getUsers(int page, String sortBy, boolean reverse, Character letter);

	List<YammerProfile> getUsers(int page);

}
