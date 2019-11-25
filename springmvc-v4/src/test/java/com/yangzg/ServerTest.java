package com.yangzg;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Unit test for simple App.
 */
public class ServerTest {
    @Test
    public void test1(){
//        new Thread(() -> {
            try {
                final ServerSocket serverSocket = new ServerSocket(8000);
                while (true) {
                    final Socket client = serverSocket.accept();
                    new Thread(() -> {
                        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
                            bufferedReader.lines().forEach(System.out::println);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
//        }).start();
    }
}
