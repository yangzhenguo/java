package com.yangzg.dr.config;

import com.yangzg.dr.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.stream.IntStream;

/**
 * Created by Sam on 2019/12/15.
 */
public class StringTest extends BaseTest {
    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Value("#{ redisTemplate }")
    private RedisTemplate<String, Object> redisTemplate;

    @Value("#{ redisTemplate.opsForValue() }")
    private ValueOperations<String, String> valueOperations;

    @Test
    public void testSet() throws Exception {
        this.valueOperations.set("string", "abcde");
    }

    @Test
    public void testKeys() throws Exception {
        final RedisConnection connection = this.jedisConnectionFactory.getConnection();

        IntStream.range(0, Integer.parseInt(connection.getConfig("databases").get(1))).forEach(dbIndex -> {
            connection.select(dbIndex);
            final String line = new String(new char[20]).replaceAll("\0", "-");
            System.out.format("%s %-2d %s\n", line, dbIndex, line);
            connection.keys("*".getBytes()).forEach(key -> System.out.println(new String(key)));

        });

        connection.close();
    }

    @Test
    public void testDbsize() throws Exception {
        final RedisConnection connection = this.jedisConnectionFactory.getConnection();
        System.out.println(connection.dbSize());

        connection.select(1);
        System.out.println(connection.dbSize());

        connection.close();
    }
}
