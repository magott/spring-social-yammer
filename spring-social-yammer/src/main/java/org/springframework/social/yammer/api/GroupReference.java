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

public class GroupReference extends YammerReference{

	private String name;
	private String fullName;
	private String description;
	private String mugshotUrl;
	
	
	public GroupReference(long id, String url, String webUrl, String name) {
		super(id, url, webUrl);
		this.name= name;
	}
	
	/**
	 * @return the name of the group
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return the description of this group
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * 
	 * @return the full name of this group
	 */
	public String getFullName() {
		return fullName;
	}
	
	public String getMugshotUrl() {
		return mugshotUrl;
	}

	@Override
	public String toString() {
		return "GroupReference [getId()=" + getId() + ", getUrl()=" + getUrl() + ", getWebUrl()=" + getWebUrl() + ", name=" + name
				+ ", fullName=" + fullName + ", description=" + description + ", mugshotUrl=" + mugshotUrl + "]";
	}
	
}
