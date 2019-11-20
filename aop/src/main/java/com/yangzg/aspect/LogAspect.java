package com.yangzg.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Sam on 2019/11/19.
 */
@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* com.yangzg.service.impl.*.*(..)) && within(com.yangzg..*)")
    private void pointcutForAfterReturningRecord() {}

    @AfterReturning(value = "pointcutForAfterReturningRecord()", returning = "rtn")
    public void afterReturningRecord(Object rtn) {
        System.out.println(String.format("返回通知，返回值:%s", rtn));
    }

    public void beforeRecord(JoinPoint joinPoint) {
        System.out.println(String.format("method: %s, arguments: %s", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())));
    }
}
