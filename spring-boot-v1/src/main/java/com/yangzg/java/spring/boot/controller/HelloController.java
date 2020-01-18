package com.yangzg.java.spring.boot.controller;

import com.yangzg.java.spring.boot.property.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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
        System.out.println(this.appProperties.getPerson());
        return this.welcome;
    }

    @GetMapping("/css")
    public String css(@RequestParam("color") String backgroundColor) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return String.format("body {background-color: #%s;}", backgroundColor);
    }
}
