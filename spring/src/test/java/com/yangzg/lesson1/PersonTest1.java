package com.yangzg.lesson1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Sam on 2020/3/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/lesson1/applicationContext1.xml")
public class PersonTest1 {
    @Autowired
    private Person person;

    @Test
    public void test1() throws Exception {
        System.out.println(this.person);
    }
}