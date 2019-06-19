package com.yangzg.spring.chapter03;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Sam on 2019/6/18.
 */
@Data
@Component
public class SystemConfig {
    @Value("#{systemProperties['java.runtime.name'].toUpperCase()}")
    private String runtimeName;

    @Value("#{systemEnvironment['path']?.toUpperCase()}")
    private String path;

    @Value("#{dbConfig.username}")
    private String username;

    // 进行逻辑运算
    @Value("#{9 > 100 and 0 <= 200}")
    private boolean logicOperation;

    @Value("#{new java.util.Random().ints().limit(10).toArray()}")
    private int[] r;

    @Value("#{'hgjhjh'.matches('\\w+')}")
    private boolean j;

//    @Value("#{T(java.util.Random).nextInt(100)}")
//    private int age;
}
