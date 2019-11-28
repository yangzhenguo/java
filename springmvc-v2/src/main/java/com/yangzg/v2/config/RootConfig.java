package com.yangzg.v2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Sam on 2019/11/6.
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class RootConfig {
}
