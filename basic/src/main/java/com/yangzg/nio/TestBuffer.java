package com.yangzg.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Sam on 2019/9/17.
 */
public class TestBuffer {
    public static void main(String[] args) {
        try (
                FileInputStream fis = new FileInputStream("basic/haha.txt");
                FileOutputStream fos = new FileOutputStream("basic/hehe.txt");
                FileChannel inChannel = fis.getChannel();
                FileChannel outChannel = fos.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(2 << 10);
            System.out.println(buffer);

            while (inChannel.read(buffer) != -1) {
                buffer.flip();
                outChannel.write(buffer);
                buffer.clear();
                System.out.println(1);
            }
            System.out.println(2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
