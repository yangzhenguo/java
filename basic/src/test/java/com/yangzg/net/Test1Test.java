package com.yangzg.net;

import lombok.Cleanup;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

/**
 * Created by Sam on 2019/9/17.
 */
public class Test1Test {
    @Test
    public void test1() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        System.out.println(localHost.getHostAddress());
        System.out.println(Pattern.compile("/").splitAsStream(localHost.getHostAddress()).findFirst().orElse("localhost"));
    }

    @Test
    public void test2() throws UnknownHostException {
        InetAddress address = InetAddress.getByName("www.micous.com");
        System.out.println(address);
    }

    @Test
    public void test3() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            int port = 9999;
            try (
                    Socket socket = new Socket(address, port);
                    OutputStream outputStream = socket.getOutputStream()
            ) {
                outputStream.write("hello".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            while (true) {
                Socket socket = serverSocket.accept();
                @Cleanup
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bufferedReader.lines().forEach(System.out::println);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}