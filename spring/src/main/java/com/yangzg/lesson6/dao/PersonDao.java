package com.yangzg.lesson6.dao;

import com.yangzg.lesson6.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Sam on 2020/3/24.
 */
@Repository
public class PersonDao {
    @Autowired
    @Lazy
    private JdbcTemplate jdbcTemplate;

    public long save(final Person person) {
        final GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        final int updatedCount = this.jdbcTemplate.update(connection -> {
            final PreparedStatement ps = connection.prepareStatement("INSERT INTO Person(name) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, person.getName());
            return ps;
        }, keyHolder);
        return updatedCount > 0 ? Optional.ofNullable(keyHolder.getKey()).map(Number::longValue).orElse(-1L) : -1;
    }

    public void save(List<Person> peoples) {
        this.jdbcTemplate.batchUpdate("INSERT INTO Person(name) VALUES(?)", peoples.stream().map(p -> new Object[]{p.getName()}).collect(Collectors.toList()));
    }
}
