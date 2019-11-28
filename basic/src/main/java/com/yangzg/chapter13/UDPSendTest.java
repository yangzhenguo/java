package com.yangzg.chapter13;

import java.io.IOException;
import java.net.*;

/**
 * Created by Sam on 2019/7/10.
 */
public class UDPSendTest {
    public static void main(String[] args) {
        test1();
        byte b = (byte) 192;
        System.out.println((b << 24) & 0xFF000000);
    }

    private static void test1() {
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            String message = "hello";
            datagramSocket.send(new DatagramPacket(message.getBytes(), message.length(), InetAddress.getByName("localhost"), 5000));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
