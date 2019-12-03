package com.yangzg.crud.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sam on 2019/12/3.
 */
@Controller
public class HelloController {
    @GetMapping("/${hello.path:hello}")
    public String handle(Model model) {
        model.addAttribute("message", "Hello World!");
        return "hello";
    }

    @ResponseBody
    @GetMapping(value = "/consumes", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, Object> consumes() {
        return new HashMap<String, Object>() {
            private static final long serialVersionUID = -6692761828144558364L;
            {
                put("name", "yzg");
                put("age", 12);
            }
        };
    }

    @ResponseBody
    @GetMapping(value = "/produces", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, Object> produces() {
        return new HashMap<String, Object>() {
            private static final long serialVersionUID = -6692761828144558364L;
            {
                put("name", "yangzg");
                put("age", 13);
            }
        };
    }
}
