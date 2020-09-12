package com.web.study.filter;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/report/*", "/servlet/lotto"})
public class LoginFilter extends HttpFilter {

    private static String[][] users = {{"admin", "1234"}, {"mary", "1111"}, {"jo", "2222"}};

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        if (req.getParameter("username") != null
                && req.getParameter("password") != null
                && req.getParameter("username").trim().length() > 1
                && req.getParameter("password").trim().length() > 1) {
            // 確認 username & password 是否正確?
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            boolean check = Arrays.stream(users)
                    .filter(user -> user[0].equals(username) && user[1].equals(password))
                    .findAny()
                    .isPresent();
            if (check) {
                chain.doFilter(req, resp);
            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/forms/login_form.jsp"); // 內傳導網址不改變
                rd.forward(req, resp);
            }
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/forms/login_form.jsp");
            rd.forward(req, resp);
        }
    }
}
