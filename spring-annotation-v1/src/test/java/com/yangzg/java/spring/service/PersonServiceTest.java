package com.yangzg.java.spring.service;

import com.yangzg.java.spring.config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private List<Object> list;

    @Test
    public void getOnePerson() throws Exception {
        this.personService.getOnePerson().ifPresent(System.out::println);
        System.out.println(this.os);
    }

    @Test
    public void testOs() throws Exception {
        System.out.println(oss);
        System.out.println(this.home);
        System.out.println(String.join("\n", this.list.stream().map(Object::toString).collect(Collectors.toList())));
    }
}