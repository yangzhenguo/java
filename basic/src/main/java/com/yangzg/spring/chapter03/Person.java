package com.yangzg.spring.chapter03;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * Created by Sam on 2019/6/18.
 */
@Data
@Repository
public class Person {
    @Value("sam")
    private String name;

    @Value("12")
    private int age;
}
