package com.yangzg;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Unit test for simple App.
 */
public class ClientTest {
    private static List<String> words;

    @BeforeClass
    public static void setup() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/usr/share/dict/words"))) {
            words = bufferedReader.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){
//        new Thread(() -> {
        try {
                Socket client = new Socket(Inet4Address.getByName("0.0.0.0"), 8000);
            final Random random = new Random();
            while (true) {
                final String message = words.get(random.nextInt(words.size()));
                client.getOutputStream().write(String.format("%s: %s!\n", new Date(), message).getBytes());
                    client.getOutputStream().flush();
                    TimeUnit.SECONDS.sleep(2);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        }).start();
    }
}
