package com.yangzg.crud.config;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Sam on 2019/11/24.
 */
@Configuration
@ComponentScan({
        "com.yangzg.crud.dao",
        "com.yangzg.crud.service",
})
@EnableTransactionManagement
public class RootConfig {
    @Value("#{new org.springframework.core.io.ClassPathResource('jdbc.properties')}")
    private Resource jdbcResource;

    @Bean
    public Properties databaseProperties() throws IOException {
        final Properties properties = new Properties();
        properties.load(this.jdbcResource.getInputStream());
        return properties;
    }

    @Bean
    public DataSource dataSource(@Qualifier("databaseProperties") Properties properties) throws Exception {
        return BasicDataSourceFactory.createDataSource(properties);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) throws Exception {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) throws Exception {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }
}
