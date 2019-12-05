package com.yangzg.jpa.model;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by Sam on 2019/12/5.
 */
public class OrderTest {
    @Test
    public void test1() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("MysqlPersistenceUnit");
            entityManager = entityManagerFactory.createEntityManager();

            transaction = entityManager.getTransaction();
            transaction.begin();

            final Order order1 = new Order();
            final Order order2 = new Order();
            final Customer customer = new Customer();

            order1.setCustomer(customer);
            order2.setCustomer(customer);

            entityManager.persist(customer);
            entityManager.persist(order1);
            entityManager.persist(order2);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Test
    public void test2() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("MysqlPersistenceUnit");
            entityManager = entityManagerFactory.createEntityManager();

            final Order order = entityManager.find(Order.class, 1);
            System.out.println(order);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
}