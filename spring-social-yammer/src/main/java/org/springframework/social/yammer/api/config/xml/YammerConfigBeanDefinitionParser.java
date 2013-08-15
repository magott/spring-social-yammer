package org.springframework.social.yammer.api.config.xml;

import org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser;
import org.springframework.social.security.provider.SocialAuthenticationService;
import org.springframework.social.yammer.api.config.support.YammerApiHelper;
import org.springframework.social.yammer.api.connect.YammerConnectionFactory;
import org.springframework.social.yammer.security.YammerAuthenticationService;

public class YammerConfigBeanDefinitionParser extends AbstractProviderConfigBeanDefinitionParser {

    public YammerConfigBeanDefinitionParser() {
        super(YammerConnectionFactory.class, YammerApiHelper.class);
    }

    @Override
    protected Class<? extends SocialAuthenticationService<?>> getAuthenticationServiceClass() {
        return YammerAuthenticationService.class;
    }

}
