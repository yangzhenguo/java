package com.yangzg.functions;

import org.apache.commons.lang.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Created by Sam on 2019/9/27.
 */
public class DateTimeFunction {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String now(String zone) {
        if (StringUtils.isNotEmpty(zone)) {
            return LocalDateTime.now(ZoneId.of(zone)).format(dtf);
        } else {
            return LocalDateTime.now().format(dtf);
        }
    }
}
