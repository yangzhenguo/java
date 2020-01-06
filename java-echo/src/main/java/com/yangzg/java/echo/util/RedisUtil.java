package com.yangzg.java.echo.util;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Sam on 2020/1/6.
 * @author Sam
 */
public class RedisUtil {
    public static final JedisPool JEDIS_POOL;

    static {
        final JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMaxTotal(18);
        JEDIS_POOL = new JedisPool(config, "0.0.0.0");
    }
}
