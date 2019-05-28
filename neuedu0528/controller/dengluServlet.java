package com.neuedu.controller;

import com.neuedu.dao.UserDameImpl;
import com.neuedu.dao.UserDao;
import com.neuedu.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@WebServlet(name = "dengluServlet",urlPatterns = "/Hello.doit")
public class dengluServlet extends HttpServlet {
    private UserDao ud;
    String u = null;
    @Override
    public void init() throws ServletException {
        ud = new UserDameImpl();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("dengluname");
        String psw = request.getParameter("denglupsw");
        User user2 = ud.login(new User(8,user,psw));
        if(null != user2 ){
            request.getRequestDispatcher("houtai.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("zuce.jsp").forward(request,response);
        }

    }
}

