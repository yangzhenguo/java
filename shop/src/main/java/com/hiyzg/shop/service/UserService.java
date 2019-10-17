package com.hiyzg.shop.service;

import com.hiyzg.shop.model.User;

import java.util.Optional;

/**
 * Created by Sam on 2019/10/17.
 */
public interface UserService {
    Optional<User> getByUsername(String username);
}
