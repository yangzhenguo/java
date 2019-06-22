package com.yangzg.http;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Sam on 2019/6/22.
 */
public class DateTest {
    public static void main(String[] args) {
        System.out.println(new Date(Long.MAX_VALUE));
        long 哈哈 = new Date().getTime();
        System.out.println(哈哈);
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("GMT+6"));
        System.out.println(instance.getTimeZone());

        System.out.println(instance.get(Calendar.MONTH));

        Period between = Period.between(LocalDate.of(1, 2, 3), LocalDate.of(2, 3, 2));
        System.out.println(between);
        System.out.println(between.getYears());
        System.out.println(between.getMonths());
        System.out.println(between.getDays());

        Calendar.getInstance().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        long between1 = ChronoUnit.MONTHS.between(LocalDate.of(1, 2, 3), LocalDate.of(2, 3, 4));
        System.out.println(between1);

        Duration between2 = Duration.between(LocalDateTime.ofInstant(Calendar.getInstance().toInstant(), ZoneId.systemDefault()), LocalDateTime.of(1, 2, 3, 4, 5));
        System.out.println(between2);

        Duration between3 = Duration.between(LocalTime.of(1, 2), LocalTime.of(3, 2));
        System.out.println(between3);

        Integer integer = Integer.valueOf(1);
        Integer integer1 = Integer.valueOf("12");

        Integer.parseInt("12");
        new Integer(23).intValue();

        Integer.toString(23);
        new Integer(23).toString();


    }
}
