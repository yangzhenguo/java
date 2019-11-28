package com.yangzg.chapter09;

import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.Data;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.stream.DoubleStream;

/**
 * Created by Sam on 2019/6/27.
 */
public class IOTest {
    public static void main(String[] args) {
        test5();
    }

    private static void test5() {
        String s = null;
        try {
            s = FileUtils.readFileToString(new File("basic/src/main/java/com/yangzg/chapter09/IOTest.java"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }

    private static void test4() {
        char[] c = {'a', 'f'};
        System.out.println(c);
        System.out.println("lkdjf");
    }

    private static void test3() {
        try {
            File tempFile = File.createTempFile("obj-", ".data");
            @Cleanup
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tempFile));
            oos.writeObject(new Person("sam", 12, "sss"));
            System.out.println(tempFile);

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(tempFile));
            Object o = ois.readObject();
            if (o instanceof Person) {
                Person person = (Person) o;
                System.out.println(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void test2() {
        File file = new File("basic/src/main/java/com/yangzg/chapter09/IOTest.java");
        if (file.exists()) {
            FileInputStream fis = null;
            try {
                file = file.getCanonicalFile();
                fis = new FileInputStream(file);
                byte[] cs = new byte[1024];
                int len;
                while ((len = fis.read(cs)) != -1) {
                    String buffer = new String(cs, 0, len);
                    System.out.print(buffer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("文件不存在");
        }
        System.out.println(file.getAbsolutePath());
    }

    private static void test1() {
        OutputStream outputStream = null;
        try {
            File tempFile = File.createTempFile("test-io-", ".txt");
            outputStream = new FileOutputStream(tempFile, true);
            final OutputStream writer = outputStream;
            DoubleStream.generate(Math::random).limit(1000).boxed().forEach(num -> {
                try {
                    writer.write((Double.toString(num) + System.lineSeparator()).getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            System.out.println(tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Data
    @AllArgsConstructor
    static class Person implements Serializable {
        private static final long serialVersionUID = -6794956951199926582L;
        private String name;
        private int age;
        private String password;
    }
}
