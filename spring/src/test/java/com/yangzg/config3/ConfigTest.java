package com.yangzg.config3;

import com.yangzg.model3.Person;
import com.yangzg.service3.JdbcService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

/**
 * Created by Sam on 2019/11/1.
 */
public class ConfigTest {
    @Test
    public void test1() {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
            final Properties url = applicationContext.getBean("properties", Properties.class);
            System.out.println(url);
        }
    }

    @Test
    public void test2() {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
            final JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
            System.out.println(jdbcTemplate);
            final Double random = jdbcTemplate.queryForObject("select RAND()", Double.class);
            System.out.println(random);

            final Timestamp timestamp = jdbcTemplate.queryForObject("SELECT CURRENT_TIMESTAMP()", Timestamp.class);
            System.out.println(timestamp.toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }
    }

    @Test
    public void test3() {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
            final JdbcService jdbcService = applicationContext.getBean(JdbcService.class);
            System.out.println(jdbcService.currentTime());
        }
    }

    @Test
    public void test4() {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
            final JdbcService jdbcService = applicationContext.getBean(JdbcService.class);
            System.out.println(jdbcService.getPersons());
        }
    }

    @Test
    public void test5() {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
            final JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
            final List<Person> personList = jdbcTemplate.query("select * from person", (resultSet, i) -> new Person(resultSet.getInt(1), resultSet.getString(2)));
            System.out.println(personList);
        }
    }

    @Test
    public void test6() {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
            final NamedParameterJdbcTemplate jdbcTemplate = applicationContext.getBean(NamedParameterJdbcTemplate.class);
            final List<Person> personList = jdbcTemplate.query("select * from person", (resultSet, i) -> new Person(resultSet.getInt(1), resultSet.getString(2)));
            System.out.println(personList);
        }
    }
}
