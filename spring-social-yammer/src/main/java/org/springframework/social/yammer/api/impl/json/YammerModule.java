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

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.social.yammer.api.Group;
import org.springframework.social.yammer.api.Group.GroupStats;
import org.springframework.social.yammer.api.GroupReference;
import org.springframework.social.yammer.api.MessageInfo;
import org.springframework.social.yammer.api.MessageReference;
import org.springframework.social.yammer.api.SearchResults;
import org.springframework.social.yammer.api.SearchResults.SearchStats;
import org.springframework.social.yammer.api.TagReference;
import org.springframework.social.yammer.api.ThreadReference;
import org.springframework.social.yammer.api.Topic;
import org.springframework.social.yammer.api.Topic.TopicExpert;
import org.springframework.social.yammer.api.TopicReference;
import org.springframework.social.yammer.api.UserReference;
import org.springframework.social.yammer.api.YammerMessage;
import org.springframework.social.yammer.api.YammerMessage.Attachment;
import org.springframework.social.yammer.api.YammerMessage.Attachment.File;
import org.springframework.social.yammer.api.YammerMessage.Attachment.Image;
import org.springframework.social.yammer.api.YammerMessage.Body;
import org.springframework.social.yammer.api.YammerMessage.LikedBy;
import org.springframework.social.yammer.api.YammerMessage.LikedBy.Name;
import org.springframework.social.yammer.api.YammerMessageMeta;
import org.springframework.social.yammer.api.YammerProfile;
import org.springframework.social.yammer.api.YammerProfile.Contact;
import org.springframework.social.yammer.api.YammerProfile.EMail;
import org.springframework.social.yammer.api.YammerProfile.InstantMessaging;
import org.springframework.social.yammer.api.YammerProfile.Phone;
import org.springframework.social.yammer.api.YammerProfile.School;
import org.springframework.social.yammer.api.YammerProfile.Stats;
import org.springframework.social.yammer.api.YammerReference;
import org.springframework.social.yammer.api.YammerThread;
import org.springframework.social.yammer.api.YammerThread.ThreadStats;
import org.springframework.social.yammer.api.impl.json.GroupMixin.GroupStatsMixin;
import org.springframework.social.yammer.api.impl.json.SearchResultsMixin.SearchStatsMixin;
import org.springframework.social.yammer.api.impl.json.TopicMixin.TopicExpertMixin;
import org.springframework.social.yammer.api.impl.json.YammerMessageMixin.AttachmentMixin;
import org.springframework.social.yammer.api.impl.json.YammerMessageMixin.BodyMixin;
import org.springframework.social.yammer.api.impl.json.YammerMessageMixin.LikedByMixin;
import org.springframework.social.yammer.api.impl.json.YammerMessageMixin.AttachmentMixin.FileMixin;
import org.springframework.social.yammer.api.impl.json.YammerMessageMixin.AttachmentMixin.ImageMixin;
import org.springframework.social.yammer.api.impl.json.YammerMessageMixin.LikedByMixin.NameMixin;
import org.springframework.social.yammer.api.impl.json.YammerProfileMixin.ContactMixin;
import org.springframework.social.yammer.api.impl.json.YammerProfileMixin.EMailMixin;
import org.springframework.social.yammer.api.impl.json.YammerProfileMixin.InstantMessagingMixin;
import org.springframework.social.yammer.api.impl.json.YammerProfileMixin.PhoneMixin;
import org.springframework.social.yammer.api.impl.json.YammerProfileMixin.SchoolMixin;
import org.springframework.social.yammer.api.impl.json.YammerProfileMixin.StatsMixin;
import org.springframework.social.yammer.api.impl.json.YammerThreadMixin.YammerThreadStatsMixin;

/**
 * @author Morten Andersen-Gott
 *
 */
public class YammerModule extends SimpleModule {

	public YammerModule() {
		super("YammerModule");
	}

	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(YammerMessageMeta.class, YammerMessageMetaMixin.class);
		context.setMixInAnnotations(YammerProfile.class, YammerProfileMixin.class);
		context.setMixInAnnotations(Stats.class, StatsMixin.class);
		context.setMixInAnnotations(Contact.class, ContactMixin.class);
		context.setMixInAnnotations(EMail.class, EMailMixin.class);
		context.setMixInAnnotations(Phone.class, PhoneMixin.class);
		context.setMixInAnnotations(InstantMessaging.class, InstantMessagingMixin.class);
		context.setMixInAnnotations(School.class, SchoolMixin.class);
		context.setMixInAnnotations(MessageInfo.class, MessageInfoMixin.class);
		context.setMixInAnnotations(YammerMessage.class, YammerMessageMixin.class);
		context.setMixInAnnotations(Body.class, BodyMixin.class);
		context.setMixInAnnotations(LikedBy.class, LikedByMixin.class);
		context.setMixInAnnotations(Attachment.class, AttachmentMixin.class);
		context.setMixInAnnotations(File.class, FileMixin.class);
		context.setMixInAnnotations(Image.class, ImageMixin.class);
		context.setMixInAnnotations(Name.class, NameMixin.class);
		context.setMixInAnnotations(Group.class, GroupMixin.class);
		context.setMixInAnnotations(GroupStats.class, GroupStatsMixin.class);
		context.setMixInAnnotations(Topic.class, TopicMixin.class);
		context.setMixInAnnotations(TopicExpert.class, TopicExpertMixin.class);
		context.setMixInAnnotations(SearchResults.class, SearchResultsMixin.class);
		context.setMixInAnnotations(SearchStats.class, SearchStatsMixin.class);
		context.setMixInAnnotations(YammerThread.class, YammerThreadMixin.class);
		context.setMixInAnnotations(ThreadStats.class, YammerThreadStatsMixin.class);
		context.setMixInAnnotations(YammerReference.class, YammerReferenceMixin.class);
		context.setMixInAnnotations(UserReference.class, UserReferenceMixin.class);
		context.setMixInAnnotations(ThreadReference.class, ThreadReferenceMixin.class);
		context.setMixInAnnotations(GroupReference.class, GroupReferenceMixin.class);
		context.setMixInAnnotations(MessageReference.class, MessageReferenceMixin.class);
		context.setMixInAnnotations(TopicReference.class, TopicReferenceMixin.class);
		context.setMixInAnnotations(TagReference.class, TagReferenceMixin.class);
	}

}
