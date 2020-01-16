package com.yangzg.java.group.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sam on 2020/1/16.
 * @author Sam
 */
@RestController
public class HelloController {
    @GetMapping("")
    public String hello() {
        return "hello";
    }
}
