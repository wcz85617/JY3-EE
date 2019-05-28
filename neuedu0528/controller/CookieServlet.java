package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "CookieServlet",urlPatterns = "/cook.do")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello cookie");
        resp.setContentType("text/html;charset=utf-8");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddhh:mm:ss");
        String format = sdf.format(date);
        Cookie cookie = new Cookie("time", format);
        cookie.setPath("/");
        cookie.setMaxAge(60*60*24*7);
        resp.addCookie(cookie);
        Cookie[] cookies = req.getCookies();
        if (null != cookies){
            String time = null;
            for (Cookie c:cookies) {
                if ("time".equals(c.getName())){
                  time = c.getValue();
                }
            }
            if (null != time){
                resp.getWriter().write("上次登录时间"+time);
            }else {
                resp.getWriter().write("欢迎登录");
            }
        }
    }
}
