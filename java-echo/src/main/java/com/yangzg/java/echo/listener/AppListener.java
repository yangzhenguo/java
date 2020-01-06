package com.yangzg.java.echo.listener;

import com.yangzg.java.echo.util.RedisUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by Sam on 2020/1/6.
 * @author Sam
 */
@WebListener
public class AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        RedisUtil.JEDIS_POOL.close();
    }
}
