package com.yangzg.annotation3.controller;

import com.yangzg.annotation3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Sam on 2019/11/18.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public void execute() {
        userService.add();
    }
}
