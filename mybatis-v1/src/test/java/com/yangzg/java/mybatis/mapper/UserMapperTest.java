package com.yangzg.java.mybatis.mapper;

import com.yangzg.java.mybatis.BaseTest;
import com.yangzg.java.mybatis.model.User;
import com.yangzg.java.mybatis.to.UserCondition;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

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
            final Optional<User> userOptional = userMapper.selectUserById(1);
            userOptional.ifPresent(System.out::println);
        }
    }

    @Test
    public void testSelectUser2() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            final Optional<User> userOptional = userMapper.selectUser("USER", new User("yzg"));
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

    @Test
    public void testSelectUserByIdAndUsername() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.selectUserByIdAndUsername(1, "yangzg").ifPresent(System.out::println);
        }
    }

    @Test
    public void testObj() throws Exception {
        final Integer integer = new Integer(2);
        System.out.println(integer.getClass().getMethods()[0].getDeclaringClass());
    }

    @Test
    public void testSelectUserByCondition() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.selectUserByCondition(new UserCondition("yzg")).ifPresent(System.out::println);
        }
    }

    @Test
    public void testSelectMapById() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.selectMapById(1).ifPresent(System.out::println);
        }
    }

    @Test
    public void testSelectAllListOfMap() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.selectAllListOfMap().forEach(System.out::println);
        }
    }

    @Test
    public void testSelectAllMap() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.selectAllMap().forEach((key, value) -> System.out.println(String.format("key=%s, value=%s", key, value)));
        }
    }

    @Test
    public void testSelectUserWithGroupById() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.selectUserWithGroupById(1).ifPresent(System.out::println);
        }
    }

    @Test
    public void testSelectAllUserWithGroup() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.selectAllUserWithGroup().forEach(System.out::println);
        }
    }

    @Test
    public void testSelectAllUserLazy() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//            userMapper.selectAllUserLazy().forEach(System.out::println);
            final User user = userMapper.selectAllUserLazy().get(0);
            System.out.println(user.getUsername());
            System.out.println(user.getGroup());
        }
    }
}