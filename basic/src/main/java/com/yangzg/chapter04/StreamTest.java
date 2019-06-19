package com.yangzg.chapter04;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.yangzg.chapter03.Array;
import org.bson.Document;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.*;

/**
 * Created by Sam on 2019/6/14.
 */
public class StreamTest {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
//        test8();
//        test9();
//        test10();
//        test12();
//        test13();
//        test14();
//        test15();
//        test16();
//        test17();
//        test18();
//        test19();
//        test20();
        test21();
    }

    private static void test21() {
        Optional<Character> first = Stream.iterate('\u0001', c -> ++c).limit(100).parallel().sorted(Comparator.comparingInt(i -> -i)).findFirst();
        first.ifPresent(System.out::println);
    }

    private static void test20() {
        Stream.of("a", "b", "c", "d", "e", "f", "g", "h", "j", "k").parallel().forEachOrdered(System.out::println);
    }

    private static void test19() {
        new Random().ints().limit(10).peek(System.out::println).forEach(System.out::println);
    }

    private static void test18() {
        Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        ).flatMap(Collection::stream).forEach(System.out::println);
    }

    private static void test17() {
        new Random().ints(0, Integer.MAX_VALUE).limit(10).mapToLong(Long::valueOf).forEach(System.out::println);
    }

    private static void test16() {
        try (FileReader fileReader = new FileReader("/usr/share/dict/words"); Jedis jedis = new Jedis()) {
            jedis.select(2);
            new BufferedReader(fileReader).lines().map(String::toUpperCase).forEach(word -> {
                jedis.publish("chat", word);
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void test15() {
        Stream.of("hello", "world").map(String::toUpperCase).forEach(System.out::println);
    }

    private static void test14() {
        String[] strings = Stream.of("a", "b", "c").toArray(size -> {
            System.out.println(size);
            return new String[size];
        });
        System.out.println(strings);
    }

    private static void test13() {
        IntStream.of(new int[]{1,2,3,}).forEach(System.out::println);
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);
    }

    private static void test12() {
        double sum = new Random().ints(1, 10).limit(10).average().getAsDouble();
        System.out.println(sum);
    }

    private static void test11() {
        try (MongoClient mongoClient = new MongoClient()) {
            MongoCollection<Document> collection = mongoClient.getDatabase("shop").getCollection("names");
            StreamSupport.stream(collection.find().limit(10).spliterator(), false).forEach(System.out::println);
        }
    }

    private static void test10() {
        Pattern.compile("").splitAsStream("abc").forEach(System.out::println);
    }

    private static void test9() {
        "abc".chars().forEach(System.out::println);
    }

    private static void test8() {
        try (Stream<Path> stream = Files.walk(Paths.get("."), 2, FileVisitOption.FOLLOW_LINKS)) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void test7() {
        new Random().ints(10, 100, 101).forEach(System.out::println);
    }

    private static void test6() {
        new Random().doubles().limit(100).forEach(System.out::println);
    }

    private static void test5() {
        try (IntStream ints = IntStream.range(1, 10)) {
            ints.forEach(System.out::println);
        }
    }

    private static void test4() {
        new BufferedReader(new StringReader("hello world\nabc")).lines().forEach(System.out::println);
    }

    private static void test3() {
        Arrays.stream(new int[]{5,2,1}).forEachOrdered(System.out::println);
    }

    private static void test1() {
        List<Integer> collect = Stream.of(2, 5, 1, 8, 5)
                .parallel()
                .filter(t -> t % 2 == 0)
                .sorted(Comparator.comparingInt(Integer::intValue).reversed())
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void test2() {
        Arrays.asList(1, 3, 2)
                .parallelStream()
                .sorted(Integer::compareTo)
                .forEach(System.out::println);
    }
}
