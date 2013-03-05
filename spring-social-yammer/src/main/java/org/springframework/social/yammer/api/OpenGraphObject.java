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
 * Used to post a link to a website etc which will get a special type of link in the Yammer web ui
 * @author Morten Andersen-Gott
 *
 */
public class OpenGraphObject {

	private String url;
	private String title;
	private String imageUrl;
	private String description;
	private ObjectType objectType = ObjectType.PAGE; //Yammer default
	private String siteName;
	private String meta;
	private boolean fetch = false; //Yammer default
	
	public OpenGraphObject(String url, String title, String imageUrl, String description, ObjectType objectType,
			String siteName, String meta, boolean fetch) {
		this.url = url;
		this.title = title;
		this.imageUrl = imageUrl;
		this.description = description;
		this.objectType = objectType;
		this.siteName = siteName;
		this.meta = meta;
		this.fetch = fetch;
	}
	
	public String getUrl() {
		return url;
	}

	public String getTitle() {
		return title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public ObjectType getObjectType() {
		return objectType;
	}

	public String getSiteName() {
		return siteName;
	}

	public String getMeta() {
		return meta;
	}

	public boolean isFetch() {
		return fetch;
	}	
	
	/**
	 * 
	 * Enum for the Open Graph Object types supported by Yammer
	 *
	 */
	public static enum ObjectType{
		
		EMPLOYEE("employee"),
		COMPANY("company"),
		PRODUCT("product"),
		PROFILE("profile"),
		ARTICLE("article"),
		BLOG("blog"),
		WEBSITE("website"),
		PAGE("page"), //The Yammer default
		PLACE("place"),
		OFFICE("office"),
		ROOM("room"),
		CUSTOMER("customer"),
		PARTNER("partner"),
		SUPPLIER("supplier"),
		DEPARTMENT("department"),
		TEAM("team"),
		PROJECT("project"),
		FILE("file"),
		DOCUMENT("document"),
		IMAGE("image"),
		AUDIO("audio"),
		VIDEO("video"),
		WIKI("wiki");
		
		private final String typeString;
		
		ObjectType(String typeString){
			this.typeString = typeString;
		}
		
		public String getTypeString(){
			return typeString;
		}
	}

}
