package com.yangzg.dj.service.impl;

import com.yangzg.dj.BaseTest;
import com.yangzg.dj.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

/**
 * Created by Sam on 2019/12/13.
 */
public class UserServiceImplTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void findAll() throws Exception {
        this.userService.findAll(PageRequest.of(1, 10)).forEach(System.out::println);
    }

}