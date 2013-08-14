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
package org.springframework.social.yammer.api.impl.json;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.yammer.api.Topic;
import org.springframework.social.yammer.api.YammerThread.ThreadStats;
import org.springframework.social.yammer.api.impl.YammerDateDeserializer;

/**
 * @author Morten Andersen-Gott
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
abstract class YammerThreadMixin {

	@JsonCreator
	public YammerThreadMixin(
		@JsonProperty("stats") ThreadStats stats,
		@JsonProperty("type") String type,
		@JsonProperty("privacy") String privacy,
		@JsonProperty("thread_starter_id") long threadStarterId,
		@JsonProperty("has_attachments") boolean hasAttachments,
		@JsonProperty("web_url") String webUrl,
		@JsonProperty("id") long id,
		@JsonProperty("direct_message") boolean directMessage,
		@JsonProperty("topics") List<Topic> topics
	) {	}


    @JsonIgnoreProperties(ignoreUnknown=true)
	abstract static class YammerThreadStatsMixin{
		
		@JsonCreator
		public YammerThreadStatsMixin(
				@JsonProperty("first_reply_at") @JsonDeserialize(using=YammerDateDeserializer.class) Date firstReplyAt,
				@JsonProperty("latest_reply_at") @JsonDeserialize(using=YammerDateDeserializer.class) Date latestReplyAt,
				@JsonProperty("first_reply_id") long firstReplyId,
				@JsonProperty("latest_reply_id") long latestReplyId,
				@JsonProperty("updates") int messageCount,
                @JsonProperty("shares") int shares
		){}
		
	}
}
