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

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.yammer.api.Group.GroupStats;
import org.springframework.social.yammer.api.impl.YammerDateDeserializer;

import java.util.Date;

/**
 * @author Yoni Moses
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
abstract class ActivityMixin {

	@JsonCreator
    ActivityMixin(
            @JsonProperty("action_id") String actionId,
            @JsonProperty("actor_id") String actorId,
            @JsonProperty("object_id") String objectId
    ) {}

}
