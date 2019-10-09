package com.hiyzg.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sam on 2019/10/7.
 */
public class MyHttpServletRequest extends HttpServletRequestWrapper {
    private static final List<String> WORDS = Arrays.asList(
            "fuck",
            "dick"
    );

    public MyHttpServletRequest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String parameter = super.getParameter(name);
        if (parameter != null) {
            for (String WORD : WORDS) {
                parameter = parameter.replaceAll(WORD, new String(new char[WORD.length()]).replace("\0", "?"));
            }
        }
        return parameter;
    }
}
