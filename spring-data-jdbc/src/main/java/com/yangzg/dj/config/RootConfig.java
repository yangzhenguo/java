package com.yangzg.dj.config;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Sam on 2019/12/12.
 */
@Configuration
@EnableJdbcRepositories("com.yangzg.dj.repository")
public class RootConfig extends AbstractJdbcConfiguration {
    @Value("#{new org.springframework.core.io.ClassPathResource('jdbc.properties')}")
    private Resource jdbcResource;

    @Bean
    public DataSource dataSource() throws Exception {
        Properties properties = new Properties();
        properties.load(this.jdbcResource.getInputStream());
        return BasicDataSourceFactory.createDataSource(properties);
    }

    @Bean
    NamedParameterJdbcOperations namedParameterJdbcOperations() throws Exception {
        return new NamedParameterJdbcTemplate(this.dataSource());
    }
}
