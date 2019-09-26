package com.yangzg.tags;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringEscapeUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.File;
import java.io.IOException;

/**
 * Created by Sam on 2019/9/26.
 */
public class ReadFileTag extends SimpleTagSupport {
    private String file;

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().getOut().write(StringEscapeUtils.escapeHtml(FileUtils.readFileToString(new File(this.file))));
    }
}
