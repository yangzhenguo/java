package com.hiyzg.shop.dao;

import com.hiyzg.shop.criteria.UserCriteria;
import com.hiyzg.shop.model.User;
import com.hiyzg.util.Page;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/10/11.
 */
public interface UserDao extends Dao<User> {
    User insert(User user);

    Page<User> selectPager(UserCriteria criteria);

    List<User> select(UserCriteria criteria);

    long count(UserCriteria criteria);

    Optional<User> selectByUsername(String username);
}
