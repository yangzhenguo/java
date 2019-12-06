package com.yangzg.jpa.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;

/**
 * Created by Sam on 2019/12/5.
 */
public class OrderTest {
    EntityManagerFactory entityManagerFactory = null;
    EntityManager entityManager = null;
    EntityTransaction transaction = null;

    @Before
    public void setUp() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("MysqlPersistenceUnit");
        entityManager = entityManagerFactory.createEntityManager();

        transaction = entityManager.getTransaction();
        transaction.begin();
    }

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

    @Test
    public void test3() throws Exception {
        final TypedQuery<Order> query = entityManager.createQuery("from Order o left join fetch o.customer", Order.class);
        query.getResultList().forEach(System.out::println);
    }

    @Test
    public void test4() throws Exception {
        final TypedQuery<Customer> query = entityManager.createQuery("from Customer", Customer.class);
        query.getResultList().forEach(customer -> {
            System.out.println(customer);
            System.out.println(customer.getOrders());
        });
    }

    @Test
    public void test5() throws Exception {
        final TypedQuery<Customer> query = entityManager.createQuery("from Customer c left outer join fetch c.orders", Customer.class);
        final Customer customer = query.getSingleResult();
        System.out.println(customer);
        System.out.println(customer.getOrders());
    }

    @Test
    public void test6() throws Exception {
        final TypedQuery<Order> query = entityManager.createNamedQuery("selectAllOrder", Order.class);
        System.out.println(query.getHints());
        query.getResultList().forEach(System.out::println);
    }

    @After
    public void tearDown() throws Exception {
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}