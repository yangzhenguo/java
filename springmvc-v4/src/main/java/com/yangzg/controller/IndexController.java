package com.yangzg.controller;

import com.yangzg.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Sam on 2019/11/21.
 */
@Controller
@SessionAttributes({"name", "currentUser"})
@RequestMapping("/")
public class IndexController {
    private Map<Integer, Student> DB = new HashMap<Integer, Student>(){
        private static final long serialVersionUID = 1L;
        {
            put(1, new Student("yangzg", "123456", "yangzg@test.com", 1, null));
            put(2, new Student("yzg", "654321", "yzg@test.com", 2, null));
        }
    };

    @ModelAttribute("student")
    private Student getStudent(@PathVariable(value = "id", required = false) Integer idd, @RequestParam(required = false, defaultValue = "0") int id) {
        if (null != idd && idd > 0) {
            return DB.get(idd);
        }
        return null;
    }

    @RequestMapping("/reader")
    public void reader(Reader reader) throws IOException {
        char[] buffer = new char[1 << 10];
        int len = 0;
        while ((len = reader.read(buffer)) > -1) {
            System.out.println("content: " + new String(buffer, 0, len));
        }
        reader.close();
    }

    @RequestMapping
    public void index(@RequestHeader("user-agent") String userAgent, Writer writer, Locale locale, @CookieValue(required = false) String name) throws IOException {
        System.out.println(userAgent);
        writer.write(userAgent);
    }

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test1() {
        return "test1";
    }

    @RequestMapping(value = "/test1", method = RequestMethod.POST)
    public String test1(Student student) {
        System.out.println(student);
        return "test1";
    }

    @RequestMapping("/test2")
    public ModelAndView test2(ModelAndView modelAndView) {
        modelAndView.setViewName("test1");
        modelAndView.addObject("username", "yzg");
        return modelAndView;
    }

    @RequestMapping("/test3")
    public String test3(@RequestParam String name, Map<String, Object> map) {
        map.put("name", name);
        return "test3";
    }

    @RequestMapping("/test4")
    public String test4(HttpSession session, Writer writer, Model model) throws IOException {
        model.addAttribute("currentUser", new Student("test4", "abc", "test4@test.com", 1, null));
        return "test4";
    }

    @RequestMapping("/test5")
    public String test5(Map<String, Object> map, Writer writer) throws IOException {
        map.put("currentUser", new Student("test5", "abc", "test5@test.com", 2, null));
        return "test5";
    }

    @RequestMapping("/test6")
    public String test6(@SessionAttribute(value = "currentUser", required = false) Student currentUser, Writer writer) throws IOException {

        return "test6";
    }

    @RequestMapping("/test7/{id}")
    public String test7(@PathVariable("id") Integer id, @ModelAttribute("student") Student student) {
        System.out.println(id);
        System.out.println(student);
        return "test7";
    }
}
