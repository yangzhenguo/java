package com.yangzg.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Sam on 2019/6/25.
 */
@Configuration
public class MongoConfig {
    @Bean
    public MongoClient mongoClient() {
        return new MongoClient();
    }
}
