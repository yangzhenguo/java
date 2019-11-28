package com.yangzg.spring.chapter05;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sam on 2019/6/19.
 */
@RestController
public class HelloController {
    @RequestMapping("/index")
    public String hello(HttpServletRequest request) {
        return request.getServletContext().getServerInfo();
    }
}
