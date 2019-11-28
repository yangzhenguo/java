package com.yangzg.beans3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by Sam on 2019/11/15.
 */
@Configuration
public abstract class Company {
    public abstract Employee getEmployee();

    @Bean
    public DataSource dataSource() {
        return null;
    }
}
