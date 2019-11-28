package com.yangzg.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Sam on 2019/6/24.
 */
public class HelloTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloTest.class);

    @BeforeClass
    public static void init() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);
    }

    @Test
    public void factory() {
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken("test", "test"));
    }

    @Test
    public void session() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("username", "sam");
        System.out.println(session.getAttribute("username"));
    }

    @Test
    public void auth() {
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("test", "test");
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                LOGGER.info("登录成功");
                if (currentUser.hasRole("admin")) {
                    LOGGER.info("test有admin角色");
                }
                if (currentUser.isPermitted("user:create")) {
                    LOGGER.info("test有创建用户的权限");
                }
                currentUser.logout();
            } catch (UnknownAccountException e) {
                LOGGER.error("用户名不存在");
            } catch (IncorrectCredentialsException e) {
                LOGGER.error("密码错误");
            } catch (ExpiredCredentialsException e) {
                LOGGER.error("密码已经过期");
            } catch (ExcessiveAttemptsException e) {
                LOGGER.error("尝试次数过多");
            } catch (LockedAccountException e) {
                LOGGER.error("账户已经锁定");
            }
        }
    }
}