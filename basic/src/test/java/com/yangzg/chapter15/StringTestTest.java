package com.yangzg.chapter15;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Sam on 2020/2/17.
 */
public class StringTestTest {
    @Test
    public void test1() {
        String str = "abc";
        str.intern();
    }

    @Test
    public void test2() throws Exception {
        String s1 = "hello";
        String s2 = s1 + " world";
        String s3 = "hello world";
        System.out.println(s2 == s3);
    }

    @Test
    public void test3() throws Exception {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2001);
        System.out.println(calendar.getActualMaximum(Calendar.DATE));
    }

    @Test
    public void test4() throws Exception {
        final Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH));
        System.out.println(cal.get(Calendar.DATE));

        cal.set(2019, Calendar.MARCH, 22, 22, 06, 34);

        System.out.println(cal.getTime());

        cal.add(Calendar.YEAR, -1);

        System.out.println(cal.getTime());

        cal.add(Calendar.MONTH, -3);

        System.out.println(cal.getTime());
    }

    @Test
    public void test5() throws Exception {
        final Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());
        System.out.println(cal.get(Calendar.WEEK_OF_MONTH));
        System.out.println(cal.get(Calendar.WEEK_OF_YEAR));

        final Calendar cal1 = Calendar.getInstance();
        final Calendar cal2 = Calendar.getInstance();
        cal1.add(Calendar.WEEK_OF_YEAR, 30);
        cal2.add(Calendar.WEEK_OF_MONTH, 30);

        System.out.println(cal1.getTime());
        System.out.println(cal2.getTime());

        final int nextDayOfWeek = cal.get(Calendar.WEEK_OF_MONTH) + 1;
        System.out.println(nextDayOfWeek);
//        cal.set(Calendar.DATE, 0);
//        cal.set(Calendar.WEEK_OF_MONTH, nextDayOfWeek);
        System.out.println(cal.getTime());

        cal.setFirstDayOfWeek(Calendar.MONDAY);

        System.out.println(cal.getFirstDayOfWeek());
        System.out.println(cal.getMinimalDaysInFirstWeek());

        System.out.println(cal.get(Calendar.WEEK_OF_MONTH));
        System.out.println(cal.get(Calendar.WEEK_OF_YEAR));
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
        System.out.println(cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
    }

    @Test
    public void test6() throws Exception {
        final Calendar cal = Calendar.getInstance();
        final int currentDay = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        System.out.println(currentDay);

        cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, 2);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, currentDay+1);

        System.out.println(cal.getTime());
    }

    @Test
    public void test7() throws Exception {
        final Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.add(Calendar.WEEK_OF_MONTH, 1);
        System.out.println(cal.getTime());
        cal.add(Calendar.WEEK_OF_MONTH, 1);
        System.out.println(cal.getTime());
    }

    @Test
    public void test8() throws Exception {
        System.out.println(this.getNth2(0));
        System.out.println(this.getNth2(1));
        System.out.println(this.getNth2(2));
    }

    private ActivityPeriod getNth(final int num) {
        final Calendar start = Calendar.getInstance();
        start.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        start.add(Calendar.WEEK_OF_MONTH, num);
        final Calendar end = ((Calendar) start.clone());
        end.add(Calendar.WEEK_OF_MONTH, 1);
        return new ActivityPeriod(start.getTime(), end.getTime());
    }

    private ActivityDate getNth2(final int num) {
        final Calendar start = Calendar.getInstance();
        start.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        start.add(Calendar.WEEK_OF_MONTH, num);

        final Calendar end = ((Calendar) start.clone());
        end.add(Calendar.WEEK_OF_MONTH, 1);

        return new ActivityDate(
                LocalDate.ofYearDay(
                        start.get(Calendar.YEAR),
                        start.get(Calendar.DAY_OF_YEAR)
                ),
                LocalDate.ofYearDay(
                        end.get(Calendar.YEAR),
                        end.get(Calendar.DAY_OF_YEAR)
                )
        );
    }

    @Test
    public void test9() throws Exception {
        final Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 36);
        System.out.println(cal.getTime());
    }

    @Test
    public void test10() throws Exception {
        final Calendar cal = Calendar.getInstance();
        cal.set(2020, Calendar.JANUARY, 31);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY + 12);
        System.out.println(cal.getTime());
    }

    @Test
    public void test11() throws Exception {
        Map<String, String> result = new HashMap<>();
        result.put("abc", "231234");
        final Map<String, Integer> collect = result.keySet().parallelStream().collect(Collectors.toMap(key -> key, key -> Integer.parseInt(result.get(key))));
        System.out.println(collect);
    }

    @Data
    @AllArgsConstructor
    class ActivityPeriod {
        private Date start;
        private Date end;
    }

    @Data
    @AllArgsConstructor
    class ActivityDate {
        private LocalDate start;
        private LocalDate end;
    }
}