package org.springframework.social.yammer.api.config.support;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.xml.ApiHelper;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.yammer.api.Yammer;

public class YammerApiHelper implements ApiHelper<Yammer>{

    private final UsersConnectionRepository usersConnectionRepository;
    private final UserIdSource userIdSource;

    public YammerApiHelper(UsersConnectionRepository usersConnectionRepository, UserIdSource userIdSource) {
        this.usersConnectionRepository = usersConnectionRepository;
        this.userIdSource = userIdSource;
    }

    @Override
    public Yammer getApi() {
        if (logger.isDebugEnabled()) {
            logger.debug("Getting API binding instance for Yammer");
        }

        Connection<Yammer> connection = usersConnectionRepository.createConnectionRepository(userIdSource.getUserId()).findPrimaryConnection(Yammer.class);
        if (logger.isDebugEnabled() && connection == null) {
            logger.debug("No current connection; Returning null");
        }
        return connection != null ? connection.getApi() : null; //TODO: Find better default
    }

    private final static Log logger = LogFactory.getLog(YammerApiHelper.class);

}
