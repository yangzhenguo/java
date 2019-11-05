package com.yangzg.config;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * Created by Sam on 2019/11/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class ApplicationConfigTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void dataSource() throws Exception {
        Assert.assertNotNull(this.dataSource);
    }

    @Test
    public void localSessionFactoryBean() throws Exception {
        Assert.assertNotNull(this.sessionFactory);
    }

}