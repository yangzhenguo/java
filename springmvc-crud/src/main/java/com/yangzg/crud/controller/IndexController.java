package com.yangzg.crud.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Created by Sam on 2019/11/24.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public String index() {
        return "redirect:/employee";
    }

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String test() {
        return "test";
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> download() throws IOException {
        final InputStream resourceAsStream = IndexController.class.getClassLoader().getResourceAsStream("jdbc.properties");
        byte[] body = new byte[resourceAsStream.available()];
        resourceAsStream.read(body);
        return new ResponseEntity<>(body, new HttpHeaders() {
            private static final long serialVersionUID = 1277466117271964319L;
            {
                this.setContentDispositionFormData("attachment", "哈哈.txt", Charset.forName("UTF-8"));
            }
        }, HttpStatus.OK);
    }
}
