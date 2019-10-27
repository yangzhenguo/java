package com.yangzg.hibernate.model1;

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
                final Wife lily = new Wife("lily");
                final Husband tom = new Husband("tom", lily);
                lily.setHusband(tom);
                session.save(lily);
                session.save(tom);
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
                final Husband husband = session.load(Husband.class, 1);
//                System.out.println(husband.getName());
                System.out.println(husband.getWife().getName());
            } catch (Exception e) {
                e.printStackTrace();
                tx.rollback();
            }
        }
    }
}