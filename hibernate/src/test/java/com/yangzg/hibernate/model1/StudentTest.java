package com.yangzg.hibernate.model1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

import java.util.HashSet;

/**
 * Created by Sam on 2019/10/24.
 */
public class StudentTest {
    private static final SessionFactory SESSION_FACTORY = new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).buildMetadata().buildSessionFactory();

    @Test
    public void test1() {
        try (Session session = SESSION_FACTORY.openSession()) {
            final Transaction tx = session.beginTransaction();
            try {
                final Student student1 = new Student("yzg", 23);
                final Student student2 = new Student("yangzg", 24);
                final Classroom classroom = new Classroom("英语", new HashSet<Student>(){
                    private static final long serialVersionUID = 3656619719883935221L;
                    {
                        add(student1);
                        add(student2);
                    }
                });
                session.save(classroom);
                session.save(student1);
                session.save(student2);
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
                final Order order = session.load(Order.class, 1);
                System.out.println(order.getName());
                System.out.println(order.getCustomer().getName());
                tx.commit();
            } catch (Exception e) {
                e.printStackTrace();
                tx.rollback();
            }
        }
    }
}