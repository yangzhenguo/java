package com.yangzg.lesson2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * Created by Sam on 2020/3/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/lesson2/applicationContext.xml")
public class PersonTest {
    @Autowired
    private Map<String, Object> map;

    @Test
    public void test1() throws Exception {
        this.map.keySet().forEach(m -> System.out.println(String.format("%s\t%s", m, this.map.get(m))));
    }

    @Test
    public void test2() throws Exception {
        System.getenv().keySet().forEach(k -> System.out.println(String.format("%s\t%s", k, System.getenv(k))));
    }
}