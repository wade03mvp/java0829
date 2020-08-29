package com.web.study.servlet;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyGenericServlet extends GenericServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init MyGenericServlet."); // 印在TomEE 的 console
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service MyGenericServlet.");  // 印在TomEE 的 console
        res.getWriter().print("service MyGenericServlet."); // 印在 client 端的瀏覽器
    }

    @Override
    public void destroy() {
        System.out.println("destroy MyGenericServlet.");  // 印在TomEE 的 console
    }

}
