package com.yangzg.java.group.server.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Sam on 2020/1/16.
 * @author Sam
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.yangzg.java.group.server.controller")
public class ServletConfig extends WebMvcConfigurerAdapter {
}
