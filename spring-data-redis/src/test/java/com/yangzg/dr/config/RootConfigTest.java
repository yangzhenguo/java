package com.yangzg.dr.config;

import com.yangzg.dr.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Sam on 2019/12/14.
 */
public class RootConfigTest extends BaseTest {
    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Autowired
    @Qualifier("companyRedis")
    private JedisConnectionFactory companyJedisConnectionFactory;

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

    @Test
    public void testScan() throws Exception {
        final RedisConnection connection = this.jedisConnectionFactory.getConnection();
        try (Cursor<byte[]> scan = connection.scan(ScanOptions.scanOptions().match("*").count(2).build())) {
            System.out.println("aaa");
            scan.forEachRemaining(key -> System.out.println(new String(key)));
        }
        connection.close();
    }

    @Test
    public void testPropertiesConfig() throws Exception {
        final RedisConnection connection = this.companyJedisConnectionFactory.getConnection();

        final List<String> strings = connection.getConfig("*");
        final Map<String, String> config = IntStream.range(0, strings.size() / 2).boxed().collect(Collectors.toMap(i -> strings.get(i * 2), i -> strings.get(i * 2 + 1)));
        System.out.println(config);

        System.out.println(config.get("loglevel"));

        connection.multi();
        connection.discard();
        connection.exec();

        connection.close();
    }
}