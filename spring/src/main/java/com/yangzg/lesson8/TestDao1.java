package com.yangzg.lesson8;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Sam
 * @date 2020/4/6 5:38 PM
 */
@Repository
public class TestDao1 {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public TestDao1(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = namedParameterJdbcTemplate.getJdbcTemplate();
    }

    public String test1(List<String> args) {
        return this.namedParameterJdbcTemplate.queryForObject("SELECT concat(:strs)", new MapSqlParameterSource("strs", args), String.class);
    }

    public Instant test2() {
        return this.jdbcTemplate.queryForObject("SELECT CURRENT_TIMESTAMP()", Instant.class);
    }

    public LocalDateTime test3() {
        return this.jdbcTemplate.queryForObject("SELECT now()", LocalDateTime.class);
    }

    public List<Double> test4() {
        return this.jdbcTemplate.queryForList("SELECT rand() FROM person", Double.class);
    }

    public LocalDate test5() {
        return this.jdbcTemplate.queryForObject("SELECT CURRENT_DATE()", LocalDate.class);
    }

    public LocalTime test6() {
        return this.jdbcTemplate.queryForObject("SELECT CURRENT_TIME()", LocalTime.class);
    }

    public List<Map<String, Object>> test7() {
        return this.jdbcTemplate.queryForList("show variables like '%char%'");
    }

    public int test8(String str) {
        return this.jdbcTemplate.queryForObject("SELECT LENGTH(?)", int.class, str);
    }

    public List<Map<String, Object>> test9() {
        return this.jdbcTemplate.queryForList("show full processlist");
    }

    public static void main(String[] args) {
        try (final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            final TestDao1 testDao1 = applicationContext.getBean(TestDao1.class);
            IntStream.rangeClosed(1, 10).forEach(n -> {
                try {
                    final List<Map<String, Object>> maps = testDao1.test9();
                    System.out.println(maps.size());
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
