package com.yangzg.lesson6.service;

import com.yangzg.lesson6.dao.PersonDao;
import com.yangzg.lesson6.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sam on 2020/3/24.
 * @author Sam
 */
@Service
public class PersonService {
    @Autowired
    @Lazy
    private PersonDao personDao;

    @Transactional(rollbackFor = Exception.class)
    public void create(List<Person> peoples) {
        this.personDao.save(peoples);
    }

    public void creates(Person person1, Person person2) {
        this.personDao.save(person1);
        final int i = 1 / 0;
        this.personDao.save(person2);
    }
}
