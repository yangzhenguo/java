package com.yangzg.http;

import com.yangzg.chapter03.Array;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Sam on 2019/6/20.
 */
public class Test2 {
    public static final String NAME;
    static {
        NAME = "sam";
    }
    public static void main(String[] args) {
        test(() -> null).smoke();
        Person person = (Person)null;
        System.out.println(person);
        List list = (List)null;
        System.out.println(list);

//        int[] ints = Stream.iterate((byte) -1, c -> --c).mapToInt(Byte::byteValue).toArray();

        System.out.println(Arrays.toString("哈哈".getBytes()));

        "abc".chars().forEach(System.out::println);

        HashMap<Character, Integer> counts = new HashMap<>();
        "lsfdjalsdfkalsdflskdjfalsdfk".chars().forEach(c -> {
            char key = (char)c;
            if (counts.containsKey(key)) {
                counts.put(key, counts.get(key) + 1);
            } else {
                counts.put(key, 1);
            }
        });

        long count = Pattern.compile("java").splitAsStream("hello java, hi java, holla java!").peek(System.out::println).count();
        System.out.println(count - 1);
    }

    public static Smoking test(Smoking smoking) {
        if (smoking != null) {
            return smoking;
        }
        return null;
    }

    @FunctionalInterface
    interface Smoking {
        Smoking smoke();
    }
}
