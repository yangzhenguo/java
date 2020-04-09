package com.yangzg.lesson8;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Sam
 * @date 2020/4/6 5:31 PM
 */
@Configuration
@ComponentScan("com.yangzg.lesson8")
public class AppConfig {
    @Value("${classpath:/jdbc.properties}")
    private Resource resource;

    @Bean
    public DataSource dataSource() throws Exception {
        final Properties properties = new Properties();
        try(final InputStream inputStream = this.resource.getInputStream()) {
            properties.load(inputStream);
        }
        return BasicDataSourceFactory.createDataSource(properties);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(JdbcTemplate jdbcTemplate) {
        return new NamedParameterJdbcTemplate(jdbcTemplate);
    }
}
