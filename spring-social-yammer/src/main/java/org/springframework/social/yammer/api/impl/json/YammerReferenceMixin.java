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

import com.fasterxml.jackson.annotation.*;
import org.springframework.social.yammer.api.GroupReference;
import org.springframework.social.yammer.api.MessageReference;
import org.springframework.social.yammer.api.TagReference;
import org.springframework.social.yammer.api.ThreadReference;
import org.springframework.social.yammer.api.TopicReference;
import org.springframework.social.yammer.api.UserReference;
import org.springframework.social.yammer.api.YammerReference;

@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.PROPERTY, property="type", defaultImpl=YammerReference.class)
@JsonSubTypes({
				@JsonSubTypes.Type(name="user", value=UserReference.class),
				@JsonSubTypes.Type(name="tag", value=TagReference.class),
				@JsonSubTypes.Type(name="topic", value=TopicReference.class),
				@JsonSubTypes.Type(name="group", value=GroupReference.class),
				@JsonSubTypes.Type(name="message", value=MessageReference.class),
				@JsonSubTypes.Type(name="thread", value=ThreadReference.class)
				})
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class YammerReferenceMixin {

	@JsonCreator
	YammerReferenceMixin(
			@JsonProperty("id") long id,
			@JsonProperty("url")String url, 
			@JsonProperty("web_url")String webUrl
			) {	}
	
	
}
