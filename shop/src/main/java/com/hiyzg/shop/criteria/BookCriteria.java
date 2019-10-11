package com.hiyzg.shop.criteria;

import lombok.Data;

/**
 * Created by Sam on 2019/10/11.
 */
@Data
public class BookCriteria {
    private double minPrice = 0;
    private double maxPrice = Double.MAX_VALUE;
}
