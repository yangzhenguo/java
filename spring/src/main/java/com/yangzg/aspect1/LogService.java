package com.yangzg.aspect1;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

/**
 * Created by Sam on 2019/10/31.
 */
public class LogService {
    public void logBefore(JoinPoint joinPoint) {
        final String methodName = joinPoint.getSignature().getName();
        final Object[] params = joinPoint.getArgs();
        System.out.println(String.format("method: %s, args: %s", methodName, Arrays.toString(params)));
    }
}
