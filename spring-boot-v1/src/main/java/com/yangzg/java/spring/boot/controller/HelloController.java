package com.yangzg.java.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Sam on 2020/1/14.
 * @author Sam
 */
@Controller
@ResponseBody
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
