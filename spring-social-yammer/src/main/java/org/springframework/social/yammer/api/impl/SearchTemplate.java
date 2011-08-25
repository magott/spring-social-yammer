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

import org.springframework.social.yammer.api.SearchOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author Morten Andersen-Gott
 *
 */
public class SearchTemplate extends AbstractYammerOperations implements SearchOperations {

	private RestTemplate restTemplate;
	
	public SearchTemplate(RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
	}
	
	public SearchResults search(String searchString){
		return search(searchString, 1);
	}
	
	public SearchResults search(String searchString, int page){
		return search(searchString, page, 20);
	}
	
	public SearchResults search(String searchString, int page, int numberPerPage){
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.set("search", searchString);
		params.set("page", String.valueOf(page));
		params.set("number_per_page", String.valueOf(numberPerPage));
		return restTemplate.getForObject(buildUri("search.json", params), SearchResults.class);
	}

}
