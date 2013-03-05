package org.springframework.social.yammer.api;


/**
 * Sub-API for activity operations
 * @author Yoni Moses
 *
 */
public interface ActivityOperations {


    /**
     * Post activity
     * @param details the  object to post.
     */

    void postActivity(YammerActivityDetails details);
}

