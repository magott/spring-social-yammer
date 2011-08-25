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
public class Topic {

	private String type;
	private String webUrl;
	private String normalizedName;
	private List<TopicExpert> experts;
	private String name;
	private long id;
	
	public Topic(String type, String webUrl, String normalizedName, List<TopicExpert> experts, String name, long id) {
		this.type = type;
		this.webUrl = webUrl;
		this.normalizedName = normalizedName;
		this.experts = experts;
		this.name = name;
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public String getNormalizedName() {
		return normalizedName;
	}

	public List<TopicExpert> getExperts() {
		return experts;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	static class TopicExpert {
		private String type;
		private long id;

		public TopicExpert(String type, long id) {
			this.type = type;
			this.id = id;
		}
		public String getType() {
			return type;
		}
		public long getId() {
			return id;
		}
	
	}
}
