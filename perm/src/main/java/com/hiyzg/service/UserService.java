package com.hiyzg.service;

import com.hiyzg.model.User;

import java.util.Optional;

/**
 * Created by Sam on 2019/10/1.
 */
public interface UserService {
    Optional<User> get(int id);

    Optional<User> get(String username);
}
