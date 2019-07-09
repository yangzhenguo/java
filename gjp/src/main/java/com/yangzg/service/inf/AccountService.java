package com.yangzg.service.inf;

import com.yangzg.model.Account;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/7/9.
 */
public interface AccountService {
    List<Account> listAll();

    Optional<Account> getById(Integer id);

    boolean edit(Account bean);
}
