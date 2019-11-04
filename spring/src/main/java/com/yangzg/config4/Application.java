package com.yangzg.config4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by Sam on 2019/11/2.
 */
@Configuration
@ComponentScan({ "com.yangzg.dao4", "com.yangzg.service4" })
@Import({ DBConfig.class })
public class Application {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
