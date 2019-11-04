package com.yangzg.config4;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Sam on 2019/11/2.
 */
@Configuration
@PropertySource({
        "classpath:config4/${spring.profiles.active:dev}/jdbc.properties"
})
@ImportResource({
        "classpath:config4/applicationContext-aop.xml"
})
@EnableTransactionManagement
public class DBConfig {
    @Value("classpath:config4/${spring.profiles.active:dev}/jdbc.properties")
    private Resource resource;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws Exception {
        final Properties properties = new Properties();
        properties.load(resource.getInputStream());
        return BasicDataSourceFactory.createDataSource(properties);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        final LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setHibernateProperties(new Properties(){
            private static final long serialVersionUID = -8582768729223860118L;
            {
//                put("connection.url", "jdbc:postgresql:hbn?characterEncoding=utf8&amp;useUnicode=true");
//                put("connection.driver_class", "org.postgresql.Driver");
//                put("connection.username", "postgres");
//                put("connection.password", "postgres");
                put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL92Dialect");
                put("hibernate.hbm2ddl.auto", "update");
//                put("hibernate.current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");
                put("hibernate.show_sql", true);
                put("hibernate.format_sql", true);
            }
        });
        sessionFactoryBean.setMappingResources("com/yangzg/model4/Book.hbm.xml", "com/yangzg/model4/Person.hbm.xml");
        return sessionFactoryBean;
    }
}
