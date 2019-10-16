package com.hiyzg.shop.dao;

import com.hiyzg.shop.model.Account;

import java.util.Optional;

/**
 * Created by Sam on 2019/10/16.
 */
public interface AccountDao {
    Optional<Account> selectByNo(String no);

    boolean updateBalance(String no, double balance);
}
