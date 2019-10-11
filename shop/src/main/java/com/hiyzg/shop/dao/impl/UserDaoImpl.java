package com.hiyzg.shop.dao.impl;

import com.hiyzg.shop.criteria.UserCriteria;
import com.hiyzg.shop.dao.UserDao;
import com.hiyzg.shop.model.User;
import com.hiyzg.util.Page;

import java.util.List;

/**
 * Created by Sam on 2019/10/11.
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public User insert(User user) {
        String sql = "insert into user(username, password) values(?, ?)";
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
        String sql = "select count(*) from user where 1 = 1";
        if (criteria.getName() != null) {
            sql += " and username = ?";
            return this.count(sql, criteria.getName());
        } else {
            return this.count(sql);
        }
    }
}
