package com.yangzg.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by Sam on 2019/9/26.
 */
public class MaxTag extends SimpleTagSupport {
    private Number num1;
    private Number num2;

    public void setNum1(Number num1) {
        this.num1 = num1;
    }

    public void setNum2(Number num2) {
        this.num2 = num2;
    }

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().print(Math.max(num1.doubleValue(), num2.doubleValue()));
    }
}
