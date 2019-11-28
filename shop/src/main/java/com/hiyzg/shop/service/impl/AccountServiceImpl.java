package com.hiyzg.shop.service.impl;

import com.hiyzg.shop.dao.AccountDao;
import com.hiyzg.shop.dao.impl.AccountDaoImpl;
import com.hiyzg.shop.model.Account;
import com.hiyzg.shop.service.AccountService;

import java.util.Optional;

/**
 * Created by Sam on 2019/10/17.
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = new AccountDaoImpl();

    @Override
    public Optional<Account> getByNo(String no) {
        return this.accountDao.selectByNo(no);
    }
}
