package com.yangzg.jpa.model;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by Sam on 2019/12/4.
 */
public class CustomerTest {
    @Test
    public void test1() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("MysqlPersistenceUnit");
            entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            final Customer customer = new Customer();
            customer.setName("yzg");
            customer.setBirthday(new Date());
            entityManager.persist(customer);
            transaction.begin();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
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
            final Customer customer = entityManager.find(Customer.class, 1);
            System.out.println(customer);
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
    public void test3() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("MysqlPersistenceUnit");
            entityManager = entityManagerFactory.createEntityManager();
            final Customer customer = entityManager.getReference(Customer.class, 1);
//            System.out.println(customer);
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
    public void test4() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("MysqlPersistenceUnit");
            entityManager = entityManagerFactory.createEntityManager();
            final Customer customer = new Customer();
            customer.setId(1);
            entityManager.remove(customer);
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