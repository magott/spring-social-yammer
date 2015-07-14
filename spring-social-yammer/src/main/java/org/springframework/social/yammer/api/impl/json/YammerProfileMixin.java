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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.yammer.api.YammerProfile.Contact;
import org.springframework.social.yammer.api.YammerProfile.EMail;
import org.springframework.social.yammer.api.YammerProfile.InstantMessaging;
import org.springframework.social.yammer.api.YammerProfile.Phone;
import org.springframework.social.yammer.api.YammerProfile.School;
import org.springframework.social.yammer.api.YammerProfile.Stats;

/**
 * @author Morten Andersen-Gott
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
abstract class YammerProfileMixin {
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
			@JsonProperty("external_urls") List<String> externalUrls,
			
			@JsonProperty("last_name") String lastName,
			@JsonProperty("first_name") String firstName,
			@JsonProperty("network_id") long networkId,
			@JsonProperty("timezone") String timezone
	){}
	
	
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	abstract static class ContactMixin {
		@JsonCreator
		ContactMixin(
				@JsonProperty("email_addresses") List<EMail> emailAddresses,
				@JsonProperty("phone_numbers") List<Phone> phoneNumbers,
				@JsonProperty("im") InstantMessaging instantMessaging
		){}
	}
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	abstract static class EMailMixin {
		@JsonCreator
		EMailMixin(
				@JsonProperty("address") String address,
				@JsonProperty("type") String type
		){}
	}
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	abstract static class PhoneMixin {
		@JsonCreator
		PhoneMixin(
				@JsonProperty("number") String number,
				@JsonProperty("type") String type
				
		){}
	}
	
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	abstract static class InstantMessagingMixin {
		@JsonCreator
		InstantMessagingMixin(
				@JsonProperty("provider") String type,
				@JsonProperty("username") String address
		){}
	}
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	abstract static class StatsMixin {
		@JsonCreator
		StatsMixin(
				@JsonProperty("followers") long followers, 
				@JsonProperty("following") long following,
				@JsonProperty("updates") long updates 
		){}
	}
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	abstract static class SchoolMixin {
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
