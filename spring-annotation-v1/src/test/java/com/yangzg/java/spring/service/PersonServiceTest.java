package com.yangzg.java.spring.service;

import com.yangzg.java.spring.config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Sam on 2020/1/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@TestPropertySource("classpath:app.properties")
public class PersonServiceTest {
    @Value("${os.name}")
    private String os;

    @Value("${os}")
    private String oss;

    @Value("${home}")
    private String home;

    @Autowired
    private PersonService personService;

    @Test
    public void getOnePerson() throws Exception {
        this.personService.getOnePerson().ifPresent(System.out::println);
        System.out.println(this.os);
    }

    @Test
    public void testOs() throws Exception {
        System.out.println(oss);
        System.out.println(this.home);
    }
}