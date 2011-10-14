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
import java.util.List;

/**
 * Represents a Message retrieved posted to Yammer
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
	private Long repliedToId;
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
	private long groupId;
	
	
	
    public YammerMessage(long id, Body body, String url, long networkId, String privacy, long threadId,
			String senderType, List<Attachment> attachments, Long repliedToId, long senderId, String webUrl,
			String clientUrl, boolean systemMessage, String messageType, Date createdAt, boolean directMessage,
			String clientType, LikedBy likedBy, long groupId) {
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
    
    
    /**
     * The unique identifier for the message
     * @return id
     */
	public long getId() {
		return id;
	}

	/**
	 * The restful URL of for this single message
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * The id of the network this message is posted to
	 * @return
	 */
	public long getNetworkId() {
		return networkId;
	}

	/**
	 * Privacy status of this message, either public or private
	 * @return
	 */
	public String getPrivacy() {
		return privacy;
	}

	/**
	 * The id for the thread this message is a part of
	 * @return id of thread
	 */
	public long getThreadId() {
		return threadId;
	}

	public String getSenderType() {
		return senderType;
	}

	/**
	 * The list of attachments, if any
	 * @return attachments
	 */
	public List<Attachment> getAttachments() {
		return attachments;
	}

	/**
	 * The id of the message this message is a reply to, if any
	 * @return id of message this is a reply to, or <code>null</code> if this is not a reply
	 */
	public Long getRepliedToId() {
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

	/**
	 * The body (text) of the yammer message
	 * @return body
	 */
	public Body getBody() {
		return body;
	}

	public LikedBy getLikedBy() {
		return likedBy;
	}
	
	public long getGroupId() {
		return groupId;
	}

	/**
	 * Holds the text of a message in different formats 
	 *
	 */
	public static class Body{
    	private String plain;
    	private String parsed;
    	private String rich;
    	private List<String> urls;
    	
		public Body(String plain, String parsed, String rich, List<String> urls) {
			super();
			this.plain = plain;
			this.parsed = parsed;
			this.rich=rich;
			this.urls = urls;
		}

		public String getPlain() {
			return plain;
		}

		public String getParsed() {
			return parsed;
		}

		public String getRich() {
			return rich;
		}
		
		public List<String> getUrls() {
			return urls;
		}
		
		@Override
		public String toString() {
			return plain;
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
