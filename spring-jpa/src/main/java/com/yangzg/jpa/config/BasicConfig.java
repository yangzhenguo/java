package com.yangzg.jpa.config;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Sam on 2019/12/6.
 */
@Configuration
@PropertySource("jpa.properties")
@ComponentScan({
        "com.yangzg.jpa.dao.impl",
        "com.yangzg.jpa.service.impl"
})
@EnableTransactionManagement
public class BasicConfig {
    @Value("#{new org.springframework.core.io.ClassPathResource('jpa.properties')}")
    private Resource jpaResource;

    @Value("#{new org.springframework.core.io.ClassPathResource('jdbc.properties')}")
    private Resource jdbcResource;

    @Bean
    public Properties jpaProperties() throws IOException {
        final Properties properties = new Properties();
        properties.load(this.jpaResource.getInputStream());
        return properties;
    }

    @Bean
    public Properties jdbcProperties() throws IOException {
        final Properties properties = new Properties();
        properties.load(this.jdbcResource.getInputStream());
        return properties;
    }

    @Bean
    public DataSource dataSource() throws Exception {
        return BasicDataSourceFactory.createDataSource(this.jdbcProperties());
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws Exception {
        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(this.dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(this.jpaProperties());
        entityManagerFactoryBean.setPackagesToScan("com.yangzg.jpa.model");
        return entityManagerFactoryBean;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
