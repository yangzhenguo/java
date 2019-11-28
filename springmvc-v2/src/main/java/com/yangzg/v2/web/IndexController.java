package com.yangzg.v2.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by Sam on 2019/11/6.
 */
@Controller
public class IndexController {
    @GetMapping(value = "/index")
    public String hello(@RequestHeader Map<String, Object> headers, Model model) {
        model.addAttribute("message", headers);
        return "index";
    }

    public static void main(String[] args) {
        String[] includes = {"EG", "CN"};
        System.out.println(String.format(" and country in ('%s')", String.join("','", includes)));
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download() throws IOException {
        try (InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("i18n.properties")) {
            final byte[] bytes = new byte[resourceAsStream.available()];
            resourceAsStream.read(bytes);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Disposition", String.format("attachment;filename=%s", "hah.txt"));
            return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);
        }
    }
}
