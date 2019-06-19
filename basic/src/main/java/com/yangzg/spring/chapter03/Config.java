package com.yangzg.spring.chapter03;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by Sam on 2019/6/18.
 */
@Configuration
@ComponentScan("com.yangzg.spring.chapter03")
@PropertySource("classpath:jdbc.properties")
public class Config {
    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(destroyMethod = "close")
    public MongoClient mongoClient() {
        return new MongoClient();
    }

    @Autowired
    private Environment environment;

    @Bean("options")
    @Profile("dev")
    public Map<String, Object> devConfig() {
        return new HashMap<String, Object>() {
            private static final long serialVersionUID = 7291730431031524146L;
            {
                put("a", 12);
                put("b", 11);
                put("c", 13);
            }
        };
    }

    @Bean("options")
    @Profile("prod")
    public Map<String, Object> proConfig() {
        return new HashMap<String, Object>() {
            private static final long serialVersionUID = 7291730431031524146L;
            {
                put("a", 22);
                put("b", 21);
                put("c", 23);
            }
        };
    }

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class, SystemConfig.class)) {
            Person person = applicationContext.getBean(Person.class);
            System.out.println(person);

            DbConfig config = applicationContext.getBean(DbConfig.class);
            System.out.println(config);
            // new BufferedReader(new InputStreamReader(config.getUrl().getInputStream())).lines().forEach(System.out::println);

            SystemConfig systemConfig = applicationContext.getBean(SystemConfig.class);

            System.out.println(systemConfig);

            MongoClient mongoClient = applicationContext.getBean(MongoClient.class);
            MongoCollection<Document> names = mongoClient.getDatabase("shop").getCollection("names");

            StreamSupport.stream(names.find().limit(3).spliterator(), true).forEach(System.out::println);

            Environment environment = applicationContext.getBean(Environment.class);

            System.out.println(environment);

            Map map = (Map) applicationContext.getBean("options");
            System.out.println(map);
        }
    }
}
