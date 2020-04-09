package com.yangzg.lesson5.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Sam on 2020/3/22.
 */
@Component
@Aspect
public class LoggingAspect {
    @Pointcut(value = "execution(int com.yangzg..Calculator.*(int, int))")
    public void defaultPointCut() {}

    @Pointcut(value = "execution(int com.yangzg..Calculator.*(int, int)) && args(a, b)", argNames = "a, b")
    public void pointCut(int a, int b) {}

    @Before(value = "pointCut(a, b)", argNames = "joinPoint, a, b")
    public void beforeLogging(JoinPoint joinPoint, int a, int b) {
        System.out.println(joinPoint);
    }

    @After(value = "pointCut(a, b)", argNames = "joinPoint, a, b")
    public void afterLogging(JoinPoint joinPoint, int a, int b) {
        System.out.println(String.format("%s %s", "after", joinPoint));
    }

    @AfterReturning(value = "execution(int com.yangzg..Calculator.*(..))", returning = "result")
    public void returnLogging(JoinPoint joinPoint, int result) {
        System.out.println(String.format("result=%s", result));
    }

    @AfterThrowing(value = "pointCut(a, b)", argNames = "joinPoint, a, b, exception", throwing = "exception")
    public void exceptionLogging(JoinPoint joinPoint, int a, int b, Exception exception) {
        System.out.println(String.format("exception: %s, a=%s, b=%s, joinPoint=%s", exception, a, b, joinPoint));
    }

    public void before(JoinPoint joinPoint) {
        System.out.println(String.format("%s, %s", "logging", joinPoint));
    }
}
