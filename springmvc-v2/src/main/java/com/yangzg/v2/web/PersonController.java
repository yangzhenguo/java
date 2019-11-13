package com.yangzg.v2.web;

import com.yangzg.v2.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.Date;

/**
 * Created by Sam on 2019/11/8.
 */
@Controller
@RequestMapping(value = "/persons", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PersonController {
    @Autowired
    ResourceBundleMessageSource messageSource;

    @GetMapping("/special/{id}")
    public String getPerson(@PathVariable Long id) {
        return new Person(id, "yangzg", 12).toString();
    }

    @GetMapping("/${app:toptop}/now")
    public String now() {
        return Date.from(Instant.now()).toString();
    }

    @GetMapping("/{name:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{ext:\\.[a-z]+}")
    public String spring(@PathVariable String name, @PathVariable String version, @PathVariable String ext) {
        return String.format("%s-%s%s", name, version, ext);
    }

    @GetMapping(value = "/data")
    public String data() {
        return "123";
    }

    @GetMapping(value = "/data1")
    public View data1(HttpServletRequest request) {
        System.out.println(messageSource.getMessage("hello", null, request.getLocale()));
        return new InternalResourceView("/WEB-INF/views/index.jsp");
    }

    @GetMapping(value = "/data2")
    public View data2() {
        return new InternalResourceView("/WEB-INF/views/index.jsp");
    }
}
