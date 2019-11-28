package com.yangzg.crud.constant;

import java.util.Arrays;

/**
 * Created by Sam on 2019/11/24.
 */
public class EmployeeConstant {
    public enum STATE {
        ENABLED(true, "enabled"),
        DISABLED(false, "disabled"),
        UNKNOWN(null, "unknown");

        private Boolean code;
        private String label;

        public String getLabel() {
            return label;
        }

        STATE(Boolean code, String label) {
            this.code = code;
            this.label = label;
        }

        public static STATE which(final Boolean code) {
            if (code == null) return UNKNOWN;
            return Arrays.stream(STATE.values()).filter(state -> state.code == code).findFirst().orElse(UNKNOWN);
        }
    }

    public enum SEX {
        MALE(1, "male"),
        FEMALE(0, "female"),
        UNKNOWN(-1, "unknown");

        private Integer code;
        private String label;

        SEX(Integer code, String label) {
            this.code = code;
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public static SEX which(final Integer code) {
            if (code == null) return UNKNOWN;
            return Arrays.stream(SEX.values()).filter(sex -> sex.code == code).findFirst().orElse(UNKNOWN);
        }
    }
}
