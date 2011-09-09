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

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.yammer.api.YammerMessage.Attachment;
import org.springframework.social.yammer.api.YammerMessage.Body;
import org.springframework.social.yammer.api.YammerMessage.LikedBy;
import org.springframework.social.yammer.api.YammerMessage.Attachment.File;
import org.springframework.social.yammer.api.YammerMessage.Attachment.Image;
import org.springframework.social.yammer.api.YammerMessage.LikedBy.Name;

/**
 * @author Morten Andersen-Gott
 *
 */
public class YammerMessageMixin {

	@JsonCreator
	YammerMessageMixin(
			@JsonProperty("id")long id, 
			@JsonProperty("body")Body body, 
			@JsonProperty("url")String url, 
			@JsonProperty("network_id")long networkId, 
			@JsonProperty("privacy")String privacy, 
			@JsonProperty("thread_id")long threadId,
			@JsonProperty("sender_type")String senderType, 
			@JsonProperty("attachments")List<Attachment> attachments, 
			@JsonProperty("replied_to_id")long repliedToId, 
			@JsonProperty("sender_id")long senderId, 
			@JsonProperty("web_url")String webUrl,
			@JsonProperty("client_url")String clientUrl, 
			@JsonProperty("system_message")boolean systemMessage, 
			@JsonProperty("message_type")String messageType, 
			@JsonProperty("created_at") @JsonDeserialize(using=YammerDateDeserializer.class)Date createdAt, 
			@JsonProperty("direct_message")boolean directMessage,
			@JsonProperty("client_type")String clientType, 
			@JsonProperty("liked_by")LikedBy likedBy,
			@JsonProperty("group_id")long groupId
			){}
	
	public static class BodyMixin{
		@JsonCreator
		BodyMixin(
			@JsonProperty("plain")String plain,
			@JsonProperty("parsed")String formatted,
			@JsonProperty("urls")List<String> urls
		){}
	}
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	public static class AttachmentMixin{
		@JsonCreator
		public AttachmentMixin(
				@JsonProperty("uuid")String uuid, 
				@JsonProperty("type")String type, 
				@JsonProperty("content_type")String contentType, 
				@JsonProperty("path")String path, 
				@JsonProperty("y_id")long yId, 
				@JsonProperty("size")String size,
				@JsonProperty("name")String name, 
				@JsonProperty("web_url")String webUrl, 
				@JsonProperty("id")long id, 
				@JsonProperty("inline_url")String inlineUrl, 
				@JsonProperty("inline_html")String inlineHtml, 
				@JsonProperty("file")File file, 
				@JsonProperty("image")Image image
		) {}
		
		public static class FileMixin{
			@JsonCreator
			public FileMixin(
		    	@JsonProperty("url") String url,
		    	@JsonProperty("size") long size
			) {}
		}
		
		public static class ImageMixin{
			@JsonCreator
			public ImageMixin(
		    	@JsonProperty("url") String url,
		    	@JsonProperty("size")long size,
		    	@JsonProperty("thumbnail_url")String thumbnailUrl				
			){}
		}
	}
	
	public static class LikedByMixin{
		@JsonCreator
		LikedByMixin(
			@JsonProperty("count")int count,
			@JsonProperty("names") List<Name> names
		){}
		
		public static class NameMixin{
			@JsonCreator
			NameMixin(
				@JsonProperty("permalink") String permalink,
				@JsonProperty("full_name") String fullname
			){}
		}
	}
	
}
