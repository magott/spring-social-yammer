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

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.social.yammer.api.MessageOperations;
import org.springframework.social.yammer.api.OpenGraphObject;
import org.springframework.social.yammer.api.YammerMessage;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Details beyond the message, used when posting to yammer. Differs from
 * {@link YammerMessage} which is the type returned when submitting a posting or
 * when polling for messages with any of the get-methods in {@link MessageOperations}
 * 
 * @see YammerMessage
 * 
 * @author Morten Andersen-Gott
 * 
 */
public class YammerPostDetails {

	private long groupId;
	private long replyToId;
	private long directToUserId;
	private Boolean broadcast;
	private List<String> topics = new ArrayList<String>();
	private OpenGraphObject openGraphObject;
	private List<Resource> attachments = new ArrayList<Resource>();

	public MultiValueMap<String, Object> toParameters() {
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		if (broadcast != null) {
			params.set("broadcast", String.valueOf(broadcast));
		}
		addLongToParamsIfSet(params, groupId, "group_id");
		addLongToParamsIfSet(params, directToUserId, "direct_to_id");
		addLongToParamsIfSet(params, replyToId, "replied_to_id");
		addOpenGraphObjectToParamsIfSet(params);
		addAttachmentsIfPresent(params);

		return params;
	}
	
	public void addAttachment(Resource resource){
		attachments.add(resource);
	}

	private void addOpenGraphObjectToParamsIfSet(MultiValueMap<String,Object> params) {
		if (openGraphObject != null) {
			addStringToParamsIfSet(params, openGraphObject.getUrl(), "og_url");
			addStringToParamsIfSet(params, openGraphObject.getTitle(), "og_title");
			addStringToParamsIfSet(params, openGraphObject.getImageUrl(), "og_image");
			addStringToParamsIfSet(params, openGraphObject.getDescription(), "og_description");
			addStringToParamsIfSet(params, openGraphObject.getSiteName(), "og_site_name");
			addStringToParamsIfSet(params, openGraphObject.getMeta(), "og_meta");

			params.set("og_fetch", String.valueOf(openGraphObject.isFetch()));

			addTopicsIfPresent(params);
			addAttachmentsIfPresent(params);

			if (openGraphObject.getObjectType() != null) {
				params.set("og_object_type", openGraphObject.getObjectType().getTypeString());
			}
		}
	}

	/**
	 * @param params
	 */
	private void addAttachmentsIfPresent(MultiValueMap<String, Object> params) {
		int count = 0;
		// attachment1..20 is valid more than 20 is ignored by Yammer
		for (Resource attachment: attachments) {
			count++;
			params.set("attachment" + count, attachment);
		}
		
	}

	private void addTopicsIfPresent(MultiValueMap<String,Object> params) {
		int count = 0;
		// topic1..topic20 is valid more than 20 is ignored by Yammer
		for (String topic : topics) {
			count++;
			params.set("topic" + count, topic);
		}
	}

	private void addStringToParamsIfSet(MultiValueMap<String,Object> params, String param, String paramName) {
		if (param != null) {
			params.set(paramName, String.valueOf(param));
		}
	}

	private void addLongToParamsIfSet(MultiValueMap<String,Object> params, long param, String paramName) {
		if (param != 0) {
			params.set(paramName, String.valueOf(param));
		}
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public long getReplyToId() {
		return replyToId;
	}

	public void setReplyToId(long replyToId) {
		this.replyToId = replyToId;
	}

	public long getDirectToUserId() {
		return directToUserId;
	}

	public void setDirectToUserId(long directToUserId) {
		this.directToUserId = directToUserId;
	}

	public Boolean getBroadcast() {
		return broadcast;
	}

	public void setBroadcast(Boolean broadcast) {
		this.broadcast = broadcast;
	}

	public List<String> getTopics() {
		return topics;
	}

	public void setTopics(List<String> topics) {
		this.topics = topics;
	}

	public OpenGraphObject getOpenGraphObject() {
		return openGraphObject;
	}

	public void setOpenGraphObject(OpenGraphObject openGraphObject) {
		this.openGraphObject = openGraphObject;
	}

	public List<Resource> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Resource> attachements) {
		this.attachments = attachements;
	}
}
