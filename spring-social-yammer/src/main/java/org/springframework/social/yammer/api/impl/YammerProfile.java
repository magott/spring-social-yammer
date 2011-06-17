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
public class YammerProfile {

	private long id;
	private String mugshotUrl;
	private Stats stats;
	private String type;
	private String url;
	private String fullName;
	private String name;
	private boolean admin;
	private String expertise;
	private String summary;
	private List<School> schools;
	private List<String> externalUrls;
	private String jobTitle;
	
	public YammerProfile(long id, String mugshotUrl, Stats stats, String type, String url, String fullName,
			String name, boolean admin, String expertise, String summary, String jobTitle, List<School> schools, List<String> externalUrls) {
		super();
		this.id = id;
		this.mugshotUrl = mugshotUrl;
		this.stats = stats;
		this.type = type;
		this.url = url;
		this.fullName = fullName;
		this.name = name;
		this.admin = admin;
		this.expertise = expertise;
		this.summary = summary;
		this.jobTitle = jobTitle;
		this.schools = schools;
		this.externalUrls = externalUrls;
	}
	
	
	
	/**
	 * @return the schools
	 */
	public List<School> getSchools() {
		return schools;
	}

	public String getMugshotUrl() {
		return mugshotUrl;
	}
	
	public void setMugshotUrl(String mugshotUrl) {
		this.mugshotUrl = mugshotUrl;
	}
	
	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public void setExternalUrls(List<String> externalUrls) {
		this.externalUrls = externalUrls;
	}



	public List<String> getExternalUrls() {
		return externalUrls;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}



	public String getJobTitle() {
		return jobTitle;
	}

	public static class School {
		private String degree;
		private String name;
		private String description;
		private int startYear;
		private int endYear;
		
		public School(String name, String degree, String description, int startYear, int endYear) {
			super();
			this.name = name;
			this.degree = degree;
			this.description = description;
			this.startYear = startYear;
			this.endYear = endYear;
		}
		
		
		public String getDegree() {
			return degree;
		}
		public String getName() {
			return name;
		}
		public String getDescription() {
			return description;
		}
		public int getStartYear() {
			return startYear;
		}
		public int getEndYear() {
			return endYear;
		}
		
	}
	
	public static class Stats {
		private long followers;
		private long following;
		private long updates;


		public void setFollowers(long followers) {
			this.followers = followers;
		}

		public long getFollowers() {
			return followers;
		}

		public long getFollowing() {
			return following;
		}

		public void setFollowing(long following) {
			this.following = following;
		}

		public long getUpdates() {
			return updates;
		}

		public void setUpdates(long updates) {
			this.updates = updates;
		}
	}
	
}
