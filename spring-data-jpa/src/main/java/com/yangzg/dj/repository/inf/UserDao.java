package com.yangzg.dj.repository.inf;

import com.yangzg.dj.model.User;

import java.util.Optional;

/**
 * Created by Sam on 2019/12/13.
 */
public interface UserDao {
    Optional<User> selectOne();
}
