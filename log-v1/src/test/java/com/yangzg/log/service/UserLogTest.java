package com.yangzg.log.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Sam on 2020/1/1.
 */
public class UserLogTest {
    private UserLog userLog = new UserLog();

    @Test
    public void test1() throws Exception {
        this.userLog.test1();
    }

    @Test
    public void test2() throws Exception {
        final Logger logger = LoggerFactory.getLogger(UserLogTest.class);
        System.out.println(logger.getName());

        final org.apache.log4j.Logger rootLogger = org.apache.log4j.Logger.getRootLogger();
        final Logger logger1 = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        System.out.println(rootLogger);
        System.out.println(logger1);

    }
}