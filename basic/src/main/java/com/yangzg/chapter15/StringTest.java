package com.yangzg.chapter15;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Sam on 2020/2/17.
 * @author Sam
 */
public class StringTest {
    public static void main(String[] args) {
        final Date date = new Date();
        System.out.println(date.before(new Date(date.getTime() + 1)));

        final Calendar instance = Calendar.getInstance();
        instance.set(2020, 0, 31);
        instance.add(Calendar.MONTH, 1);
        System.out.println(instance.getTime());
    }
}
