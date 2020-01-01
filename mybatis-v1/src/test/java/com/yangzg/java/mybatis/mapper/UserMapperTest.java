package com.yangzg.java.mybatis.mapper;

import com.yangzg.java.mybatis.config.RootConfig;
import com.yangzg.java.mybatis.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

/**
 * Created by Sam on 2020/1/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class UserMapperTest {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void selectUser() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            final Optional<User> userOptional = userMapper.selectUser(1);
            userOptional.ifPresent(System.out::println);
        }
    }

    @Test
    public void listAll() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.listAll().forEach(System.out::println);
        }
    }

}