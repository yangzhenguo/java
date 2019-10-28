package com.yangzg.hibernate.model6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

/**
 * Created by Sam on 2019/10/24.
 */
public class HusbandTest {
    private static final SessionFactory SESSION_FACTORY = new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).buildMetadata().buildSessionFactory();

    @Test
    public void test1() {
        try (Session session = SESSION_FACTORY.openSession()) {
            final Transaction tx = session.beginTransaction();
            try {
                final Wife wife = new Wife("lily");
                final Husband husband = new Husband("tom", wife);
                wife.setHusband(husband);
                session.save(wife);
                session.save(husband);
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
                final Husband husband = session.load(Husband.class, 68);
                System.out.println(husband.getName());
                System.out.println(husband.getWife().getName());
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
                final Wife wife = session.load(Wife.class, 67);
                System.out.println(wife.getName());
                System.out.println(wife.getHusband().getName());
                tx.commit();
            } catch (Exception e) {
                e.printStackTrace();
                tx.rollback();
            }
        }
    }
}