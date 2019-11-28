package com.yangzg.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Sam on 2019/11/20.
 */
public class PointcutAspect {
    @Pointcut("execution(public * *(..))")
    public void anyPointcut() {}
}
