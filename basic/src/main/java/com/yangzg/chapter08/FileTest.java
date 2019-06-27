package com.yangzg.chapter08;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by Sam on 2019/6/26.
 */
public class FileTest {
    public static void main(String[] args) {
        test5();
    }

    private static void test5() {
        Arrays.stream(new File(".").listFiles(File::isFile)).forEach(System.out::println);
    }

    private static void test4() {
        Arrays.stream(File.listRoots()).forEach(System.out::println);
    }

    private static void test3() {
        Optional.of(new File(".")).filter(File::exists).ifPresent((File file) -> {
            Optional.ofNullable(file.listFiles()).ifPresent(files -> Arrays.stream(files).map(f -> {
                try {
                    return f.getCanonicalFile();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }).filter(Objects::nonNull).forEach(System.out::println));
        });
    }

    private static void test2() {
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);
    }

    private static void test1() {
        URL resource = FileTest.class.getResource(".");
        System.out.println(resource);
        resource = FileTest.class.getResource("/");
        System.out.println(resource);

        try {
            Files.walk(Paths.get(FileTest.class.getResource("/").toURI())).sorted().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
