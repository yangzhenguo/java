package com.yangzg.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Sam on 2020/2/21.
 */
public class SecondThread {
    private static final String HR = new String(new char[10]).replace("\0", "-");

    public static void main(String[] args) {
        final DYThread dyThread = new DYThread(101, 120);
        dyThread.start();
    }

    static class DYThread extends Thread {
        int start;
        int end;

        public DYThread(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            IntStream.rangeClosed(start, end).forEach(n -> {
                try {
                    final URL url = new URL(String.format("https://www.douyu.com/%d", n));
                    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                        final String content = bufferedReader.lines().collect(Collectors.joining("\n"));
                        if (!content.contains("房间已被关闭")) {
                            System.out.println(String.format("%s[%s]%s", HR, n, HR));
                        }
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
