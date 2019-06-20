package com.yangzg.http;

import java.util.function.Predicate;

/**
 * Created by Sam on 2019/6/20.
 */
public class Test1 {
    public static void main(String[] args) {
        Inner inner = new Test1().new Inner();
        inner.inner();
    }

    class Inner {
        void inner() {
            int a = 2;
            new Predicate() {
                @Override
                public boolean test(Object o) {
                    int b = a;
                    System.out.println(a);
                    return false;
                }
            };
        }
    }
}
