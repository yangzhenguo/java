package com.hiyzg.shop.service;

import com.hiyzg.shop.model.Account;

import java.util.Optional;

/**
 * Created by Sam on 2019/10/17.
 */
public interface AccountService {
    Optional<Account> getByNo(String no);
}
