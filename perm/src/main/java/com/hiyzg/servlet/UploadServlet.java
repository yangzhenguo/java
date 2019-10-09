package com.hiyzg.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * Created by Sam on 2019/10/9.
 */
@MultipartConfig()
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Part file = req.getPart("file");
        final long size = file.getSize();
        resp.getWriter().write(file.getSubmittedFileName() + ": " + String.valueOf(size));
    }
}
