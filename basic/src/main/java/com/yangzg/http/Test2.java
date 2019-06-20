package com.yangzg.http;

/**
 * Created by Sam on 2019/6/20.
 */
public class Test2 {
    public static final String NAME;
    static {
        NAME = "sam";
    }
    public static void main(String[] args) {
        test(() -> null).smoke();
    }

    public static Smoking test(Smoking smoking) {
        if (smoking != null) {
            return smoking;
        }
        return null;
    }

    @FunctionalInterface
    interface Smoking {
        Smoking smoke();
    }
}
