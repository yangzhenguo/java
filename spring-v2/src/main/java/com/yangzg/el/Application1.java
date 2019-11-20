package com.yangzg.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

/**
 * Created by Sam on 2019/11/20.
 */
@Configuration
public class Application1 {
    @Value("${java.runtime.name}")
    private String runtimeName;

    @Value("#{{'yzg', 'yangzg', 'sam'}}")
    public List<String> names;

    @Value("#{{{first: 'young', last: 'zg'}, {first: 'y', last: 'zg'}}}")
    public List<Map<String, String>> nameList;

    @Value("#{{systemProperties['user.country'], '${name: Sam}', '${java.runtime.name}'}}")
    public List<String> environs;
}
