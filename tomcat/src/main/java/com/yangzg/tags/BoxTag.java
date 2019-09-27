package com.yangzg.tags;

import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Created by Sam on 2019/9/27.
 */
public class BoxTag extends SimpleTagSupport {
    private int time;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
