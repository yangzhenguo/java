package com.hiyzg.service.impl;

import com.hiyzg.dao.AuthorityDao;
import com.hiyzg.dao.UserDao;
import com.hiyzg.dao.impl.AuthorityDaoImpl;
import com.hiyzg.dao.impl.UserDaoImpl;
import com.hiyzg.model.User;
import com.hiyzg.service.UserService;

import java.util.Optional;

/**
 * Created by Sam on 2019/10/1.
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    private AuthorityDao authorityDao = new AuthorityDaoImpl();

    @Override
    public Optional<User> get(int id) {
        final Optional<User> userOptional = this.userDao.findById(id);
        userOptional.ifPresent(user -> user.setAuthorities(this.authorityDao.findByUserId(user.getId())));
        return userOptional;
    }

    @Override
    public Optional<User> get(String username) {
        final Optional<User> userOptional = this.userDao.findByUsername(username);
        userOptional.ifPresent(user -> user.setAuthorities(this.authorityDao.findByUserId(user.getId())));
        return userOptional;
    }
}
