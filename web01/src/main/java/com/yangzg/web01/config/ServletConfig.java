package com.yangzg.web01.config;

import com.yangzg.web01.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Sam
 * @date 2020/3/28 8:17 PM
 */
@EnableWebMvc
@Configuration
@ComponentScan("com.yangzg.web01")
public class ServletConfig implements WebMvcConfigurer {
    @Bean
    public Person person() {
        return new Person(123);
    }
}
