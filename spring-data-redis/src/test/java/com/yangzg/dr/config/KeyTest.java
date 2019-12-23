package com.yangzg.dr.config;

import com.yangzg.dr.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.DigestUtils;

import java.nio.ByteBuffer;
import java.util.stream.IntStream;

/**
 * Created by Sam on 2019/12/18.
 */
public class KeyTest extends BaseTest {
    @Value("#{ redisTemplate.opsForValue() }")
    private ValueOperations<String, String> valueOperations;

    @Test
    public void batchInsert() throws Exception {
        IntStream.rangeClosed(1550000000, 1559999999).parallel().forEach(num -> {
            final ByteBuffer buffer = ByteBuffer.allocate(4);
            buffer.putInt(num);
            buffer.flip();
            final String key = DigestUtils.md5DigestAsHex(buffer.array());
            this.valueOperations.set(key, Integer.toString(num));
            buffer.clear();
        });
    }
}
