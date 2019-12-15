package com.yangzg.dr.config;

import com.yangzg.dr.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by Sam on 2019/12/15.
 */
public class ListTest extends BaseTest {
    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Value("#{ redisTemplate }")
    private RedisTemplate<String, Object> redisTemplate;

    @Value("#{ redisTemplate.opsForList() }")
    private ListOperations<String, String> listOperations;

    @Test
    public void testLPush() throws Exception {
        this.listOperations.leftPushAll("names", "yangzg", "yzg", "sam");
    }

    @Test
    public void testLRem() throws Exception {
        System.out.println(this.listOperations.remove("names", 8, "a"));
    }

    @Test
    public void testRPush() throws Exception {
        IntStream.rangeClosed(0, 100).forEach(num -> this.listOperations.rightPush("num", Integer.toString(num)));

        IntStream.generate(() -> new Random().nextInt(100)).limit(200).forEach(num -> this.listOperations.rightPush("nums", Integer.toString(num)));
    }
}
