package com.yangzg.java.mybatis.mapper;

import com.yangzg.java.mybatis.BaseTest;
import com.yangzg.java.mybatis.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Sam on 2020/1/1.
 */
public class UserMapperTest extends BaseTest {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testSelectUser() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            final Optional<User> userOptional = userMapper.selectUser(1);
            userOptional.ifPresent(System.out::println);
        }
    }

    @Test
    public void testListAll() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.listAll().forEach(System.out::println);
        }
    }

    @Test
    public void testInsert() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true)) {
            final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            final User yyy = new User("yyy");
            assertTrue(userMapper.insert(yyy));
        }
    }

    @Test
    public void testDelete() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true)) {
            final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            assertTrue("没有此记录，删除失败", userMapper.delete(8));
        }
    }

    @Test
    public void testUpdate() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession(true)) {
            final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            assertTrue(userMapper.update(new User(7, "zzz")));
        }
    }
}