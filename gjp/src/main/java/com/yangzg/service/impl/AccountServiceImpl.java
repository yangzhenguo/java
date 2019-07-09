package com.yangzg.service.impl;

import com.yangzg.dao.impl.AccountDaoImpl;
import com.yangzg.dao.inf.AccountDao;
import com.yangzg.model.Account;
import com.yangzg.service.inf.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/7/9.
 */
public class AccountServiceImpl implements AccountService {
    public static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
    private AccountDao accountDao = new AccountDaoImpl();

    @Override
    public List<Account> listAll() {
        LOGGER.info("查询全量账户信息");
        return this.accountDao.selectAll();
    }

    @Override
    public Optional<Account> getById(Integer id) {
        return this.accountDao.selectById(id);
    }

    @Override
    public boolean edit(Account bean) {
        return this.accountDao.update(bean);
    }
}
