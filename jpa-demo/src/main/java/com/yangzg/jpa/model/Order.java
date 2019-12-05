package com.yangzg.jpa.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Sam on 2019/12/5.
 */
@Data
@Entity
@Table(name = "JPA_ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn
    private Customer customer;
}
