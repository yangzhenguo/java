package com.yangzg.hibernate.model3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Sam on 2019/10/24.
 */
public class OrderTest {
    private static final SessionFactory SESSION_FACTORY = new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).buildMetadata().buildSessionFactory();

    @Test
    public void test1() {
        try (Session session = SESSION_FACTORY.openSession()) {
            final Transaction tx = session.beginTransaction();
            try {
                final Order order1 = new Order("一袋子苹果");
                final Order order2 = new Order("一箱啤酒");
                final Customer customer = new Customer("yang");
                customer.setOrders(new HashSet<>());
                session.save(customer);
                tx.commit();
            } catch (Exception e) {
                e.printStackTrace();
                tx.rollback();
            }
        }
    }

    @Test
    public void test2() {
        try (Session session = SESSION_FACTORY.openSession()) {
            final Transaction tx = session.beginTransaction();
            try {
                final List<Order> orders = session.createQuery("from Order", Order.class).list();
                System.out.println(orders);
                tx.commit();
            } catch (Exception e) {
                e.printStackTrace();
                tx.rollback();
            }
        }
    }
}