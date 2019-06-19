package com.yangzg.spring.chapter05;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Sam on 2019/6/19.
 */
public class JsonUtil {
    public static String toJsonString(Map<String, Object> map) {
        return map.keySet().stream()
                .map(key -> String.format("\"%s\": %s", key, (map.get(key) instanceof CharSequence ? "\"" + map.get(key) + "\"" : map.get(key))))
                .collect(Collectors.joining(",", "{", "}"));
    }
}
