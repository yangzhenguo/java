package com.yangzg.service4;

import com.yangzg.config4.Application;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Sam on 2019/11/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class })
public class ShopServiceTest {
    @Autowired
    private ShopService shopService;

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void purchase() throws Exception {
        this.shopService.purchase("sam", "java");
    }

    @Test
    public void sessionFactory() throws Exception {
        Assert.assertNotNull(sessionFactory);
    }
}