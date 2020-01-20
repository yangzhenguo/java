package com.yangzg.java.spring.boot.controller;

import com.yangzg.java.spring.boot.property.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sam on 2020/1/14.
 * @author Sam
 */
@Controller
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Value("${haha.app.welcome}")
    private String welcome;

    @Autowired
    private AppProperties appProperties;

    @GetMapping("/hello")
    public String hello(Map<String, Object> map) {
        map.put("link", "http://www.baidu.com/");
        return "hello";
    }

    @GetMapping("/css")
    public String css(@RequestParam("color") String backgroundColor) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return String.format("body {background-color: #%s;}", backgroundColor);
    }

    @PostMapping("/post")
    public String post(HttpServletRequest request, @RequestBody(required = false) String content) throws IOException {
        new BufferedReader(new InputStreamReader(request.getInputStream())).lines().forEach(System.out::println);
        System.out.println(content);
        return content;
    }
}
