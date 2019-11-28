package com.yangzg.config3;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Sam on 2019/11/1.
 */
@Configuration
@ComponentScan({
        "com.yangzg.service3",
        "com.yangzg.aspect3"
})
@PropertySource("classpath:jdbc.properties")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class ApplicationConfig {
    @Bean
    public Properties properties(
            @Value("${url}") final String url,
            @Value("${username}") final String username,
            @Value("${password}") final String password
    ) {
        final Properties properties = new Properties();
        properties.setProperty("url", url);
        properties.setProperty("username", username);
        properties.setProperty("password", password);
        return properties;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSource dataSource(Properties properties) throws Exception {
        return BasicDataSourceFactory.createDataSource(properties);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
