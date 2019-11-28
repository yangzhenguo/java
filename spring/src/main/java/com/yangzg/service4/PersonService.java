package com.yangzg.service4;

import com.yangzg.dao4.PersonDao;
import com.yangzg.model4.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Sam on 2019/11/2.
 */
@Service
public class PersonService {
    @Autowired
    private PersonDao personDao;

    public void decreaseBalance(final String name, final double price) {
        this.personDao.decreaseBalance(name, price);
    }

    public Optional<Person> selectByName(final String name) {
        return this.personDao.selectByName(name);
    }
}
