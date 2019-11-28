package com.yangzg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Sam on 2019/11/12.
 */
@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @XmlAttribute
    private int id;

    @XmlAttribute
    private String name;

    @XmlAttribute
    private double salary;
}
