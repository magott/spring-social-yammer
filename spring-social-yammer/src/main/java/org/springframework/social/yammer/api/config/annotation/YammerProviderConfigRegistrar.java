package org.springframework.social.yammer.api.config.annotation;

import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.social.config.annotation.AbstractProviderConfigRegistrarSupport;
import org.springframework.social.config.xml.ApiHelper;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.security.provider.SocialAuthenticationService;
import org.springframework.social.yammer.api.Yammer;
import org.springframework.social.yammer.api.config.support.YammerApiHelper;
import org.springframework.social.yammer.api.connect.YammerConnectionFactory;
import org.springframework.social.yammer.security.YammerAuthenticationService;

import java.lang.annotation.Annotation;

/**
 * {@link ImportBeanDefinitionRegistrar} for configuring a {@link YammerConnectionFactory} bean and a request-scoped {@link Yammer} bean.
 * @author Morten Andersen-Gott
 */
public class YammerProviderConfigRegistrar extends AbstractProviderConfigRegistrarSupport {

    public YammerProviderConfigRegistrar() {
        super(EnableYammer.class, YammerConnectionFactory.class, YammerApiHelper.class);
    }

    @Override
    protected Class<? extends SocialAuthenticationService<?>> getAuthenticationServiceClass() {
        return YammerAuthenticationService.class;
    }
}
