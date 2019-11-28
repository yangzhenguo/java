package com.yangzg.chapter14;

import lombok.Cleanup;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * Created by Sam on 2019/7/15.
 */
public class NioServerTest {
    public static void main(String[] args) {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(new InetSocketAddress(80));
            @Cleanup
            SocketChannel socketChannel = serverSocketChannel.accept();
            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("监听了");

            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            selectionKeys.forEach(selectionKey -> {
                System.out.println(selectionKey);
                selectionKeys.remove(selectionKey);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
