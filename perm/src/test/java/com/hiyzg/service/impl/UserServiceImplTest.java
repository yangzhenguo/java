package com.hiyzg.service.impl;

import com.hiyzg.model.User;
import com.hiyzg.service.UserService;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Sam on 2019/10/1.
 */
public class UserServiceImplTest {
    private UserService userService = new UserServiceImpl();

    @Test
    public void get1() throws Exception {
        final Optional<User> userOptional = this.userService.get(1);
        userOptional.ifPresent(System.out::println);
        assertTrue(userOptional.isPresent());
    }

    @Test
    public void get2() throws Exception {
        final Optional<User> userOptional = this.userService.get("yangzg");
        userOptional.ifPresent(System.out::println);
        assertTrue(userOptional.isPresent());
    }

}