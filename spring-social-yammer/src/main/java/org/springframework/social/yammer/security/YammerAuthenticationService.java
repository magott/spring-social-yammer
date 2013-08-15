package org.springframework.social.yammer.security;

import org.springframework.social.security.provider.OAuth2AuthenticationService;
import org.springframework.social.yammer.api.Yammer;
import org.springframework.social.yammer.api.connect.YammerConnectionFactory;

public class YammerAuthenticationService extends OAuth2AuthenticationService<Yammer> {

    public YammerAuthenticationService(String apiKey, String appSecret) {
        super(new YammerConnectionFactory(apiKey, appSecret));
    }
}
