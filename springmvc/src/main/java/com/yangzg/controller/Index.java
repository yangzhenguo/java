package com.yangzg.controller;

import com.yangzg.config.ScheduledConfig;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

/**
 * Created by Sam on 2019/6/19.
 */
@Controller
@CrossOrigin
public class Index {
    @Autowired
    @Lazy
    private ScheduledConfig scheduledConfig;

    @RequestMapping(value = "/", produces = "text/xml;charset=UTF-8")
    public @ResponseBody Object index() {
        Optional<Document> documentOptional = this.scheduledConfig.test1();
        if (documentOptional.isPresent()) {
            return documentOptional.get();
        } else {
            return new HashMap<String, Object>(){
                private static final long serialVersionUID = -4015948799975322410L;

                {
                put("success", false);
                put("message", "no data");
            }};
        }
    }

    @GetMapping("/hello")
    public String hello() {
        return "index";
    }

    @GetMapping(value = "/push", produces = "text/event-stream;charset=UTF-8")
    public @ResponseBody String push() throws InterruptedException {
        Thread.sleep(5000);
        return "data:" + new Date().toString() + "\n\n";
    }

    @GetMapping("/defer")
    public DeferredResult<String> deferredCall() {
        return this.scheduledConfig.getAsyncUpdate();
    }
}
