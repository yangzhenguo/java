package com.yangzg.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;
import java.util.stream.IntStream;

/**
 * Created by Sam on 2019/9/26.
 */
public class HelloTag extends SimpleTagSupport {
    private StringWriter stringWriter = new StringWriter();

    private int times;

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    @Override
    public void doTag() throws JspException, IOException {
        this.getJspContext().getOut().write("hello: ");
        IntStream.rangeClosed(1, this.times).forEach(times -> {
            try {
                getJspBody().invoke(null);
            } catch (JspException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
