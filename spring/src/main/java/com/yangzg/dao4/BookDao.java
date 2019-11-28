package com.yangzg.dao4;

import com.yangzg.model4.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Sam on 2019/11/2.
 */
@Repository
public class BookDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public void decreaseStock(final String name) {
        this.getSession().createQuery("UPDATE Book SET amount = amount - 1 WHERE name = :name").setParameter("name", name).executeUpdate();
    }

    public int selectAmountByName(final String name) {
        return this.getSession().createQuery("SELECT b.amount FROM Book b WHERE b.name = :name", Integer.class).setParameter("name", name).uniqueResult();
    }

    public Optional<Book> selectByName(final String name) {
        return this.getSession().createQuery("from Book b WHERE b.name = :name", Book.class).setParameter("name", name).getResultStream().findFirst();
    }
}
