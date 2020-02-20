package com.yangzg.thread;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by Sam on 2020/2/19.
 */
public class FirstThreadTest {
    @Test
    public void test1() throws Exception {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Test
    public void test2() throws Exception {
        final LocalDate now = LocalDate.now();
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getDayOfWeek());
        System.out.println(now.getDayOfWeek().getValue());
        System.out.println(now.getDayOfYear());

        System.out.println(Locale.getDefault(Locale.Category.FORMAT));
    }

    @Test
    public void test3() throws Exception {
        final Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+3"));
        System.out.println(calendar.getTimeZone());
        System.out.println(calendar.getTime().toLocaleString());
        System.out.println(calendar.getTimeZone().getRawOffset());
        System.out.println(calendar.getTimeZone().getOffset(System.currentTimeMillis()));

        final DateFormat df = DateFormat.getInstance();
        df.setTimeZone(calendar.getTimeZone());
        System.out.println(df.format(calendar.getTime()));
    }

    @Test
    public void test4() throws Exception {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+5"));
        final Date date = sdf.parse("2020-02-20 23:59:59");
        System.out.println(date);
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(simpleDateFormat.format(date));
    }

    @Test
    public void test5() throws Exception {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+5"));
        System.out.println(calendar.getTime());
        calendar.set(Calendar.DAY_OF_MONTH, 0);

        System.out.println(System.currentTimeMillis() / (3600000 * 24) * (3600000 * 24));
        final long ts = System.currentTimeMillis() / (3600000 * 24);
        System.out.println(ts);
        System.out.println(ts * (3600000 * 24));

        final Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis() / (3600000 * 24) * (3600000 * 24));
        System.out.println(instance);
        System.out.println(instance.getTime());
        calendar.clear();
    }

    @Test
    public void test6() throws Exception {
        final Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+3"));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(calendar.getTime());
        System.out.println(calendar.getTime().getTime());
        System.out.println(calendar.getTime().toGMTString());
    }

    @Test
    public void test7() throws Exception {
        Arrays.stream(TimeZone.getAvailableIDs()).forEach(System.out::println);
    }

    @Test
    public void test8() throws Exception {
        final Thread thread = new Thread(() -> {
            IntStream.rangeClosed(1, 10).forEach(System.out::println);
        });
//        thread.setDaemon(true);
        thread.start();
        System.out.println(thread.isDaemon());
    }
}