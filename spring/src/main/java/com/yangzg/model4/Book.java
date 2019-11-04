package com.yangzg.model4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sam on 2019/11/2.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int id;
    private String name;
    private double price;
    private int amount;
}
