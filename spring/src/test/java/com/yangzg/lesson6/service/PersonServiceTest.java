package com.yangzg.lesson6.service;

import com.yangzg.lesson6.AppConfiguration;
import com.yangzg.lesson6.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Sam on 2020/3/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfiguration.class)
public class PersonServiceTest {
    @Autowired
    @Lazy
    private PersonService personService;

    @Autowired
    @Lazy
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Lazy
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    public void create() throws Exception {
        this.personService.create(IntStream.rangeClosed(-5, 5).boxed().map(n -> new Person(String.format("name-%s", n))).collect(Collectors.toList()));
    }

    @Test
    public void create1() throws Exception {
        this.personService.create(new Random().ints(10,-5, 5).boxed().map(n -> new Person(String.format("name-%s", n))).collect(Collectors.toList()));
    }

    @Test
    public void test1() throws Exception {
        this.jdbcTemplate.query("SELECT number FROM Phone", new SingleColumnRowMapper<String>()).forEach(System.out::println);
    }

    @Test
    public void test2() throws Exception {
        System.out.println(this.jdbcTemplate.queryForObject("select name from person WHERE id = ?", new BeanPropertyRowMapper<>(Person.class), 1));
    }

    @Test
    public void test3() throws Exception {
        System.out.println(this.jdbcTemplate.queryForObject("select count(*) count, sum(id) sum from person", new RowMapper<Map<String, Long>>() {
            @Nullable
            @Override
            public Map<String, Long> mapRow(ResultSet resultSet, int i) throws SQLException {
                return new HashMap<String, Long>(){{
                    put("count", resultSet.getLong("count"));
                    put("sum", resultSet.getLong("sum"));
                }};
            }
        }));

        System.out.println(this.jdbcTemplate.queryForObject("select count(*) count, sum(id) sum from person", new ColumnMapRowMapper()));
    }

    @Test
    public void test4() throws Exception {
        this.namedParameterJdbcTemplate.query(
                "SELECT * FROM Phone WHERE 1 = :num",
                new MapSqlParameterSource("num", 1),
                new ColumnMapRowMapper()
        ).forEach(System.out::println);
    }

    @Test
    public void creates() throws Exception {
        this.personService.creates(new Person(), new Person());
    }
}