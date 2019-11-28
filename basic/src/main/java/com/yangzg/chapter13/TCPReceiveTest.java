package com.yangzg.chapter13;

import lombok.Cleanup;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;

/**
 * Created by Sam on 2019/7/10.
 */
public class TCPReceiveTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        try (ServerSocket serverSocket = new ServerSocket(80)) {
            @Cleanup
            Socket socket = serverSocket.accept();
            System.out.println(socket.getInputStream().getClass());
            SocketChannel channel = socket.getChannel();
            @Cleanup
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedReader.lines().forEach(line -> {
                System.out.println(line);
                if (StringUtils.isEmpty(line) || "".equalsIgnoreCase(line)) {
                    return;
                }
            });
            @Cleanup
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("hello");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
