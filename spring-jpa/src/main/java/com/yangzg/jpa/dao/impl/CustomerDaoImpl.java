package com.yangzg.jpa.dao.impl;

import com.yangzg.jpa.dao.CustomerDao;
import com.yangzg.jpa.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

/**
 * Created by Sam on 2019/12/6.
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Customer> first() {
        return this.entityManager.createQuery("from Customer", Customer.class).setMaxResults(1).getResultList().stream().findFirst();
    }

    @Override
    public void insert(Customer customer) {
        this.entityManager.persist(customer);
    }
}
