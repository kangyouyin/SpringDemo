package com.kyy.springmvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kangyouyin on 2018/10/11.
 */
public class MyServlet
        extends org.springframework.web.servlet.DispatcherServlet {
    @Override
    protected void noHandlerFound(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.getRequestDispatcher("/index.html").forward(request, response);
    }
}