package com.hiyzg.dao;

import com.hiyzg.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/9/30.
 */
public interface UserDao extends BaseDao<User> {
    Optional<User> findByUsername(String username);

    List<User> findByAuthorityId(Integer authorityId);
}
