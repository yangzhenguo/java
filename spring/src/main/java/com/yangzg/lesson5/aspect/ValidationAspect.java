package com.yangzg.lesson5.aspect;

import com.yangzg.lesson5.annotation.Min;
import com.yangzg.lesson5.annotation.NotNull;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Parameter;

/**
 * Created by Sam on 2020/3/22.
 */
@Component
@Aspect
public class ValidationAspect {
    @Pointcut("execution(* *..*.*(..))")
    public void defaultPointCut() {}

    @Before("defaultPointCut()")
    public void validateNotNull(JoinPoint joinPoint) {
        final Signature signature = joinPoint.getSignature();
        final MethodSignature methodSignature = (MethodSignature) signature;
        for (Parameter parameter : methodSignature.getMethod().getParameters()) {
            if (parameter.isAnnotationPresent(NotNull.class)) {
                final NotNull notNull = parameter.getAnnotation(NotNull.class);
                System.out.println(signature.getName() + ", " + notNull + ", " + parameter);
            }
        }
    }

    @Around("defaultPointCut()")
    public Object validateMin(ProceedingJoinPoint joinPoint) throws Throwable {
        final Object[] args = joinPoint.getArgs();
        final Signature signature = joinPoint.getSignature();
        final MethodSignature methodSignature = (MethodSignature) signature;
        for (int i = 0; i < methodSignature.getMethod().getParameters().length; i++) {
            Parameter parameter = methodSignature.getMethod().getParameters()[i];
            if (parameter.isAnnotationPresent(Min.class)) {
                final Min minAnnotation = parameter.getAnnotation(Min.class);
                final int min = minAnnotation.value();
                final int value = Integer.parseInt(args[i].toString());
                if (value < min) {
                    throw new RuntimeException("数字太小了");
                }
            }
        }
        return joinPoint.proceed();
    }

    public void before(JoinPoint joinPoint) {
        System.out.println(String.format("%s, %s", "validation", joinPoint));
    }
}
