package com.hiyzg.proto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Sam on 2019/8/23.
 */
@Data
public class Person implements Serializable {
    private int age;

    private List<Integer> nums = IntStream.of(1,2,3).boxed().collect(Collectors.toList());
}
