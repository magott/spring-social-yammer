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

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;
import org.springframework.social.yammer.api.impl.YammerMessage.Attachment;
import org.springframework.social.yammer.api.impl.YammerMessage.Attachment.File;
import org.springframework.social.yammer.api.impl.YammerMessage.Attachment.Image;
import org.springframework.social.yammer.api.impl.YammerMessage.Body;
import org.springframework.social.yammer.api.impl.YammerMessage.LikedBy;
import org.springframework.social.yammer.api.impl.YammerMessage.LikedBy.Name;
import org.springframework.social.yammer.api.impl.YammerMessageMixin.AttachmentMixin;
import org.springframework.social.yammer.api.impl.YammerMessageMixin.AttachmentMixin.FileMixin;
import org.springframework.social.yammer.api.impl.YammerMessageMixin.AttachmentMixin.ImageMixin;
import org.springframework.social.yammer.api.impl.YammerMessageMixin.BodyMixin;
import org.springframework.social.yammer.api.impl.YammerMessageMixin.LikedByMixin;
import org.springframework.social.yammer.api.impl.YammerMessageMixin.LikedByMixin.NameMixin;
import org.springframework.social.yammer.api.impl.YammerProfile.Contact;
import org.springframework.social.yammer.api.impl.YammerProfile.EMail;
import org.springframework.social.yammer.api.impl.YammerProfile.InstantMessaging;
import org.springframework.social.yammer.api.impl.YammerProfile.School;
import org.springframework.social.yammer.api.impl.YammerProfile.Stats;
import org.springframework.social.yammer.api.impl.YammerProfileMixin.ContactMixin;
import org.springframework.social.yammer.api.impl.YammerProfileMixin.EMailMixin;
import org.springframework.social.yammer.api.impl.YammerProfileMixin.InstantMessagingMixin;
import org.springframework.social.yammer.api.impl.YammerProfileMixin.SchoolMixin;
import org.springframework.social.yammer.api.impl.YammerProfileMixin.StatsMixin;

/**
 * @author Morten Andersen-Gott
 *
 */
public class YammerModule extends SimpleModule {

	public YammerModule() {
		super("YammerModule", new Version(1, 0, 0, null));
	}

	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(YammerMessageMeta.class, YammerMessageMetaMixin.class);
		context.setMixInAnnotations(YammerProfile.class, YammerProfileMixin.class);
		context.setMixInAnnotations(Stats.class, StatsMixin.class);
		context.setMixInAnnotations(Contact.class, ContactMixin.class);
		context.setMixInAnnotations(EMail.class, EMailMixin.class);
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
	}

}
