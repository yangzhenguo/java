package com.yangzg.nio;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;

/**
 * Created by Sam on 2019/9/17.
 */
public class TestBuffer {
    private static final int LENGTH = 1000;

    @Test
    public void test1() {
        ByteBuffer buffer = ByteBuffer.allocate(LENGTH);

        System.out.println(new String(new char[100]).replace("\0", "8"));
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        System.out.println(new String(new char[100]).replace("\0", "8"));
        buffer.put("hello world".getBytes());
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println(new String(new char[100]).replace("\0", "8"));

        buffer.flip();
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println(buffer.get());

        System.out.println(buffer.position());

        System.out.println(new String(new char[100]).replace("\0", "8"));

        buffer.rewind();
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        System.out.println(new String(new char[100]).replace("\0", "8"));

        buffer.clear();
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());

        System.out.println(buffer.get());

        ByteBuffer.allocateDirect(123);
        buffer.rewind();
    }

    @Test
    public void test2() {
        try (
                FileChannel inChannel = FileChannel.open(Paths.get("haha.txt"), StandardOpenOption.READ);
                FileChannel outChannel = FileChannel.open(Paths.get("hehe.txt"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            System.out.println(inChannel.size());
            Instant begin = Instant.now();
            MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            System.out.println(inMappedBuf);

            byte[] bytes = new byte[inMappedBuf.limit()];
            inMappedBuf.get(bytes);
            outMappedBuf.put(bytes);

            Instant end = Instant.now();
            System.out.println(Duration.between(begin, end).toMillis());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}