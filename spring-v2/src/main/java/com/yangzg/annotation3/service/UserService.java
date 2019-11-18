package com.yangzg.annotation3.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Sam on 2019/11/18.
 */
@Service
public class UserService {
    @Value("#{{" +
            "'abc': 123," +
            "'bca': 231," +
            "'cba': 321," +
            "'acb': 132," +
            "'bac': 213," +
            "'cab': 312" +
            "}}")
    public Map<String, Integer> map;

    @Resource
    private Optional<Map> m;

    @Resource
    private Map mm;

    @Resource(name = "systemProperties")
    private Map<String, Object> systemProperties;

    @Resource(name = "systemEnvironment")
    private Map<String, Object> systemEnvironment;

    @Value("${PATH}")
    private String path;

    @Value("#{systemEnvironment['PATH'].split(':')}")
    private List<String> paths;

    public void add() {
        System.out.println("UserService add...");
        System.out.println(this.m);
        System.out.println(this.mm);
        System.out.println(this.systemEnvironment);
        System.out.println(this.systemProperties);
        System.out.println(String.format("PATH: %s", this.path));

        System.out.println(this.paths);
        System.out.println(this.paths.size());
    }
}
