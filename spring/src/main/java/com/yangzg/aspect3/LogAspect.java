package com.yangzg.aspect3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Sam on 2019/11/1.
 */
@Component
@Aspect
public class LogAspect {
    @Before("execution(* com.yangzg.service3.*.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println(String.format("method: %s, params: %s", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())));
    }
}
