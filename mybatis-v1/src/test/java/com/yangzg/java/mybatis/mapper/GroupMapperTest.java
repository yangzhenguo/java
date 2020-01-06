package com.yangzg.java.mybatis.mapper;

import com.yangzg.java.mybatis.config.RootConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Sam on 2020/1/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class GroupMapperTest {
    @Autowired
    private SqlSessionFactory sessionFactory;

    @Test
    public void selectGroupById() throws Exception {
        try (SqlSession sqlSession = this.sessionFactory.openSession()) {
            final GroupMapper groupMapper = sqlSession.getMapper(GroupMapper.class);
            groupMapper.selectGroupById(1).ifPresent(System.out::println);
        }
    }

    @Test
    public void selectGroupById2() throws Exception {
        try (SqlSession sqlSession = this.sessionFactory.openSession()) {
            final GroupMapper groupMapper = sqlSession.getMapper(GroupMapper.class);
            groupMapper.selectGroupById(0).ifPresent(System.out::println);
        }
    }
}