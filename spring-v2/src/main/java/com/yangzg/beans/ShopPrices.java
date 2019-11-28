package com.yangzg.beans;

import lombok.Data;

import java.util.Map;

/**
 * Created by Sam on 2019/11/14.
 */
@Data
public class ShopPrices {
    private Map<String, Double> prices;

    public ShopPrices() {
        System.out.println("init");
    }

    public ShopPrices(Map<String, Double> prices) {
        this.prices = prices;
    }

    public void destroy() {
        System.out.println("shop prices bean destroyed");
    }
}
