package com.hiyzg.shop.util;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by Sam on 2019/10/16.
 */
public class GsonTest {
    @Test
    public void test1() {
        final HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("count", 12);
        result.put("message", "quantity");
        System.out.println(new Gson().toJson(result));
    }
}
