package com.hiyzg.shop.criteria;

import lombok.Data;

/**
 * Created by Sam on 2019/10/11.
 */
@Data
public class BookCriteria {
    private double minPrice = 0;
    private double maxPrice = Double.MAX_VALUE;

    private int page;

    private int size = 5;

    public BookCriteria(int page) {
        this.page = page;
    }

    public BookCriteria(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public int getPage() {
        return Math.max(1, page);
    }
}
