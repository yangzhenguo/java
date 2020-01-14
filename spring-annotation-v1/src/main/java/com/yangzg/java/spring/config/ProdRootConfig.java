package com.yangzg.java.spring.config;

import com.yangzg.java.spring.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * Created by Sam on 2020/1/14.
 * @author Sam
 */
@Profile("prod")
public class ProdRootConfig {
    @Bean
    public Person person() {
        return new Person();
    }
}
