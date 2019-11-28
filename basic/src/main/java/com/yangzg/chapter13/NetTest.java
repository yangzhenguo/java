package com.yangzg.chapter13;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Sam on 2019/7/9.
 */
public class NetTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            InetAddress byAddress = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
            System.out.println(byAddress);
            System.out.println(localHost);
            InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
            System.out.println(loopbackAddress);
            InetAddress byName = InetAddress.getByName("SamYongdeMacBook-Pro.local");
            System.out.println(byName);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
