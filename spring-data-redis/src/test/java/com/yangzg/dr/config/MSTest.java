package com.yangzg.dr.config;

import com.yangzg.dr.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Created by Sam on 2019/12/18.
 */
public class MSTest extends BaseTest {
    @Value("#{ redisTemplate.opsForValue() }")
    private ValueOperations<String, String> valueOperations;

    @Test
    public void test1() throws Exception {
        this.valueOperations.set("name", "yzg");
    }
}
