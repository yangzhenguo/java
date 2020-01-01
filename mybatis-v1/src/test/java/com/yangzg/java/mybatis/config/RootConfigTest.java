package com.yangzg.java.mybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Sam on 2020/1/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class RootConfigTest {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void sqlSessionFactory() throws Exception {
        Assert.assertNotNull(sqlSessionFactory);
    }
}