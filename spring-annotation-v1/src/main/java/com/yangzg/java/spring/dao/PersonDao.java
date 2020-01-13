package com.yangzg.java.spring.dao;

import com.yangzg.java.spring.model.Person;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Sam on 2020/1/13.
 * @author Sam
 */
@Repository
public class PersonDao {
    public Optional<Person> getOne() {
        return Optional.of(new Person());
    }
}
