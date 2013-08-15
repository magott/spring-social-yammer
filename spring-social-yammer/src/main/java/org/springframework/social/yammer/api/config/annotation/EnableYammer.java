package org.springframework.social.yammer.api.config.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(YammerProviderConfigRegistrar.class)
public @interface EnableYammer {

    /**
     * The application's consumer key as issued by Yammer.
     */
    String appId();

    /**
     * The application's consumer secret as issued by Yammer.
     */
    String appSecret();

}
