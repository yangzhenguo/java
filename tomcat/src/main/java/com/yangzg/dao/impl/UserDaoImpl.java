package com.yangzg.dao.impl;

import com.yangzg.dao.inf.UserDao;
import com.yangzg.model.User;
import com.yangzg.util.MysqlPool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/9/20.
 */
public class UserDaoImpl implements UserDao {

    private QueryRunner queryRunner = new QueryRunner(MysqlPool.getDataSource());

    @Override
    public List<User> selectAll() throws SQLException {
        return queryRunner.query("select * from user", new BeanListHandler<>(User.class));
    }

    @Override
    public Optional<User> selectByUsername(String username) {
        try {
            return Optional.ofNullable(this.queryRunner.query("select * from user where username = ?", new BeanHandler<User>(User.class), username));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
