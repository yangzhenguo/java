package com.hiyzg.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by Sam on 2019/10/11.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private long id;
    private String title;
    private String author;
    private double price;
    private Date publishingDate;
    private int salesAmount;
    private int storeNumber;
    private String remark;

    public Book(long id, String title) {
        this.id = id;
        this.title = title;
    }
}
