package com.hiyzg.shop.dao.impl;

import com.hiyzg.shop.dao.AccountDao;
import com.hiyzg.shop.model.Account;
import com.hiyzg.shop.util.ConnectionContext;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.Optional;

/**
 * Created by Sam on 2019/10/16.
 */
public class AccountDaoImpl extends BaseDao<Account> implements AccountDao {
    @Override
    public Optional<Account> selectByNo(String no) {
        try {
            final String sql = "SELECT * FROM account WHERE no = ?";
            return Optional.ofNullable(this.queryRunner.query(sql, new BeanHandler<Account>(getClazz()), no));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean updateBalance(String no, double balance) {
        final String sql = "UPDATE account SET balance = ? WHERE no = ?";
        try {
            return this.queryRunner.update(ConnectionContext.getInstance().get(), sql, balance, no) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
