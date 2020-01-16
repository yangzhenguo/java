package com.yangzg.java.spring.boot.controller;

import com.yangzg.java.spring.boot.property.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sam on 2020/1/14.
 * @author Sam
 */
@RestController
public class HelloController {
    @Value("${haha.app.welcome}")
    private String welcome;

    @Autowired
    private AppProperties appProperties;

    @RequestMapping("/hello")
    public String hello() {
        System.out.println(this.appProperties);
        return this.welcome;
    }
}
