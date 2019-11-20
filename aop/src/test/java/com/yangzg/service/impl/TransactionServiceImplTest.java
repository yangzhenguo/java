package com.yangzg.service.impl;

import com.yangzg.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Sam on 2019/11/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aop1.xml")
@ActiveProfiles("development")
public class TransactionServiceImplTest {
    @Resource
    private TransactionService transactionService;

    @Test
    public void repay() throws Exception {
        this.transactionService.pay();
    }

    @Test
    public void pay() throws Exception {
        this.transactionService.repay();
    }

}