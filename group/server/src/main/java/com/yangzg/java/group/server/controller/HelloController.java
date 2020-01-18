package com.yangzg.java.group.server.controller;

import com.yangzg.java.group.server.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

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
    public String hello(Person person) {
        System.out.println(person);
        return "hello";
    }
}
