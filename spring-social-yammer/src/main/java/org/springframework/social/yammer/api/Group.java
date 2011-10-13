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

import java.util.Date;

/**
 * @author Morten Andersen-Gott
 * 
 * Represents a group on Yammer
 *
 */
public class Group {

	private String privacy;
	private String webUrl;
	private GroupStats stats;
	private String mugshotUrl;
	private String url;
	private String description;
	private String fullName;
	private String name;
	private long id;
	private Date createdAt;
	
	public Group(String privacy, String webUrl, GroupStats stats, String mugshotUrl, String url, String description,
			String fullName, String name, long id, Date createdAt) {
		this.privacy = privacy;
		this.webUrl = webUrl;
		this.stats = stats;
		this.mugshotUrl = mugshotUrl;
		this.url = url;
		this.description = description;
		this.fullName = fullName;
		this.name = name;
		this.id = id;
		this.createdAt = createdAt;
	}


	public String getPrivacy() {
		return privacy;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public int getMemberCount(){
		return stats.members;
	}

	public int getUpdateCount(){
		return stats.updates;
	}
	public String getMugshotUrl() {
		return mugshotUrl;
	}

	public String getUrl() {
		return url;
	}

	public String getDescription() {
		return description;
	}

	public String getFullName() {
		return fullName;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Group [privacy=").append(privacy).append(", webUrl=").append(webUrl)
				.append(", members=").append(getMemberCount()).append(", updates=").append(getUpdateCount())
				.append(", mugshotUrl=").append(mugshotUrl).append(", url=").append(url)
				.append(", description=").append(description).append(", fullName=").append(fullName).append(", name=")
				.append(name).append(", id=").append(id).append(", createdAt=").append(createdAt).append("]");
		return builder.toString();
	}



	public static class GroupStats{
		private int updates;
		private int members;

		public GroupStats(int updates, int members) {
			this.updates = updates;
			this.members = members;
		}
		
		
	}
}