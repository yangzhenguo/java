package com.yangzg.chapter09;

import java.io.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * Created by Sam on 2019/6/27.
 */
public class IOTest {
    public static void main(String[] args) {
        test2();
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

}
