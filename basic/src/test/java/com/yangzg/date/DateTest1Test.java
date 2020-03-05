package com.yangzg.date;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.function.IntFunction;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Sam on 2020/3/4.
 */
public class DateTest1Test {
    @Test
    public void test001() throws Exception {
        final Date date = new Date(2014 - 1900, 3 - 1, 18);
        System.out.println(date);

        System.out.println(Instant.MIN);

        final Instant now1 = Instant.now();

        final Instant now2 = Instant.now();

        System.out.println(now1.equals(now2));
    }

    @Test
    public void test002() throws Exception {
        final Instant min = Instant.MIN;
        final Instant max = Instant.MAX;
        final Duration between = Duration.between(min, max);
        System.out.println(between);

        System.out.println(between.toMillis());

        System.out.println(between.toHours());

        System.out.println(between.toMinutes());
    }

    @Test
    public void test003() throws Exception {
        final Instant start = Instant.now();

        final Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_MONTH, 1);

        final Calendar calendar2 = Calendar.getInstance();
        final Duration between = Duration.between(calendar1.toInstant(), calendar2.toInstant());
        System.out.println(between);

        System.out.println(between.toDays());

        System.out.println(between.getSeconds());

        final Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toNanos());
        System.out.println(Duration.between(start, end).toMillis());

        System.out.println(Instant.now().plus(between).plus(1, ChronoUnit.DAYS));

        System.out.println(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()));

        System.out.println(LocalDate.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth()));
    }

    @Test
    public void test004() throws Exception {
        System.out.println(Instant.now().with(ChronoField.MILLI_OF_SECOND, 23));
    }

    @Test
    public void test005() throws Exception {
        final Duration duration = Duration.ofDays(365);
        final Duration duration1 = duration.multipliedBy(3);
        System.out.println(duration1);

        System.out.println(duration1.toNanos());
    }

    @Test
    public void test006() throws Exception {
        final Instant start = Instant.now();
        runAlgorithm();
        final Instant end = Instant.now();

        final Duration timeElapsed = Duration.between(start, end);
        System.out.format("%d milliseconds\n", timeElapsed.toMillis());

        System.out.println(timeElapsed.multipliedBy(10).minus(Duration.of(123, ChronoUnit.MILLIS)).toNanos());


        new Random().ints(-100, 100).limit(12).forEach(System.out::println);
    }

    @Test
    public void test007() throws Exception {
        IntFunction<Random> randomIntFunction = Random::new;

        randomIntFunction.apply(12).ints().limit(10).forEach(System.out::println);
    }

    @Test
    public void test008() throws Exception {
        new Random().ints(10, 10, 100000).mapToObj(Duration::ofHours).reduce(Duration::plus).ifPresent(System.out::println);
    }

    @Test
    public void test009() throws Exception {
        final LocalDate now = LocalDate.now(ZoneId.of("GMT+3"));
        final LocalDate prevMonth = now.with(TemporalAdjusters.lastDayOfMonth()).minusMonths(1);
        System.out.println(prevMonth);

        System.out.println(prevMonth.atStartOfDay(ZoneId.of("GMT+3")).toInstant());

        System.out.println(LocalDate.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth()).atStartOfDay().toInstant(ZoneOffset.UTC));

        System.out.println(LocalDate.now(ZoneId.of("GMT-11")));

        final LocalDate parse = LocalDate.parse("2020-02-01");
        System.out.println(parse.atStartOfDay().with(TemporalAdjusters.lastDayOfMonth()).toInstant(ZoneOffset.UTC));

        System.out.println(Timestamp.valueOf(parse.atStartOfDay()));

        final ZonedDateTime firstDay = parse.atStartOfDay(ZoneId.of("GMT+5"));

        final ZonedDateTime lastDay = firstDay.plusMonths(1);

        System.out.println(firstDay);
        System.out.println(lastDay);

        System.out.println(Timestamp.from(firstDay.toInstant()));
        System.out.println(Timestamp.from(lastDay.toInstant()));

        TimeZone.getDefault().toZoneId();
    }

    @Test
    public void test010() throws Exception {
        new Random().ints(3, 10).limit(5).mapToObj(String[]::new).mapToInt(a -> a.length).forEach(System.out::println);

        Stream.of(1, 2, 3, 4).flatMap(Stream::of).forEach(System.out::println);
        Stream.of(new int[] {1,2,3}).forEach(System.out::println);

        Pattern.compile("\\s+").splitAsStream("bsd adfaf lks flkasjkdf aks alksdf allas slk  asdf").forEach(System.out::println);
    }

    private void runAlgorithm() {
        final int size = 10;;
        final List<Integer> list = new Random().ints().map(i -> i % 10).limit(size).boxed().collect(Collectors.toList());
        Collections.sort(list);
        System.out.println(list);
    }
}