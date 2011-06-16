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


/**
 * @author Morten Andersen-Gott
 *
 */
public class YammerProfile {

	/**
	 * @param id
	 * @param mugshotUrl
	 * @param stats
	 */
	public YammerProfile(long id, String mugshotUrl, Stats stats) {
		super();
		this.id = id;
		this.mugshotUrl = mugshotUrl;
		this.stats = stats;
	}

	private long id;
	private String mugshotUrl;
	private Stats stats;
	
	
	
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
