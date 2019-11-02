package com.yangzg.config1;

import com.yangzg.service2.CalculateService;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Sam on 2019/10/31.
 */
@Configuration
public class ApplicationConfig {
    @Autowired
    private Environment environment;

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public CalculateService calculateService() {
        return new CalculateService();
    }

    @Bean(
            name = "dataSource",
            destroyMethod = "close"
    )
    @Profile("dev")
    public DataSource dataSourceDev(Properties properties) throws Exception {
        System.out.println("dataSourceDev");
        return BasicDataSourceFactory.createDataSource(properties);
    }

    @Bean(
            name = "dataSource",
            destroyMethod = "close"
    )
    @Profile("prod")
    public DataSource dataSourceProd(Properties properties) throws Exception {
        System.out.println("dataSourceProd");
        return BasicDataSourceFactory.createDataSource(properties);
    }

    @Bean
    public Properties properties() throws IOException {
//        System.out.println(this.environment);
        final Properties properties = new Properties();
        properties.load(ApplicationConfig.class.getClassLoader().getResourceAsStream("jdbc.properties"));
        return properties;
    }
}
