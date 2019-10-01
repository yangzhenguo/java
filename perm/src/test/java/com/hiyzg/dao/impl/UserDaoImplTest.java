package com.hiyzg.dao.impl;

import com.hiyzg.dao.UserDao;
import com.hiyzg.model.User;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Sam on 2019/9/30.
 */
public class UserDaoImplTest {
    private UserDao userDao = new UserDaoImpl();

    @Test
    public void findById() {
        final Optional<User> userOptional = this.userDao.findById(1);
        userOptional.ifPresent(System.out::println);
        assertTrue(userOptional.isPresent());
    }

    @Test
    public void findByUsername() {
        final Optional<User> userOptional = this.userDao.findByUsername("yangzg");
        userOptional.ifPresent(System.out::println);
        assertTrue(userOptional.isPresent());
    }
}