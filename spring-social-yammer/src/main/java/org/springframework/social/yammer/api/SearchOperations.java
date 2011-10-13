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


/**
 * Sub-API for search operations
 * @author Morten Andersen-Gott
 *
 */
public interface SearchOperations {

	/**
	 * Search among messages, users, tags and groups for the given string
	 * @param searchString
	 * @return search results potentially containing messages, users, tags and groups as well as stats
	 */
	SearchResults search(String searchString);
	
	/**
	 * Search among messages, users, tags and groups for the given string
	 * @param searchString
	 * @param page the page number in the search result (max 50 results per page)
	 * @return search results potentially containing messages, users, tags and groups as well as stats
	 */
	SearchResults search(String searchString, int page);
	
	/**
	 * Search among messages, users, tags and groups for the given string
	 * @param searchString
	 * @param page the page number in the search result
	 * @param numberPerPage number of results per page (max 50)
	 * @return search results potentially containing messages, users, tags and groups as well as stats
	 */
	SearchResults search(String searchString, int page, int numberPerPage);
	
}
