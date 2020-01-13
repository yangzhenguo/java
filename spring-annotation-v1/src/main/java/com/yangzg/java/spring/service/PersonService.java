package com.yangzg.java.spring.service;

import com.yangzg.java.spring.dao.PersonDao;
import com.yangzg.java.spring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Sam on 2020/1/13.
 * @author Sam
 */
@Service
public class PersonService {
    private PersonDao personDao;

    public PersonService() {
    }

//    @Autowired
    public PersonService(@Qualifier("personDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    Optional<Person> getOnePerson() {
        return this.personDao.getOne();
    }

    @Autowired
    public void autowire(PersonDao personDao) {
        this.personDao = personDao;
    }
}
