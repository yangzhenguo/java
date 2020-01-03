package com.yangzg.java.mybatis;

import com.yangzg.java.mybatis.config.RootConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Sam on 2020/1/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public abstract class BaseTest {
}
