package com.yangzg.lesson5;

import com.yangzg.lesson5.annotation.Min;
import com.yangzg.lesson5.annotation.NotNull;
import org.springframework.core.io.Resource;

/**
 * Created by Sam on 2020/3/22.
 */
public interface Calculator {
    int plus(@NotNull int a, int b);

    int minus(int a, int b);

    int div(int a, @Min(1) int b);

    Resource getAbc();
}
