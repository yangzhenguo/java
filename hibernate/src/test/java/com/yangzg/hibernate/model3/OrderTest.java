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
                customer.setOrders(new HashSet<Order>(){
                    private static final long serialVersionUID = -6351448378189528824L;
                    {
                        add(order1);
                        add(order2);
                    }
                });
                session.save(customer);
                session.save(order1);
                session.save(order2);
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
                final List<Customer> customers = session.createQuery("from Customer", Customer.class).list();
                System.out.println(customers);
                tx.commit();
            } catch (Exception e) {
                e.printStackTrace();
                tx.rollback();
            }
        }
    }

    @Test
    public void test3() {
        try (Session session = SESSION_FACTORY.openSession()) {
            final Transaction tx = session.beginTransaction();
            try {
                final Customer customer = session.load(Customer.class, 7);
                System.out.println(customer.getName());
                System.out.println(customer.getOrders());
                tx.commit();
            } catch (Exception e) {
                e.printStackTrace();
                tx.rollback();
            }
        }
    }

    @Test
    public void test4() {
        try (Session session = SESSION_FACTORY.openSession()) {
            final Transaction tx = session.beginTransaction();
            try {
                final Customer customer = session.load(Customer.class, 7);
                System.out.println(customer.getName());
                System.out.println(customer.getOrders());
                customer.getOrders().iterator().next().setName("改了噶");
                System.out.println(customer.getOrders());
                tx.commit();
            } catch (Exception e) {
                e.printStackTrace();
                tx.rollback();
            }
        }
    }
}