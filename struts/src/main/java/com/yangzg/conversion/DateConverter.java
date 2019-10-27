package com.yangzg.conversion;

import com.opensymphony.xwork2.XWorkException;
import org.apache.struts2.util.StrutsTypeConverter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

/**
 * Created by Sam on 2019/10/23.
 */
public class DateConverter extends StrutsTypeConverter {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public Object convertFromString(Map map, String[] strings, Class aClass) {
        if (aClass == Date.class) {
            if (strings != null && strings.length > 0) {
                try {
                    return Date.from(LocalDateTime.from(DATE_TIME_FORMATTER.parse(strings[0])).atZone(ZoneId.systemDefault()).toInstant());
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new XWorkException();
                }
            }
        }
        throw new XWorkException();
    }

    @Override
    public String convertToString(Map map, Object o) {
        return o != null && o.getClass() == Date.class ? DATE_TIME_FORMATTER.format(((Date)o).toInstant()) : null;
    }
}
