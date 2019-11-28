package com.yangzg.dao.inf;

import com.yangzg.model.Account;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/7/9.
 */
public interface AccountDao {
    List selectAll();

    Optional<Account> selectById(Integer id);

    boolean update(Account bean);
}
