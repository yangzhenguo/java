package com.yangzg.hibernate.model8;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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
                final Teacher teacher1 = new Teacher("teacher1");
                final Teacher teacher2 = new Teacher("teacher2");
                final Set<Teacher> teachers = new HashSet<Teacher>(){
                    private static final long serialVersionUID = -4384973058251680613L;
                    {
                        add(teacher1);
                        add(teacher2);
                    }
                };
                final Student student = new Student("yangzg", teachers);
                session.save(teacher1);
                session.save(teacher2);
                session.save(student);
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
                final Student student = session.createQuery("from Student where name = :name", Student.class).setParameter("name", "yangzg").uniqueResult();
                System.out.println(student.getName());
                System.out.println(student.getTeachers());
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
                session.createQuery("from Student where name = :name", Student.class).setParameter("name", "yangzg").uniqueResultOptional().ifPresent(student -> {
                    student.getTeachers().iterator().next().setName("老 师");
                });
                tx.commit();
            } catch (Exception e) {
                e.printStackTrace();
                tx.rollback();
            }
        }
    }
}