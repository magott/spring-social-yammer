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
	private Contact contact;
	
	private String lastName;
	private String firstName;
	private long networkId;
	private String timezone;
	
	public YammerProfile(long id, 
			String mugshotUrl, 
			Stats stats, 
			String type, 
			String url, 
			String fullName,
			String name, 
			boolean admin, 
			String expertise, 
			String summary, 
			String jobTitle, 
			Contact contact, 
			List<School> schools, 
			List<String> externalUrls,
			
			String lastName,
			String firstName,
			long networkId,
			String timezone
			) {
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
		this.contact = contact;
		this.schools = schools;
		this.externalUrls = externalUrls;
		this.lastName = lastName;
		this.firstName = firstName;
		this.networkId = networkId;
		this.timezone = timezone;
		
		

	}
	
	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
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
	
	public long getFollowersCount(){
		return stats.followers;
	}
	
	public long getFollowingCount(){
		return stats.following;
	}
	
	public long getMessageCount(){
		return stats.updates;
	}
	
	public long getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getUrl() {
		return url;
	}

	public String getFullName() {
		return fullName;
	}


	public String getName() {
		return name;
	}

	public boolean isAdmin() {
		return admin;
	}

	public String getExpertise() {
		return expertise;
	}

	public String getSummary() {
		return summary;
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
	
	
	

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public long getNetworkId() {
		return networkId;
	}

	public String getTimezone() {
		return timezone;
	}




	public static class Contact{
		private List<EMail> eMails;
		private List<Phone> phoneNumbers;
		private InstantMessaging instantMessaging;
		
		public Contact(List<EMail> eMails, List<Phone> phoneNumbers, InstantMessaging instantMessaging) {
			this.eMails = eMails;
			this.phoneNumbers = phoneNumbers;
			this.instantMessaging = instantMessaging;
		}
		
		public List<EMail> getEMailAdresses() {
			return eMails;
		}
		
		public InstantMessaging getInstantMessaging() {
			return instantMessaging;
		}
		
		public List<Phone> getPhoneNumbers() {
			return phoneNumbers;
		}

		
		
	}
	
	public static class EMail{
		private String type;
		private String address;
		
		public EMail(String address, String type){
			this.type = type;
			this.address = address;
		}

		public String getAddress() {
			return address;
		}

		public String getType() {
			return type;
		}
		
		public String toString() {
			return this.address + " " + this.type;
		}
	}
	
	public static class Phone{
		private String type;
		private String number;
	
		
		public Phone(String number, String type){
			this.type = type;
			this.number = number;
		}

		public String getNumber() {
			return number;
		}

		public String getType() {
			return type;
		}
		
		public String toString() {
			return this.number + " " + this.type;
		}
	}
	
	public static class InstantMessaging{
		private String provider;
		private String username;

		public InstantMessaging(String provider, String username) {
			this.provider = provider;
			this.username = username;
		}

		public String getProvider() {
			return provider;
		}
		
		public String getUsername() {
			return username;
		}
		
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
		
		public Stats(long followers, long following, long updates) {
			super();
			this.followers = followers;
			this.following = following;
			this.updates = updates;
		}

		public long getFollowers() {
			return followers;
		}

		public long getFollowing() {
			return following;
		}

		public long getUpdates() {
			return updates;
		}

		@Override
		public String toString() {
			return "Stats [followers=" + followers + ", following=" + following + ", updates=" + updates + "]";
		}

	}
	
}
