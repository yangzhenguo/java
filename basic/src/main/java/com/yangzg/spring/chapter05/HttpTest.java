package com.yangzg.spring.chapter05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Created by Sam on 2019/6/26.
 */
public class HttpTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        try {
            URL url = new URL("https://httpbin.org/post");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);

            OutputStream os = connection.getOutputStream();
            os.write("password=e10adc3949ba59abbe56e057f20f883e&username=test3".getBytes());
            os.flush();
            os.close();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    br.lines().forEach(System.out::println);
                }
            }
            LocalDate start = LocalDate.of(1, 2, 3);
            LocalDate end = LocalDate.of(2, Month.DECEMBER, 2);
            Period between = Period.between(start, end);
            System.out.println(between);
            System.out.println(ChronoUnit.MONTHS.between(start, end));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
