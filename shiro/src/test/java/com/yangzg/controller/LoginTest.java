package com.yangzg.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

/**
 * Created by Sam on 2019/6/24.
 */
public class LoginTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginTest.class);

    @Test
    public void testLogin() {
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro/shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("test", "test2");
        subject.login(token);
        assertTrue(subject.isAuthenticated());
        subject.logout();
    }
}