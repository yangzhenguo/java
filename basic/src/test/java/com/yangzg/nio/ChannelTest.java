package com.yangzg.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 * Created by Sam on 2019/10/13.
 */
public class ChannelTest {
    @Test
    public void test1() {
        try (FileChannel fileChannel = FileChannel.open(Paths.get("/Users/Sam/work/java/java/basic/src/main/resources/jdbc.properties"), StandardOpenOption.READ)) {
            final ByteBuffer buffer = MappedByteBuffer.allocate(2 << 10);
            while (fileChannel.read(buffer) > -1) {
                buffer.flip();
                System.out.println(new String(buffer.array(), 0, buffer.limit()));
                /*
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
                */
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try (
                InputStream inputStream = new FileInputStream("/Users/Sam/work/java/java/basic/src/main/resources/jdbc.properties");
                final ReadableByteChannel readableByteChannel = Channels.newChannel(inputStream);
                ) {
            final ByteBuffer buffer = MappedByteBuffer.allocate(2 << 10);
            while (readableByteChannel.read(buffer) > -1) {
                buffer.flip();
                System.out.println(new String(buffer.array(), 0, buffer.limit()));
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        final ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{1, 2, 3});
        buffer.flip();
        byte[] bytes = Arrays.copyOf(buffer.array(), buffer.limit());
        System.out.println(Arrays.toString(bytes));
        buffer.put((byte)12);
        bytes = Arrays.copyOf(buffer.array(), buffer.limit());
        System.out.println(Arrays.toString(bytes));
    }

    @Test
    public void test4() {
        final CharBuffer buffer = CharBuffer.allocate(10);
        buffer.put('a');
        buffer.flip();
        System.out.println(buffer.get());
        buffer.compact();
        buffer.put('b');
        buffer.flip();
        System.out.println(buffer.get());
    }

    @Test
    public void test5() {
        final ByteBuffer header = ByteBuffer.allocate(128);
        header.put("GET / HTTP1.1\n".getBytes());
        final ByteBuffer body = ByteBuffer.allocate(1 << 10);
        body.put("HOST: www.google.com\n".getBytes());
        body.put("Set-Cookies: name=yzg\n".getBytes());
        header.flip();
        body.flip();
        ByteBuffer[] http = {header, body};
        try (FileChannel fileChannel = FileChannel.open(Paths.get("data.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            fileChannel.write(http);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6() {
        final ByteBuffer headerTitle = ByteBuffer.wrap("GET / HTTP/1.1\n".getBytes());
        final ByteBuffer headerBody = ByteBuffer.allocate(1 << 14);
        final CharBuffer charBuffer = headerBody.asCharBuffer();
        charBuffer.put("Connection: keep-alive\n");
        headerBody.flip();
//        charBuffer.put("Upgrade-Insecure-Requests: 1\n");
//        charBuffer.put("User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36\n");
//        charBuffer.put("Sec-Fetch-Mode: navigate\n");
//        charBuffer.put("Sec-Fetch-User: ?1\n");
//        charBuffer.put("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3\n");
//        charBuffer.put("Sec-Fetch-Site: none\n");
//        charBuffer.put("Accept-Encoding: gzip, deflate, br\n");
//        charBuffer.put("Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7,ar;q=0.6\n");
//        charBuffer.put("Cookie: BIDUPSID=E37015A09665EFADED8D270AADBADD02; PSTM=1499961593; BD_UPN=123253; BAIDUID=1EEA0F49B714E14A111C5D92E58D34F0:FG=1; BDUSS=3g3TkZaRENMQ1pKdU1vcVItb3NxNnd-RzhNMWFyMGdKUlBDbzNxc2Fsa29WY0pkRUFBQUFBJCQAAAAAAAAAAAEAAAAw8Mgi4MhEcmVtX0NvZGVy2LwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACjIml0oyJpdM; BDSFRCVID=2aKOJeCmH6l9LyQwwHqetKJrteKK0gOTHbZAmz4h4mgPq5tVJeC6EG0Ptf8g0Kubdu1yogKK0gOTH6KF_2uxOjjg8UtVJeC6EG0Ptf8g0M5; H_BDCLCKID_SF=tJFfoK0afIK3DPJNh4Q2MDCS5h50bI62aKDsWboaBhcqEn6Sj4kBXbFu5UrH-hjJW2QHLn5cWKJJ8UbS-l6NyRtPhG0tKbTLaRnpaJ5nJq5nhMJmb67JDMP0-xOtJRcy523ion3vQpP-OpQ3DRoWXPIqbN7P-p5Z5mAqKl0MLIOkbC_CjT-bjjv0eUnjK46K-IKX3-b-24t_Hn7zeT5HyU4pbtbLBT5QfmJ8b435WPjqfhv_KROqyUnQbPnnBPjz0CjE_nP2aR3mqD5m3x6qLTKkQN3T-PKO5bRiLRoebCjBDn3oyT3JXp0nj4Rly5jtMgOBBJ0yQ4b4OR5JjxonDh83bG7MJUutfD7H3KCytD0b3D; H_PS_PSSID=; __cfduid=d79ad55864429bdbe1e31a81a91ae95911570694292; MCITY=-131%3A; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; delPer=0; BD_CK_SAM=1; PSINO=2; ZD_ENTRY=empty; BDRCVFR[PaHiFN6tims]=9xWipS8B-FspA7EnHc1QhPEUf; sugstore=0; H_PS_645EC=1090HFP6f5NBjdcmv30wkBPb8sMVkxE3TSfTszJNQpVFASbyFCckWWIeUJtq5whEMTnfulD6\n");
        System.out.println(headerBody.limit());
        System.out.println(headerTitle.limit());

        try (FileChannel fileChannel = FileChannel.open(Paths.get("headers.txt"), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            fileChannel.write(new ByteBuffer[]{headerTitle, headerBody});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}