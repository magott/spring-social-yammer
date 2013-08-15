package org.springframework.social.yammer.api.config.xml;

import org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser;
import org.springframework.social.config.xml.AbstractProviderConfigNamespaceHandler;

public class YammerNamespaceHandler extends AbstractProviderConfigNamespaceHandler {


    @Override
    protected AbstractProviderConfigBeanDefinitionParser getProviderConfigBeanDefinitionParser() {
        return new YammerConfigBeanDefinitionParser();
    }
}
