package com.yangzg.hibernate.model1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.junit.Test;

import java.io.Serializable;
import java.util.Date;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Sam on 2019/10/24.
 */
public class NewsTest {
    private static final SessionFactory SESSION_FACTORY = new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).buildMetadata().buildSessionFactory();

    @Test
    public void test1() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            final SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            try (Session session = sessionFactory.openSession()) {
                session.save(new News("guide", "yangzg", "hello world", new Date()));
            }
            assertNotNull(sessionFactory);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @Test
    public void test2() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try (
                SessionFactory sessionFactory = new Configuration().buildSessionFactory(registry);
                Session session = sessionFactory.openSession()
        ) {

            final Transaction tx = session.beginTransaction();
            try {
                final News news = session.get(News.class, 1);
                System.out.println(news);
                tx.commit();
            } catch (Exception e) {
                e.printStackTrace();
                tx.rollback();
            }
            assertNotNull(sessionFactory);
        }
    }

    @Test
    public void test3() {
        final StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        try (SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                session.save(new News());
            }
        }
    }

    @Test
    public void test4() {
        try (
                SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).buildMetadata().buildSessionFactory();
                Session session = sessionFactory.openSession()
        ) {
            final NativeQuery sqlQuery = session.createSQLQuery("select 1");
            sqlQuery.list().stream().findFirst().ifPresent(System.out::println);
        }
    }

    @Test
    public void test5() {
        try (Session session = SESSION_FACTORY.openSession()) {
            final Transaction tx = session.beginTransaction();
            final News news = session.get(News.class, 1);
            System.out.println(new String(new char[50]).replaceAll("\0", "-"));
            System.out.println(news);
            news.setAuthor("yang");
            System.out.println(news);
            System.out.println(session.createQuery("from News ").list());
            System.out.println(news);
            tx.commit();
        }
    }

    @Test
    public void test6() {
        try (Session session = SESSION_FACTORY.openSession()) {
            final News news = new News();
            final Serializable id = session.save(news);
            System.out.println(news);
            System.out.println(id);
        }
    }

    @Test
    public void test7() {
        try (Session session = SESSION_FACTORY.openSession()) {
            final Transaction tx = session.beginTransaction();
            try {
                final News news = new News();
                news.setId(123);
                session.save(news);
                news.setId(312);
                tx.commit();
            } catch (Exception e) {
                e.printStackTrace();
                tx.rollback();
            }
        }
    }

    @Test
    public void test8() {
        try (Session session = SESSION_FACTORY.openSession()) {
            final Transaction tx = session.beginTransaction();
            try {
                final News news = session.load(News.class, 100);
                System.out.println("-----");
                System.out.println(news);
            } catch (Exception e) {
                e.printStackTrace();
                tx.rollback();
            }
        }
    }

    @Test
    public void test9() {
        try (Session session = SESSION_FACTORY.openSession()) {
            final Transaction tx = session.beginTransaction();
            try {
                final News news = session.load(News.class, 1);
                System.out.println(news);
                session.doWork(connection -> {
                    System.out.println(connection);
                });
            } catch (Exception e) {
                e.printStackTrace();
                tx.rollback();
            }
        }
    }
}