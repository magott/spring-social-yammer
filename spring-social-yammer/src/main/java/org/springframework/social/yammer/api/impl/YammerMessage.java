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

/**
 * @author Morten Andersen-Gott
 *
 */
public class YammerMessage {

	private long id;
	private String url;
	private long networkId;
	private String privacy;
	private long threadId;
	private String senderType;
	private List<Attachment> attachments;
	private long repliedToId;
	private long senderId;
	private String webUrl;
	private String clientUrl;
	private boolean systemMessage;
	private String messageType;
	private Date createdAt;
	private boolean directMessage;
	private String clientType;
	private Body body;
	private LikedBy likedBy;
	
	
	
    public YammerMessage(long id, Body body, String url, long networkId, String privacy, long threadId,
			String senderType, List<Attachment> attachments, long repliedToId, long senderId, String webUrl,
			String clientUrl, boolean systemMessage, String messageType, Date createdAt, boolean directMessage,
			String clientType, LikedBy likedBy) {
		super();
		this.id = id;
		this.body = body;
		this.url = url;
		this.networkId = networkId;
		this.privacy = privacy;
		this.threadId = threadId;
		this.senderType = senderType;
		this.attachments = attachments;
		this.repliedToId = repliedToId;
		this.senderId = senderId;
		this.webUrl = webUrl;
		this.clientUrl = clientUrl;
		this.systemMessage = systemMessage;
		this.messageType = messageType;
		this.createdAt = createdAt;
		this.directMessage = directMessage;
		this.clientType = clientType;
		this.likedBy = likedBy;
	}
    
    

	public long getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public long getNetworkId() {
		return networkId;
	}

	public String getPrivacy() {
		return privacy;
	}

	public long getThreadId() {
		return threadId;
	}

	public String getSenderType() {
		return senderType;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public long getRepliedToId() {
		return repliedToId;
	}

	public long getSenderId() {
		return senderId;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public String getClientUrl() {
		return clientUrl;
	}

	public boolean isSystemMessage() {
		return systemMessage;
	}

	public String getMessageType() {
		return messageType;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public boolean isDirectMessage() {
		return directMessage;
	}

	public String getClientType() {
		return clientType;
	}

	public Body getBody() {
		return body;
	}

	public LikedBy getLikedBy() {
		return likedBy;
	}

	public static class Body{
    	private String plain;
    	private String parsed;
    	private List<String> urls;
    	
		public Body(String plain, String parsed, List<String> urls) {
			super();
			this.plain = plain;
			this.parsed = parsed;
			this.urls = urls;
		}

		public String getPlain() {
			return plain;
		}

		public String getParsed() {
			return parsed;
		}

		public List<String> getUrls() {
			return urls;
		}
    }
    
    public static class LikedBy{
    	private int count;
    	private List<Name> names;
    	
    	public LikedBy(int count, List<Name> names) {
			super();
			this.count = count;
			this.names = names;
		}

    	/**
    	 * 
    	 * @return number of people who have 'liked' a message
    	 */
		public int getCount() {
			return count;
		}
		
		/**
		 * @return the names of people who liked the message
		 */
		public List<Name> getNames() {
			return names;
		}

		public static class Name{
    		private String permalink;
    		private String fullName;
			
    		public Name(String permalink, String fullName) {
				super();
				this.permalink = permalink;
				this.fullName = fullName;
			}

			public String getFullName() {
				return fullName;
			}
    		
    		/**
			 * @return the yammer username that can be used in mentions (@)
			 */
			public String getPermalink() {
				return permalink;
			}
    	}
    }
	
    public static class Attachment{
    	private String uuid;
    	private String type;
    	private String contentType;
    	private String path;
    	private long yId;
    	private String size;
    	private String name;
    	private String webUrl;
    	private long id;
    	private String inlineUrl;
    	private String inlineHtml;
    	private File file;
    	private Image image;
    	
    	public Attachment(String uuid, String type, String contentType, String path, long yId, String size,
				String name, String webUrl, long id, String inlineUrl, String inlineHtml, File file, Image image) {
			this.uuid = uuid;
			this.type = type;
			this.contentType = contentType;
			this.path = path;
			this.yId = yId;
			this.size = size;
			this.name = name;
			this.webUrl = webUrl;
			this.id = id;
			this.inlineUrl = inlineUrl;
			this.inlineHtml = inlineHtml;
			this.file = file;
			this.image = image;
		}
    	
		public String getUuid() {
			return uuid;
		}

		public String getType() {
			return type;
		}

		public String getContentType() {
			return contentType;
		}

		public String getPath() {
			return path;
		}

		public long getyId() {
			return yId;
		}

		public String getSize() {
			return size;
		}

		public String getName() {
			return name;
		}

		public String getWebUrl() {
			return webUrl;
		}

		public long getId() {
			return id;
		}

		public String getInlineUrl() {
			return inlineUrl;
		}

		public String getInlineHtml() {
			return inlineHtml;
		}

		public File getFile() {
			return file;
		}

		public Image getImage() {
			return image;
		}

		public static class File{
    		private String url;
    		private long size;
			
    		public File(String url, long size) {
				this.url = url;
				this.size = size;
			}
    		
			public String getUrl() {
				return url;
			}

			public long getSize() {
				return size;
			}
    	}
    	
    	public static class Image{
    		private String url;
    		private long size;
    		private String thumbnailUrl;
			
    		public Image(String url, long size, String thumbnailUrl) {
				this.url = url;
				this.size = size;
				this.thumbnailUrl = thumbnailUrl;
			}

			public String getUrl() {
				return url;
			}

			public long getSize() {
				return size;
			}

			public String getThumbnailUrl() {
				return thumbnailUrl;
			}
    	}
    	
	}
}
