package com.yangzg.model.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sam on 2019/9/24.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private String name;
    private String address;
    private String cardType;
    private String card;
}
