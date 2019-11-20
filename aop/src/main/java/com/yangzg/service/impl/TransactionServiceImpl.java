package com.yangzg.service.impl;

import com.yangzg.service.TransactionService;

/**
 * Created by Sam on 2019/11/20.
 */
public class TransactionServiceImpl implements TransactionService {
    @Override
    public void repay() {
        System.out.println("预支付");
    }

    @Override
    public void pay() {
        System.out.println("支付");
    }
}
