package com.yangzg.lesson2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.LocalDateTime;

/**
 * Created by Sam on 2020/3/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/lesson2/applicationContext1.xml")
public class PersonTest2 {
    @Resource
    private double el1;

    @Resource
    private String el2;

    @Resource
    private LocalDateTime startTime;

    @Test
    public void test1() throws Exception {
        System.out.println(this.el1);
    }

    @Test
    public void test2() throws Exception {
        System.out.println(this.el2);
    }

    @Test
    public void test3() throws Exception {
        System.out.println(this.startTime);
    }

    @Test
    public void test4() throws Exception {
        final HpComputor hpComputor = new HpComputor();
        final Computor o = (Computor) Proxy.newProxyInstance(HpComputor.class.getClassLoader(), new Class[]{Computor.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                return method.invoke(hpComputor, args);
            }
        });

        o.compute();
    }
}