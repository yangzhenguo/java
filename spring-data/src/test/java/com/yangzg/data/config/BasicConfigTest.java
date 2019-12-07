package com.yangzg.data.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by Sam on 2019/12/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BasicConfig.class)
public class BasicConfigTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Test
    public void dataSource() throws Exception {
        Assert.assertNotNull(this.dataSource);
    }

    @Test
    public void entityManagerFactoryBean() throws Exception {
        Assert.assertNotNull(this.entityManagerFactory);
    }

    @Test
    public void transactionManager() throws Exception {
        Assert.assertNotNull(this.transactionManager);
    }

}