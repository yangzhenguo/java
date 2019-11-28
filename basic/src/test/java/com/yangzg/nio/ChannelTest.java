package com.yangzg.nio;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.concurrent.TimeUnit;

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

    @Test
    public void test7() {
        try (SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(InetAddress.getByName("www.baidu.com"), 80))) {
            final ByteBuffer buffer = ByteBuffer.allocate(1 << 10);
            buffer.put("GET / HTTP/1.1\nHost: www.baidu.com\nConnection: keep-alive\nAccept: */*\nUser-Agent: curl/7.54.0\n\n".getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            socketChannel.shutdownOutput();
            buffer.clear();

            while(socketChannel.read(buffer) > -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.print((char)buffer.get());
                }
                buffer.clear();
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test8() {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(new InetSocketAddress(80));
            serverSocketChannel.configureBlocking(false);

            final Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            int count;
            while ((count = selector.select()) > 0) {
                System.out.println(String.format("count: %d", count));
                final Set<SelectionKey> selectionKeys = selector.selectedKeys();
                final Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    final SelectionKey selectionKey = iterator.next();
                    try {
                        if (selectionKey.isAcceptable()) {
                            final SocketChannel socketChannel = serverSocketChannel.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1 << 10));
                        } else if (selectionKey.isReadable()) {
                            final SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                            final ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
                            while (socketChannel.read(buffer) > -1) {
                                buffer.flip();
                                final OutputStream printStream = new PrintStream(System.out);
                                printStream.write(buffer.array(), 0, buffer.limit());
                                buffer.clear();
                            }
                            socketChannel.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    iterator.remove();
                }
                TimeUnit.SECONDS.sleep(2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test9() {
        try (
                final SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(InetAddress.getLocalHost(), 8009));
                final Selector selector = Selector.open()
        ) {
            socketChannel.configureBlocking(false);
            final SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_WRITE);
            final int interest = selectionKey.interestOps();
            final SelectionKey selectionKey1 = selectionKey.interestOps(SelectionKey.OP_CONNECT);
            System.out.println(selectionKey1.channel());
            System.out.println(interest);

            selectionKey.attach(new ArrayList<String>(){
                private static final long serialVersionUID = 1L;
                {
                    add("abc");
                    add("def");
                    add("ghi");
                }
            });
            final List<String> strings = (List<String>) selectionKey.attachment();
            System.out.println(strings);

            selectionKey.readyOps();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test10() {
        try (
                FileChannel fromChannel = FileChannel.open(Paths.get("/Users/Sam/work/java/java/java.iml"), StandardOpenOption.READ);
                FileChannel toChannel = FileChannel.open(Paths.get("./test.txt"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        ) {
            System.out.println(fromChannel.size());
            System.out.println(new File("/Users/Sam/work/java/java/java.iml").length());
            fromChannel.transferTo(0, fromChannel.size(), toChannel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test11() {
        try (FileChannel fileChannel = FileChannel.open(Paths.get("./test.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            fileChannel.truncate(fileChannel.size() / 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test12() {
        try (
                SocketChannel socketChannel = SocketChannel.open();
                Selector selector = Selector.open();
                FileChannel fileChannel = FileChannel.open(Paths.get("./result.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE)
        ) {
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8009));
            while (selector.select() > 0) {
                final Set<SelectionKey> selectionKeys = selector.selectedKeys();
                final Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    final SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isConnectable()) {
                        System.out.println("1");
                        if (socketChannel.finishConnect()) {

                            final String message = "GET / HTTP/1.1\n\n";
                            final ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
                            socketChannel.write(buffer);
                            socketChannel.shutdownOutput();
                            /*
                            buffer.clear();
                            int length;
                            while ((length = socketChannel.read(buffer)) > -1) {
                                buffer.flip();
                                System.out.println(String.format("length: %d", length));
                                while (buffer.hasRemaining()) {
                                    fileChannel.write(buffer);
                                }
                                buffer.clear();
                            }
                            */
                            buffer.clear();
                            socketChannel.register(selector, SelectionKey.OP_READ, buffer);
                        }
                    } else if (selectionKey.isReadable()) {
                        System.out.println("2");
                        final ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
                        while (socketChannel.read(buffer) > -1) {
                            buffer.flip();
                            while (buffer.hasRemaining()) {
                                System.out.print((char)buffer.get());
                            }
                            buffer.clear();
                        }
                        selectionKey.cancel();
                    } else if (selectionKey.isWritable()) {
                        System.out.println("3");
                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test13() {
        try (DatagramChannel datagramChannel = DatagramChannel.open()) {
            datagramChannel.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8080));
            datagramChannel.write(ByteBuffer.wrap("hello world".getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test14() {
        try (DatagramChannel datagramChannel = DatagramChannel.open()) {
            datagramChannel.bind(new InetSocketAddress(9999));
            final ByteBuffer buffer = ByteBuffer.allocate(1 << 10);
            buffer.clear();
            datagramChannel.receive(buffer);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char)buffer.get());
            }
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}