package com.yangzg.model1;

import lombok.Data;

/**
 * Created by Sam on 2019/10/30.
 */
@Data
public class HelloWorld {
    private String name;

    public HelloWorld() {
        System.out.println("1");
    }

    public HelloWorld(String name) {
        this.name = name;
        System.out.println("2");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(777);
    }
}
