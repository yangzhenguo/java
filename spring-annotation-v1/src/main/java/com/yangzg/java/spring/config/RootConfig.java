package com.yangzg.java.spring.config;

import com.yangzg.java.spring.model.ColorFactoryBean;
import com.yangzg.java.spring.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by Sam on 2020/1/11.
 * @author Sam
 */
@Configuration
@ComponentScan({
        "com.yangzg.java.spring.service",
        "com.yangzg.java.spring.dao"
})
public class RootConfig {
    @Bean(initMethod = "init")
    public Person person(ColorFactoryBean.Color color) {
        System.out.println(color);
        return new Person();
    }

    @Bean
    public ColorFactoryBean color() {
        return new  ColorFactoryBean();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
