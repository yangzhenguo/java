package com.yangzg.config;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.PostgreSQL92Dialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Sam on 2019/11/5.
 */
@Configuration
@ComponentScan({
        "com.yangzg.action.**",
        "com.yangzg.dao.impl",
        "com.yangzg.service.impl"
})
@EnableTransactionManagement
public class ApplicationConfig {
    @Value("classpath:/${spring.profiles.active:dev}/jdbc.properties")
    private Resource resource;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws Exception {
        final Properties properties = new Properties();
        properties.load(this.resource.getInputStream());
        return BasicDataSourceFactory.createDataSource(properties);
    }

    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean (DataSource dataSource) {
        final LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setHibernateProperties(new Properties(){
            private static final long serialVersionUID = -5129477426696640881L;
            {
                put("hibernate.show_sql", Boolean.toString(true));
                put("hibernate.format_sql", Boolean.toString(true));
                put("hibernate.hbm2ddl.auto", "update");
                put("hibernate.dialect", PostgreSQL92Dialect.class.getName());
            }
        });
        factoryBean.setMappingResources("com/yangzg/model/Employee.hbm.xml", "com/yangzg/model/Department.hbm.xml");
        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}
