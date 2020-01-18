package com.yangzg.java.spring.boot.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Sam on 2020/1/15.
 * @author Sam
 */
@Data
@Component
@ConfigurationProperties("haha.app")
public class AppProperties {
    private String welcome;
    private Person person;

    @Data
    public static class Person {
        private List<String> names;
        private String address;
    }
}
