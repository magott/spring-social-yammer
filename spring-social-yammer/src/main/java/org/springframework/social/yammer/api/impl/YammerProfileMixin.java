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

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.yammer.api.impl.YammerProfile.Contact;
import org.springframework.social.yammer.api.impl.YammerProfile.EMail;
import org.springframework.social.yammer.api.impl.YammerProfile.InstantMessaging;
import org.springframework.social.yammer.api.impl.YammerProfile.School;
import org.springframework.social.yammer.api.impl.YammerProfile.Stats;

/**
 * @author Morten Andersen-Gott
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class YammerProfileMixin {
	@JsonCreator
	YammerProfileMixin(
			@JsonProperty("id") long id, 
			@JsonProperty("mugshot_url") String mugshotUrl,
			@JsonProperty("stats") Stats stats,
			@JsonProperty("type") String type,
			@JsonProperty("web_url") String url,
			@JsonProperty("full_name") String fullName,
			@JsonProperty("name") String name,
			@JsonProperty("admin") boolean admin,
			@JsonProperty("expertise") String expertise,
			@JsonProperty("summary") String summary,
			@JsonProperty("job_title") String jobTitle,
			@JsonProperty("contact") Contact contact,
			@JsonProperty("schools") List<School> schools,
			@JsonProperty("external_urls") List<String> externalUrls
	){}
	
	
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	public static class ContactMixin {
		@JsonCreator
		ContactMixin(
				@JsonProperty("email_addresses") List<EMail> emailAddresses, 
				@JsonProperty("phone_numbers") List<String> phoneNumbers,
				@JsonProperty("im") InstantMessaging instantMessaging
		){}
	}
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	public static class EMailMixin {
		@JsonCreator
		EMailMixin(
				@JsonProperty("type") String type,
				@JsonProperty("address") String address
		){}
	}
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	public static class InstantMessagingMixin {
		@JsonCreator
		InstantMessagingMixin(
				@JsonProperty("provider") String type,
				@JsonProperty("username") String address
		){}
	}
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	public static class StatsMixin {
		@JsonCreator
		StatsMixin(
				@JsonProperty("followers") long followers, 
				@JsonProperty("followering") long followering,
				@JsonProperty("updates") long updates 
		){}
	}
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	public static class SchoolMixin {
			@JsonCreator
			SchoolMixin(
					@JsonProperty("school") String name, 
					@JsonProperty("degree") String degreee,
					@JsonProperty("description") String description, 
					@JsonProperty("start_year") int startYear, 
					@JsonProperty("end_year") int endYear 
			){}
	}
}
