package com.yangzg.lesson2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

/**
 * Created by Sam on 2020/3/14.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private int age;
    private Car car;

    @Bean
    @DependsOn("audi")
    public Car car() {
        return new Car("BMW", "B");
    }
}
