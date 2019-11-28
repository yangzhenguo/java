package com.yangzg.spring.chapter02;

import java.lang.annotation.*;

/**
 * Created by Sam on 2019/6/18.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Action {
    String name();
}
