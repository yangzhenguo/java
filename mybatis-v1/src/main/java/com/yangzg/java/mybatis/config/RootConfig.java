package com.yangzg.java.mybatis.config;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

/**
 * Created by Sam on 2020/1/1.
 * @author Sam
 */
@Configuration
public class RootConfig {
    @Value("#{T(org.apache.ibatis.io.Resources).getResourceAsReader('mybatis-config.xml')}")
    private Reader mybatisConfigReader;

    @Value("#{new org.springframework.core.io.ClassPathResource('jdbc.properties').inputStream}")
    private InputStream jdbcInputStream;

    @Bean
    public DataSource dataSource() throws Exception {
        final Properties properties = new Properties();
        properties.load(this.jdbcInputStream);
        return BasicDataSourceFactory.createDataSource(properties);
    }

    @Profile({ "development", "default" })
    @Bean
    public Environment development(DataSource dataSource) {
        return new Environment("development", new JdbcTransactionFactory(), dataSource);
    }

    @Profile("test")
    @Bean
    public Environment test(DataSource dataSource) {
        return new Environment("test", new JdbcTransactionFactory(), dataSource);
    }

    @Profile("production")
    @Bean
    public Environment production(DataSource dataSource) {
        return new Environment("production", new JdbcTransactionFactory(), dataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(Environment environment) {
        final org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration(environment);
        configuration.addMappers("com.yangzg.java.mybatis.mapper");
        configuration.setMapUnderscoreToCamelCase(true);
        return new SqlSessionFactoryBuilder().build(configuration);
    }
}
