package com.yangzg.v2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Sam on 2019/11/6.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String hello() {
        return "index";
    }
}
