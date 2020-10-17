package com.web.captcha;

import java.util.Set;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SSOSessionListener implements HttpSessionListener{

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        String username = se.getSession().getAttribute("username") + "";
        Set<String> alreadyLoginMembers = (Set<String>)se.getSession().getServletContext().getAttribute("alreadyLoginMembers");
        alreadyLoginMembers.remove(username);
        System.out.println(alreadyLoginMembers);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSessionListener.super.sessionCreated(se); //To change body of generated methods, choose Tools | Templates.
    }
    
}
