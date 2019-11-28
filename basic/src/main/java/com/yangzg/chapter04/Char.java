package com.yangzg.chapter04;

import java.util.stream.Stream;

/**
 * Created by Sam on 2019/6/13.
 */
public class Char {
    public static void main(String[] args) {
        try (Stream<Character> limit = Stream.iterate('\u4E00', c -> ++c).limit('\u9FA5' - '\u4E00')) {
            limit.forEach(System.out::println);
        }

        Stream.iterate('A', c -> ++c).limit('z' - 'A').forEach(System.out::println);
        Stream.iterate(0, n -> n + 2).limit(51).forEach(System.out::println);
    }
}
