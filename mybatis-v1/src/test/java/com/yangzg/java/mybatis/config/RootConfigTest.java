package com.yangzg.java.mybatis.config;

import com.yangzg.java.mybatis.BaseTest;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Sam on 2020/1/1.
 */
public class RootConfigTest extends BaseTest {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void sqlSessionFactory() throws Exception {
        Assert.assertNotNull(sqlSessionFactory);
    }
}