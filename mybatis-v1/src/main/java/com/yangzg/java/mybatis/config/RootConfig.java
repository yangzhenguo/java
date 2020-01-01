package com.yangzg.java.mybatis.config;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) {
//        return new SqlSessionFactoryBuilder().build(this.mybatisConfigReader);
        final JdbcTransactionFactory transactionFactory = new JdbcTransactionFactory();
        final org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration(new Environment("development", transactionFactory, dataSource));
        configuration.addMappers("com.yangzg.java.mybatis.mapper");
        return new SqlSessionFactoryBuilder().build(configuration);
    }
}
