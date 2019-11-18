package com.yangzg.annotation3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Sam on 2019/11/18.
 */
@Configuration
@ComponentScan("com.yangzg.annotation3")
public class Application {
    @Bean
    @Primary
    public Map<Integer, Double> map() {
        return IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toMap(n -> n, n -> Math.random()));
    }
}
