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
package org.springframework.social.yammer.api.connect;

import java.util.Map;

import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;

public class YammerOAuth2Template extends OAuth2Template {

	public YammerOAuth2Template(String clientId, String clientSecret) {
		super(clientId, clientSecret, "https://www.yammer.com/dialog/oauth", "https://www.yammer.com/oauth2/access_token");
	}
	
	@SuppressWarnings("unchecked")
	protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
		return extractAccessGrantForYammer(getRestTemplate().postForObject(accessTokenUrl, parameters, Map.class));
	}

	private AccessGrant extractAccessGrantForYammer(Map<String, Object> postForObject) {
		@SuppressWarnings("unchecked")
		Map<String, Object> accessTokenMap = (Map<String, Object>) postForObject.get("access_token");
		String accessToken = (String) accessTokenMap.get("token");
		return new AccessGrant(accessToken);
	}
	

}
