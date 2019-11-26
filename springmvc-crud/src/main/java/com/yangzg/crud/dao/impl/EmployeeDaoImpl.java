package com.yangzg.crud.dao.impl;

import com.yangzg.crud.dao.EmployeeDao;
import com.yangzg.crud.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Sam on 2019/11/24.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Optional<Employee> selectByUid(final String uid) {
        final List<Employee> employees = this.namedParameterJdbcTemplate.query(String.format("select * from %s where uid = :uid", "employee"), new MapSqlParameterSource("uid", uid), new BeanPropertyRowMapper<>(Employee.class));
        return employees.isEmpty() ? Optional.empty() : Optional.ofNullable(employees.get(0));
    }

    @Override
    public List<Employee> selectAll() {
        return this.namedParameterJdbcTemplate.query(String.format("select * from %s", "employee"), new EmptySqlParameterSource(), new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    @Override
    public void insert(Employee employee) {
        this.namedParameterJdbcTemplate.update(String.format("insert into %s (uid, username, name, email, telephone, sex, state) values(:uid, :username, :name, :email, :telephone, :sex, :state)", "employee"), new BeanPropertySqlParameterSource(employee));
    }

    @Override
    public void deleteByUid(String uid) {
        this.namedParameterJdbcTemplate.update(String.format("delete from %s where uid = :uid", "employee"), new MapSqlParameterSource("uid", uid));
    }

    @Override
    public void update(Employee employee) {
        this.namedParameterJdbcTemplate.update(String.format("update %s set uid = :uid, username = :username, name = :name, email = :email, telephone = :telephone, sex = :sex, state = :state where uid = :uid", "employee"), new BeanPropertySqlParameterSource(employee));
    }
}
