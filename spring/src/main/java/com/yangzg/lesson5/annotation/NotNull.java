package com.yangzg.lesson5.annotation;

import java.lang.annotation.*;

/**
 * Created by Sam on 2020/3/22.
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotNull {
}
