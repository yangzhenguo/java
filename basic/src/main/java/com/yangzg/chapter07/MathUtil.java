package com.yangzg.chapter07;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Predicate;

/**
 * Created by Sam on 2019/6/18.
 */
public class MathUtil {
    static <T> Collection<T> filter(Collection<T> c, Predicate<T> p) {
        Collection<T> result = Collections.EMPTY_LIST;
        for (T t :
                c) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
