package com.yangzg.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Sam on 2019/6/25.
 */
@Controller
public class IndexController {
    @PostMapping("/doLogin")
    public String login(@RequestParam String username, @RequestParam String password) {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {
            return "redirect:/";
        } else {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            currentUser.login(token);
            return "redirect:/";
        }
    }

    @GetMapping("/login")
    public String loginPage() {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {
            return "redirect:/";
        }
        return "login";
    }
}
