package com.yangzg.chapter02;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.Document;

/**
 * Created by Sam on 2019/6/9.
 */
@Data
@AllArgsConstructor
public class Shop extends Document {
    private String name;
    private double size;
    private double prize;
    private int count;
}
