package com.yangzg.thread.test001;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Sam on 2020/2/23.
 */
public class Test004 {
    public static void main(String[] args) {
        final Instant now = Instant.now();
        System.out.println(now);

        final LocalDate localDate = LocalDate.now(ZoneId.of("GMT+11"));
        final LocalDate localDate1 = localDate.withDayOfMonth(1);
        System.out.println(localDate1);
        System.out.println(localDate);

//        System.out.println(LocalDate.from(now));

        System.out.println(LocalDateTime.ofInstant(now, ZoneId.systemDefault()).toLocalDate());

        System.out.println(LocalDate.MIN);

        System.out.println(LocalTime.MAX);
        System.out.println(LocalTime.MIN);
        System.out.println(LocalTime.MIDNIGHT);

        final Date date = new Date();

        date.toInstant();
        final LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.of("GMT+2"));
        System.out.println(localDateTime.toLocalTime());

        System.out.println(LocalDateTime.ofInstant(Calendar.getInstance().toInstant(), ZoneId.systemDefault()).toLocalTime());

        final ZoneOffset zoneOffset = ZoneOffset.ofHours(3);
        System.out.println(Instant.now().atOffset(zoneOffset));

        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()));

        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()));

        System.out.println(LocalDateTime.now());

        final ZonedDateTime zonedDateTime = LocalDateTime.now().atZone(ZoneId.of("GMT+4"));
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss Z E").format(zonedDateTime));

        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()));

    }
}
