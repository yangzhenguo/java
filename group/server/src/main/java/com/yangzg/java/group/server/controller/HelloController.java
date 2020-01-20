package com.yangzg.java.group.server.controller;

import com.yangzg.java.group.server.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Sam on 2020/1/16.
 * @author Sam
 */
@RestController
public class HelloController {

    @ModelAttribute
    public Person modelAttribute() {
        System.out.println("modelAttribute...");
        return new Person();
    }

    @GetMapping(value = "")
    public String hello(@RequestBody(required = false) String person) {
        System.out.println(person);
        return "hello";
    }

    @PostMapping(value = "/post")
    public String post(@RequestBody(required = false) String content) {
        System.out.println(content);
        return "fff";
    }

    @PutMapping("/put")
    public String put(@RequestBody(required = false) String content) {
        System.out.println(content);
        return content;
    }
}
