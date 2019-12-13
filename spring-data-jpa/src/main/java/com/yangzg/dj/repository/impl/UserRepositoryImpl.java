package com.yangzg.dj.repository.impl;

import com.yangzg.dj.model.User;
import com.yangzg.dj.repository.inf.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

/**
 * Created by Sam on 2019/12/13.
 */
public class UserRepositoryImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> selectOne() {
        return Optional.ofNullable(this.entityManager.createQuery("from User", User.class).setFirstResult(0).setMaxResults(1).getSingleResult());
    }
}
