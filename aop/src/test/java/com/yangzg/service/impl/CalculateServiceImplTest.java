package com.yangzg.service.impl;

import bootstrap.Application;
import com.yangzg.service.CalculateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Sam on 2019/11/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class CalculateServiceImplTest {
    @Resource
    private CalculateService calculateService;

    @Test
    public void add() throws Exception {
        this.calculateService.add(1, 2);
    }

    @Test
    public void minus() throws Exception {
        this.calculateService.minus(2, 1);
    }

    @Test
    public void multi() throws Exception {
        this.calculateService.multi(3, 2);
    }

    @Test
    public void divide() throws Exception {
        this.calculateService.divide(3, 2);
    }
}