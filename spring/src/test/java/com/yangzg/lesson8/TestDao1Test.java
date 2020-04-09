package com.yangzg.lesson8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;

/**
 * @author Sam
 * @date 2020/4/6 5:43 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestDao1Test {
    @Autowired @Lazy private TestDao1 testDao1;

    @Test
    public void test1() throws Exception {
        System.out.println(this.testDao1.test1(Arrays.asList("1", "2", "3")));
    }

    @Test
    public void test2() throws Exception {
        System.out.println(this.testDao1.test2());
    }

    @Test
    public void test3() throws Exception {
        System.out.println(this.testDao1.test3());
    }

    @Test
    public void test4() throws Exception {
        System.out.println(this.testDao1.test4());
    }

    @Test
    public void test5() throws Exception {
        System.out.println(this.testDao1.test5());
    }

    @Test
    public void test6() throws Exception {
        final LocalTime localTime = this.testDao1.test6();
        final ZonedDateTime zonedDateTime = localTime.atDate(LocalDate.now()).atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);
    }

    @Test
    public void test7() throws Exception {
        System.out.println(this.testDao1.test7());
    }

    @Test
    public void test8() throws Exception {
        System.out.println(this.testDao1.test8("中国"));
    }

    @Test
    public void test9() throws Exception {
        this.testDao1.test9().forEach(System.out::println);
    }
}