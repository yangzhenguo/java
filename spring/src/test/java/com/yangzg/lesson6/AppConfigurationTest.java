package com.yangzg.lesson6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.Collectors;

/**
 * Created by Sam on 2020/3/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfiguration.class)
public class AppConfigurationTest {
    @Autowired
    @Lazy
    private JdbcTemplate jdbcTemplate;

    @Test
    public void dataSource() throws Exception {
    }

    @Test
    public void jdbcTemplate() throws Exception {
        System.out.println(this.jdbcTemplate);
        this.jdbcTemplate.query("SELECT * FROM Phone WHERE 1=?", new Object[]{1}, new ColumnMapRowMapper()).stream().map(a -> {
            a.put("personId", a.remove("person_id"));
            return a;
        }).collect(Collectors.groupingBy(m -> m.get("number"))).forEach((k, v) -> {
            System.out.println(String.format("%s, %s", k, v));
        });
    }

}