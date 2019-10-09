package com.hiyzg.config;

import core.MyWebInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by Sam on 2019/10/8.
 */
public class Application implements MyWebInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("start config");
    }
}
