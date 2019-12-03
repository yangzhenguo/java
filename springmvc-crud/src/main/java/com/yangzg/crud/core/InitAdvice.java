package com.yangzg.crud.core;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sam on 2019/12/1.
 */
@ControllerAdvice
public class InitAdvice {
    @ModelAttribute
    public Map<String, Object> md() {
        final Map<String, Object> map = new HashMap<>();
        map.put("name", "yzg");
        map.put("age", 13);
        return map;
    }
}
