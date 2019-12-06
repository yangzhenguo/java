package com.yangzg.jpa.config;

import com.yangzg.jpa.model.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Arrays;

/**
 * Created by Sam on 2019/12/6.
 */
public class BasicConfigTest {
    private AnnotationConfigApplicationContext applicationContext;
    private EntityManagerFactory entityManagerFactory;

    @Before
    public void setUp() throws Exception {
        this.applicationContext = new AnnotationConfigApplicationContext(BasicConfig.class);
        entityManagerFactory = applicationContext.getBean(EntityManagerFactory.class);
    }

    @Test
    public void test1() throws Exception {
        System.out.println(Arrays.toString(this.applicationContext.getBeanDefinitionNames()));
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final TypedQuery<Customer> query = entityManager.createQuery("from Customer", Customer.class);
        query.getResultList().forEach(System.out::println);
        entityManager.close();
    }

    @Test
    public void test2() throws Exception {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            final TypedQuery<Long> query = entityManager.createNamedQuery("countCustomerWithCriteria", Long.class).setParameter("id", 1);
            System.out.println(query.getSingleResult());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @After
    public void tearDown() throws Exception {
        entityManagerFactory.close();
        this.applicationContext.close();
    }
}