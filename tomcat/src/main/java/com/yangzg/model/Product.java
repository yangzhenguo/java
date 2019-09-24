package com.yangzg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by Sam on 2019/9/20.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private Double marketPrice;
    private Double shopPrice;
    private String image;
    private Date date;
    private Boolean isHot;
    private String desc;
}
