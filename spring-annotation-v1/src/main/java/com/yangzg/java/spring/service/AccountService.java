package com.yangzg.java.spring.service;

import com.yangzg.java.spring.model.Account;

import java.util.Optional;

/**
 * Created by Sam on 2020/1/13.
 * @author Sam
 */
public class AccountService {
    Optional<Account> createAccount(final Account account) {
        return Optional.empty();
    }

    public Optional<Account> readAccount(final String id) {
        return Optional.empty();
    }

    Optional<Account> updateAccount(final Account account) {
        return Optional.empty();
    }

    boolean deleteAccount(final String id) {
        return false;
    }
}
