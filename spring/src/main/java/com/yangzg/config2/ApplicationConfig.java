package com.yangzg.config2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

import javax.sql.DataSource;

/**
 * Created by Sam on 2019/10/31.
 */
@Configuration
@ImportResource(locations = "classpath*:/config2/applicationContext.xml")
@ComponentScan({"com.**.aspect1", "com.**.service2"})
@EnableAspectJAutoProxy
public class ApplicationConfig {
    @Autowired(required = false)
    @Qualifier("dataSource")
    public DataSource dataSource;
}
