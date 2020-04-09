package com.yangzg.date;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Sam on 2020/3/5.
 */
public class DateTest2Test {
    private static final TimeZone TIME_ZONE = TimeZone.getTimeZone("GTM+3");

    @Test
    public void test001() throws Exception {
        final LocalDateTime start = LocalDate.now(TIME_ZONE.toZoneId()).with(TemporalAdjusters.firstDayOfMonth()).atStartOfDay().minusMonths(1);
        final LocalDateTime end = start.plusMonths(1).minusNanos(1);

        System.out.println(Timestamp.valueOf(start));
        System.out.println(Timestamp.valueOf(end));
    }

    @Test
    public void test002() throws Exception {
        final Set<Integer> all = Stream.of(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(1, 2, 3, 4)
        ).flatMap(Collection::stream).collect(Collectors.toSet());

        BiPredicate<String, String> b = String::startsWith;

        Function<Random, IntStream> f = Random::ints;

        f.apply(new Random());

        System.out.println(all);

        final ArrayList<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toCollection(ArrayList::new));

        list.stream().sorted(Comparator.reverseOrder());
    }

    @Test
    public void test003() throws Exception {
        List<String> ll = Arrays.asList("123", "23");
        final Optional<String> s = Optional.ofNullable(ll).flatMap(a -> a.stream().findFirst());
        System.out.println(s);

        final Optional<String> os = Optional.ofNullable(ll).flatMap(a -> a.stream().findFirst());
    }
}