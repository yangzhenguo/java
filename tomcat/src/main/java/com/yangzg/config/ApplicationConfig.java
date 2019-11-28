package com.yangzg.config;

import core.MyWebInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Sam on 2019/9/19.
 */
public class ApplicationConfig implements MyWebInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(servletContext.getResourceAsStream("/META-INF/services/javax.servlet.ServletContainerInitializer")))) {
            br.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
