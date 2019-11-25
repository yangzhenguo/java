package com.yangzg.crud.constant;

import java.util.Arrays;

/**
 * Created by Sam on 2019/11/24.
 */
public class EmployeeConstant {
    public enum STATE {
        ENABLED(1, "enabled"),
        DISABLED(0, "disabled"),
        UNKNOWN(-1, "unknown");

        private int code;
        private String label;

        public String getLabel() {
            return label;
        }

        STATE(int code, String label) {
            this.code = code;
            this.label = label;
        }

        public static STATE which(final Integer code) {
            return Arrays.stream(STATE.values()).filter(state -> code == null || state.code == code).findFirst().orElse(UNKNOWN);
        }
    }
}
