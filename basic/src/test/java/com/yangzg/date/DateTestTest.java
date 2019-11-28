package com.yangzg.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Sam on 2019/9/5.
 */
public class DateTestTest {
    ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd"));

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

    @Test
    public void test1() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Date>> list = IntStream.rangeClosed(1, 100)
                .boxed()
                .map(ThrowingFunction.unchecked(num -> executorService.submit(() -> sdf.parse("20190905"))))
                .collect(Collectors.toList());
        list.forEach(ThrowingConsumer.unchecked((Future<Date> future) -> System.out.println(future.get())));
    }


    @Test
    public void test2() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Date>> list = IntStream.rangeClosed(1, 100)
                .boxed()
                .map(ThrowingFunction.unchecked(num -> executorService.submit(() -> threadLocal.get().parse("20190905"))))
                .collect(Collectors.toList());
        list.forEach(ThrowingConsumer.unchecked((Future<Date> future) -> System.out.println(future.get())));
    }

    @Test
    public void test3() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<LocalDate>> list = IntStream.rangeClosed(1, 100)
                .boxed()
                .map(ThrowingFunction.unchecked(num -> executorService.submit(() -> LocalDate.parse("20190905", dtf))))
                .collect(Collectors.toList());
        list.forEach(ThrowingConsumer.unchecked((Future<LocalDate> future) -> System.out.println(future.get())));
    }

    @Test
    public void test4() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("GMT+2"));
        System.out.println(now);

        Instant instant = Instant.now();
        System.out.println(instant);

        LocalDateTime newNow = now.minusYears(1).plusMonths(1);

        System.out.println(newNow);

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        System.out.println(offsetDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss")));

        System.out.println(instant.toEpochMilli());
    }

    @Test
    public void test5() {
        Instant inst1 = Instant.now();

        Instant inst2 = Instant.now().plusSeconds(123);

        System.out.println(Duration.between(inst1, inst2));

        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.now().plusDays(3);
        System.out.println(Period.between(date1, date2));

        LocalDateTime dt1 = LocalDateTime.now();
        LocalDateTime dt2 = LocalDateTime.now().plusHours(232);
        System.out.println(Duration.between(dt1, dt2).toDays());

        LocalTime time1 = LocalTime.now();
        LocalTime time2 = LocalTime.now().plusMinutes(5234);
        System.out.println(Duration.between(time1, time2));
    }

    @Test
    public void test6() {
        LocalDate now = LocalDate.now();
        LocalDate next = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(next);
    }

    @Test
    public void test7() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(now);
        LocalDateTime workDay = now.with(temporal -> {
            int week = temporal.get(ChronoField.DAY_OF_WEEK);
            return temporal.plus(Duration.ofDays(week >= 5 ? 8 - week : 1));
        });
        System.out.println(workDay);
    }

    @Test
    public void test8() {
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("Asia/Tokyo"));
        System.out.println(zonedDateTime);
    }
}

interface ThrowingConsumer<T, E extends Throwable> {
    void accept(T t) throws E;

    static <T, E extends Throwable> Consumer<T> unchecked(ThrowingConsumer<T, E> f) {
        return t -> {
            try {
                f.accept(t);
            } catch (Throwable e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        };
    }
}

interface ThrowingFunction<T, R, E extends Throwable> {
    R apply(T t) throws E;

    static <T, R, E extends Throwable> Function<T, R> unchecked(ThrowingFunction<T, R, E> f) {
        return t -> {
            try {
                return f.apply(t);
            } catch (Throwable e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        };
    }
}