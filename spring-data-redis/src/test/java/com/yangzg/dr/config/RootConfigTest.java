package com.yangzg.dr.config;

import com.yangzg.dr.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Sam on 2019/12/14.
 */
public class RootConfigTest extends BaseTest {
    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Value("#{ redisTemplate.opsForList() }")
    private ListOperations<String, String> listOperations;

    @Test
    public void jedisConnectionFactory() throws Exception {
        System.out.println(this.jedisConnectionFactory);
    }

    @Test
    public void redisTemplate() throws Exception {
        assertNotNull(redisTemplate);
    }

    @Test
    public void test1() throws Exception {
        this.redisTemplate.hasKey("names");
        this.listOperations.range("names", 0, -1).forEach(System.out::println);
    }
}