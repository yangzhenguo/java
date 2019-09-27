package com.yangzg.tags;

import org.apache.commons.lang.StringUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by Sam on 2019/9/27.
 */
public class ItemTag extends SimpleTagSupport {
    private String message;
    private int times = 1;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter writer = getJspContext().getOut();
        JspFragment body = getJspBody();
        JspTag parent = getParent();
        if (null != parent) {
            BoxTag boxTag = (BoxTag) parent;
            times = boxTag.getTime();
        }
        for (int i = 0; i < times; i++) {
            if (null != body) {
                body.invoke(null);
            } else if (StringUtils.isNotEmpty(message)){
                writer.write(message);
            }
        }
    }
}
