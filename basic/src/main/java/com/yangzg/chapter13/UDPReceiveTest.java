package com.yangzg.chapter13;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by Sam on 2019/7/10.
 */
public class UDPReceiveTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        try (DatagramSocket datagramSocket = new DatagramSocket(5000)) {
            byte[] data = new byte[2 << 10];
            DatagramPacket dp = new DatagramPacket(data, data.length);
            while (true) {
                datagramSocket.receive(dp);
                System.out.println(dp.getAddress() + ", " + dp.getPort());
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
