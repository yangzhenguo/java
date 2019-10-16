package com.hiyzg.shop.dao.impl;

import com.hiyzg.shop.dao.AccountDao;
import com.hiyzg.shop.model.Account;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Sam on 2019/10/16.
 */
public class AccountDaoImplTest {
    private AccountDao accountDao = new AccountDaoImpl();

    @Test
    public void selectByNo() throws Exception {
        final Optional<Account> accountOptional = this.accountDao.selectByNo("123");
        accountOptional.ifPresent(System.out::println);
    }

    @Test
    public void updateBalance() throws Exception {
        final boolean balance = this.accountDao.updateBalance("123", 2523.12);
        assertTrue(balance);
    }

}