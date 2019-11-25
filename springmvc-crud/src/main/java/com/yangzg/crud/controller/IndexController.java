package com.yangzg.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

/**
 * Created by Sam on 2019/11/24.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private ResourceBundleMessageSource messageSource;

    @GetMapping
    public String index() {
        System.out.println(this.messageSource.getMessage("disabled", null, Locale.SIMPLIFIED_CHINESE));
        return "redirect:/employee";
    }
}
