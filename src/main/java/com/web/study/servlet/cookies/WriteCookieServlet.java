package com.web.study.servlet.cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/cookies/write")
public class WriteCookieServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int salary = new Random().nextInt(100000);
        int age = new Random().nextInt(40);
        Cookie cookie = new Cookie("salary", salary + "");
        Cookie cookie2 = new Cookie("age", age + "");
        cookie.setMaxAge(10); // 存續時間,以秒為單位
        cookie2.setMaxAge(10);
        resp.addCookie(cookie); // 將 cookie 寫入 client 端
        resp.addCookie(cookie2);
        PrintWriter out = resp.getWriter();
        out.println("Write cookie ok !");
    }
    
}
