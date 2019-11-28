package com.yangzg.spring.chapter04;

import com.yangzg.spring.chapter03.SystemConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Sam on 2019/6/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@ActiveProfiles("dev")
public class ApplicationTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test1() {
        System.out.println(this.applicationContext);
        assertNotNull(this.applicationContext);

        Arrays.stream(this.applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
    }
}