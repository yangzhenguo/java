package com.yangzg.aspect1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Created by Sam on 2019/10/31.
 */
@Component
@Aspect
public class PermAspect {
    @Before("execution(* *..service2.*.*(..))")
    public void verifyAdmin() {
        System.out.println("haha");
    }
}
