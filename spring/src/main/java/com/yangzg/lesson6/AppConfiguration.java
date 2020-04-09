package com.yangzg.lesson6;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Sam on 2020/3/24.
 * @author Sam
 */
@Configuration
@ComponentScan("com.yangzg.lesson6")
@ImportResource("/lesson6/applicationContext.xml")
//@EnableTransactionManagement
public class AppConfiguration {
    @Value("classpath:jdbc.properties")
    private Resource resource;

    @Bean
    public DataSource dataSource() throws Exception {
        final Properties properties = new Properties();
        try (final InputStream inputStream = this.resource.getInputStream();) {
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

    @Bean
    public TransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
