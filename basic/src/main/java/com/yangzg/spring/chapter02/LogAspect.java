package com.yangzg.spring.chapter02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by Sam on 2019/6/18.
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(com.yangzg.spring.chapter02.Action)")
    public void annotationPointCut(){}

    @Pointcut("execution(* com.yangzg.spring.chapter02.*Service.*(..))")
    public void executionTimePointCut() {}

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截, " + method.getName() + ", " + action.name());
    }

    @Before("execution(* com.yangzg.spring.chapter02.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截, " + method.getName());
    }

    @Around("executionTimePointCut() && args(arg)")
    public Object around(ProceedingJoinPoint joinPoint, String arg) throws Throwable {
        long start = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println(signature.getMethod().getName() + ", " + (end - start));
        return result;
    }
}
