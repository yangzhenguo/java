package com.yangzg.thread.test001;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sam on 2020/2/23.
 */
public class Test003 {
    public static void main(String[] args) {
        final Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+5"));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(calendar.getTime());

        System.out.println(calendar.getTimeInMillis());
        System.out.println(calendar.getTime().getTime());

        System.out.println(TimeUnit.DAYS.convert(calendar.getTimeInMillis() - new Date(0).getTime(), TimeUnit.MILLISECONDS));

        System.out.println(TimeUnit.DAYS.convert(25, TimeUnit.HOURS));
    }
}
