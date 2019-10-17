package com.hiyzg.shop.service.impl;

import com.hiyzg.shop.dao.UserDao;
import com.hiyzg.shop.dao.impl.UserDaoImpl;
import com.hiyzg.shop.model.User;
import com.hiyzg.shop.service.UserService;

import java.util.Optional;


/**
 * Created by Sam on 2019/10/17.
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public Optional<User> getByUsername(String username) {
        return this.userDao.selectByUsername(username);
    }
}
