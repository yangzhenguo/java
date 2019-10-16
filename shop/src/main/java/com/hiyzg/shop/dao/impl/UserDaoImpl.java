package com.hiyzg.shop.dao.impl;

import com.hiyzg.shop.criteria.UserCriteria;
import com.hiyzg.shop.dao.UserDao;
import com.hiyzg.shop.model.User;
import com.hiyzg.util.Page;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/10/11.
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public User insert(User user) {
        String sql = "INSERT INTO user(username, password) VALUES(?, ?)";
        user.setId(this.insert(sql, user.getUsername(), user.getPassword()));
        return user;
    }

    @Override
    public Page<User> selectPager(UserCriteria criteria) {
        return null;
    }

    @Override
    public List<User> select(UserCriteria criteria) {
        return null;
    }

    @Override
    public long count(UserCriteria criteria) {
        String sql = "SELECT COUNT(*) FROM user WHERE 1 = 1";
        if (criteria.getName() != null) {
            sql += " AND username = ?";
            return this.count(sql, criteria.getName());
        } else {
            return this.count(sql);
        }
    }

    @Override
    public Optional<User> selectByUsername(String username) {
        try {
            final String sql = "SELECT * FROM user WHERE username = ?";
            return Optional.ofNullable(this.queryRunner.query(sql, new BeanHandler<User>(getClazz()), username));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
