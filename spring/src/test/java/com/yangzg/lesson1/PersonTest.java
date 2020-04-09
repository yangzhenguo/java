package com.yangzg.lesson1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Properties;

/**
 * Created by Sam on 2020/3/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "/lesson1/applicationContext.xml"
})
public class PersonTest {
    @Autowired
    @Lazy
    private Person person;

    @Test
    public void test1() throws Exception {
        System.out.println(this.person);
    }

    @Test
    public void test2() throws Exception {
        final Properties props = new Properties();
        props.put(123, 234);
        System.out.println(props);

        props.put(this.person, this.person);
        System.out.println(props);
    }
}