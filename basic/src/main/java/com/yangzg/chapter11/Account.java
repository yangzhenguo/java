package com.yangzg.chapter11;

import lombok.Data;

import java.util.Date;

/**
 * Created by Sam on 2019/7/7.
 */
@Data
public class Account {
    @Column("id")
    private Integer id;

    @Column("category")
    private String category;

    @Column("amount")
    private Integer amount;

    @Column("channel")
    private String channel;

    @Column("create_dt")
    private Date createDate;

    @Column("description")
    private String description;
}
