package com.yangzg.lesson3;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Sam on 2020/3/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/lesson3/applicationContext.xml")
public class EmployeeTest {
    @Autowired
    @Lazy
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Lazy
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    @Lazy
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    @Lazy
    private SimpleJdbcCall simpleJdbcCall;

    @Autowired
    @Lazy
    private EmployeeService employeeService;

    @Test
    public void test1() throws Exception {
        System.out.println(this.jdbcTemplate);
        System.out.println(this.namedParameterJdbcTemplate);
        System.out.println(this.simpleJdbcInsert);
        System.out.println(this.simpleJdbcCall);
    }

    @Test
    public void test2() throws Exception {
        final List<Employee> employees = this.namedParameterJdbcTemplate.query("SELECT * FROM employee WHERE state = :state", new MapSqlParameterSource("state", 1), new ResultSetExtractor<List<Employee>>() {
            @Override
            public List<Employee> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                final ArrayList<Employee> employees = new ArrayList<>();
                while (resultSet.next()) {
                    final Employee employee = new Employee();
                    employee.setUid(resultSet.getString("uid"));
                    employee.setUsername(resultSet.getString("username"));
                    employee.setPassword(resultSet.getString("password"));
                    employee.setName(resultSet.getString("name"));
                    employee.setEmail(resultSet.getString("email"));
                    employee.setTelephone(resultSet.getString("telephone"));
                    employee.setBirthday(resultSet.getDate("birthday"));
                    employee.setSex(resultSet.getInt("sex"));
                    employee.setState(resultSet.getInt("state"));
                    employee.setCode(resultSet.getString("code"));
                    employees.add(employee);
                }
                return employees;
            }
        });

        employees.forEach(System.out::println);
    }

    @Test
    public void test3() throws Exception {
        final List<Employee> employees = this.namedParameterJdbcTemplate.query("SELECT * FROM employee WHERE state=:state", new MapSqlParameterSource("state", 1), new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                final Employee employee = new Employee();
                employee.setUid(resultSet.getString("uid"));
                employee.setUsername(resultSet.getString("username"));
                employee.setPassword(resultSet.getString("password"));
                employee.setName(resultSet.getString("name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setTelephone(resultSet.getString("telephone"));
                employee.setBirthday(resultSet.getDate("birthday"));
                employee.setSex(resultSet.getInt("sex"));
                employee.setState(resultSet.getInt("state"));
                employee.setCode(resultSet.getString("code"));
                return employee;
            }
        });

        employees.forEach(System.out::println);
    }

    @Test
    public void test4() throws Exception {
        final ArrayList<Employee> employees = Lists.newArrayList();
        this.namedParameterJdbcTemplate.query("SELECT * FROM employee WHERE state=:state", ImmutableMap.of("state", 1), new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                final Employee employee = new Employee();
                employee.setUid(resultSet.getString("uid"));
                employee.setUsername(resultSet.getString("username"));
                employee.setPassword(resultSet.getString("password"));
                employee.setName(resultSet.getString("name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setTelephone(resultSet.getString("telephone"));
                employee.setBirthday(resultSet.getDate("birthday"));
                employee.setSex(resultSet.getInt("sex"));
                employee.setState(resultSet.getInt("state"));
                employee.setCode(resultSet.getString("code"));
                employees.add(employee);
            }
        });

        employees.forEach(System.out::println);
    }

    @Test
    public void test5() throws Exception {
        final String uid = this.namedParameterJdbcTemplate.queryForObject("SELECT uid FROM employee WHERE state=:state limit 1", ImmutableMap.of("state", 1), new SingleColumnRowMapper<String>());

        System.out.println(uid);
    }

    @Test
    public void test6() throws Exception {
        final List<String> employees = this.namedParameterJdbcTemplate.queryForList("SELECT uid FROM employee", new MapSqlParameterSource("state", 1), String.class);
        employees.forEach(System.out::println);
    }

    @Test
    public void test7() throws Exception {
        final List<Map<String, Object>> maps = this.namedParameterJdbcTemplate.queryForList("SELECT * FROM employee", ImmutableMap.of("state", 1));

        maps.forEach(System.out::println);
    }

    @Test
    public void test8() throws Exception {
        final Map<String, Object> map = this.namedParameterJdbcTemplate.queryForMap("SELECT * FROM employee WHERE state=:state limit 1", ImmutableMap.of("state", 1));

        System.out.println(map);

        final List<String> strings = this.namedParameterJdbcTemplate.query("select uid from employee", new SingleColumnRowMapper<String>());
        System.out.println(strings);
    }

    @Test
    public void test9() throws Exception {
        final Employee employee = this.employeeService.get(123);
        System.out.println(employee);
    }
}