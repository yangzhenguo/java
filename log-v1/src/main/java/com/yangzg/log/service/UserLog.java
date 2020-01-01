package com.yangzg.log.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Sam on 2020/1/1.
 * @author Sa
 */
public class UserLog {
    final Logger logger = LoggerFactory.getLogger(UserLog.class);

    public void test1() {
        if (logger.isInfoEnabled()) {
            logger.info("this is a info {}", "test");
        }
        if (logger.isDebugEnabled()) {
            logger.debug("this is a debug {}", "test");
        }
    }
}
