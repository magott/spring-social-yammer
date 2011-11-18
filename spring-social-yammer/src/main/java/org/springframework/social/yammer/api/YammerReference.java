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
 * A reference to a tag, topic, user, message group or thread. References are lightweight representations of the
 * underlying object. This allows you to display key data about objects referenced in messages without doing
 * additional polls. Each reference type maps to a subclass of {@link YammerReference}, which provides additional
 * information beyond the common properties specified by this class. Unknown references will be mapped to the parent
 * class {@link YammerReference}. 
 * 
 * From the Yammer API documentation:
 * References are used when one object refers to another, and data about the
 * referenced object would be useful. This avoids redundancy in what is
 * returned. For example, a page of messages may include 20 messages from the
 * same user. Each message will indicate that it was sent by a user and that
 * user's ID, and the references section will include that user only once and
 * include the name and mugshot (profile picture) URL.
 * 
 * @author Morten Andersen-Gott
 * 
 */
public class YammerReference {
	
	// Shared properties for all references
	private long id;
	private String url;
	private String webUrl;

	// User, group and topic property
//	protected String name;

	// Topic properties
//	protected String permalink;
//	protected String normalizedName;

	// Thread properties
//	protected YammerThread.ThreadStats threadStats;
//	protected Long threadStarterId;
//	protected String privacy;
//	protected boolean hasAttachments;
	
	
	public YammerReference(long id, String url, String webUrl) {
		super();
		this.id = id;
		this.url = url;
		this.webUrl = webUrl;
	}
	
	public long getId() {
		return id;
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getWebUrl() {
		return webUrl;
	}

	@Override
	public String toString() {
		return "YammerReference [id=" + id + ", url=" + url + ", webUrl=" + webUrl + "]";
	}

}
