package com.yangzg.java.group.server.util;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Sam on 2020/1/17.
 * @author Sam
 */
public class UrlUtil {
    public static URL getUrl(String url) {
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(getUrl("https://www.baidu.com/").getHost());

        System.out.println(getUrl("ftp://ftp.google.com").getProtocol());
    }
}
