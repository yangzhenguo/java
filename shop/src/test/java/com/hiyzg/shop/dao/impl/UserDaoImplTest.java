package com.hiyzg.shop.dao.impl;

import com.hiyzg.shop.criteria.UserCriteria;
import com.hiyzg.shop.dao.UserDao;
import com.hiyzg.shop.model.User;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

/**
 * Created by Sam on 2019/10/11.
 */
public class UserDaoImplTest {
    private UserDao userDao = new UserDaoImpl();

    @Test
    public void insert() {
        final long id = userDao.insert("INSERT INTO user(username, password) VALUES(?, ?)", "yzg", "yzg1");
        System.out.println(id);
        assertTrue(id > 0);
    }

    @Test
    public void selectById() {
        final Optional<User> userOptional = this.userDao.selectById("SELECT * FROM user WHERE id = ?", 1);
        userOptional.ifPresent(System.out::println);
        assertTrue(userOptional.isPresent());
    }

    @Test
    public void count() {
        final long count = this.userDao.count(new UserCriteria("yzg"));
        System.out.println(count);
    }

    @Test
    public void selectByUsername() {
        final Optional<User> userOptional = this.userDao.selectByUsername("yzg");
        userOptional.ifPresent(System.out::println);
    }
}