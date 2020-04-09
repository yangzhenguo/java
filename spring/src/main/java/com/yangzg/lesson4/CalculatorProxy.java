package com.yangzg.lesson4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Sam on 2020/3/21.
 */
public class CalculatorProxy {
    public static Calculator getInstance(Calculator calculator) {
        final Class<? extends Calculator> clazz = calculator.getClass();
        return (Calculator)Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke = null;
                try {
                    System.out.println("start");
                    invoke = method.invoke(calculator, args);
                } finally {
                    System.out.println("end");
                    return invoke;
                }
            }
        });
    }
}
