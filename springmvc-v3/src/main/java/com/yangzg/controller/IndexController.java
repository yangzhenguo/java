package com.yangzg.controller;

import com.yangzg.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Sam on 2019/11/12.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping("/index")
    public String index(Model mav) {
        final List<Person> persons = IntStream.rangeClosed(1, 10).boxed().map(num -> new Person(num, "sam" + num, Math.random() * num)).collect(Collectors.toList());
        mav.addAttribute("persons", persons);
        return "/WEB-INF/classes/views/index.jsp";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}
