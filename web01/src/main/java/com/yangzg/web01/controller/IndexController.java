package com.yangzg.web01.controller;

import com.yangzg.web01.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sam
 * @date 2020/3/28 8:24 PM
 */
@RestController
@RequestMapping("/")
public class IndexController {
    @Autowired
    @Lazy
    private Person person;

    @GetMapping("/index")
    public String index() {
        return person.toString();
    }
}
