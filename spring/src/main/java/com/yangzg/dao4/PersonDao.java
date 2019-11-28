package com.yangzg.dao4;

import com.yangzg.model4.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Sam on 2019/11/2.
 */
@Repository
public class PersonDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public void decreaseBalance(final String name, final double price) {
        this.getSession().createQuery("UPDATE Person SET balance = balance - :balance WHERE name = :name").setParameter("balance", price).setParameter("name", name).executeUpdate();
    }

    public Optional<Person> selectByName(final String name) {
        return this.getSession().createQuery("from Person p where p.name = :name", Person.class).setParameter("name", name).getResultStream().findFirst();
    }
}
