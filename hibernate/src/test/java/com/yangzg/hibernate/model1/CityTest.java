package com.yangzg.hibernate.model1;

import com.yangzg.hibernate.model1.embeddable.GPS;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

/**
 * Created by Sam on 2019/10/24.
 */
public class CityTest {
    private static final SessionFactory SESSION_FACTORY = new MetadataSources(new StandardServiceRegistryBuilder().configure().build()).buildMetadata().buildSessionFactory();

    @Test
    public void test1() {
        try (Session session = SESSION_FACTORY.openSession()) {
            final Transaction tx = session.beginTransaction();
            try {
                final GPS coordinates = new GPS(1, 2);
                final City beijing = new City("beijing", coordinates);
                session.save(beijing);
                System.out.println(beijing);
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
                final City city = session.load(City.class, 1L);
                final City city1 = city.getCoordinates().getCity();
                System.out.println(city == city1);
            } catch (Exception e) {
                e.printStackTrace();
                tx.rollback();
            }
        }
    }
}