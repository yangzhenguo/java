package com.yangzg.service3;

import com.yangzg.model3.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Sam on 2019/11/1.
 */
@Service
public class JdbcService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public LocalDateTime currentTime() {
        final Timestamp timestamp = jdbcTemplate.queryForObject("SELECT CURRENT_TIMESTAMP()", Timestamp.class);
        return timestamp.toLocalDateTime();
    }

    public List<Person> getPersons() {
        final BeanPropertyRowMapper<Person> rowMapper = BeanPropertyRowMapper.newInstance(Person.class);
        final List<Person> personList = jdbcTemplate.query("SELECT * FROM person", rowMapper);
        return personList;
    }
}
