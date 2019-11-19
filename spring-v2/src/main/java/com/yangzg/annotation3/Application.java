package com.yangzg.annotation3;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Sam on 2019/11/18.
 */
@Configuration
@ComponentScan("com.yangzg.annotation3")
@ImportResource("classpath:annotation3/beans.xml")
public class Application {
    @Bean
    @Primary
    public Map<Integer, Double> map() {
        return IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toMap(n -> n, n -> Math.random()));
    }

    @Bean
    @Lazy
    public Object object1(DataSource dataSource) {
        System.out.println(dataSource);
        return new Object();
    }

    @Bean
    @Lazy
    public Object object2(DataSource dataSource) {
        System.out.println(dataSource);
        return new Object();
    }

    @Bean
    @Profile("default")
    public DataSource defaultDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .build();
    }

    @Bean
    @Profile("development")
    public DataSource hsqlDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .build();
    }

    @Bean
    @Profile("production")
    public DataSource mysqlDataSource() {
        return new BasicDataSource();
    }
}
