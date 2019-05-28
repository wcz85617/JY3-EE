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

@WebServlet(name = "addUserServlet",urlPatterns = "/useradd.do")
public class addUserServlet extends HttpServlet {

    private UserDao ud;
    @Override
    public void init() throws ServletException {
        ud = new UserDameImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String psw = request.getParameter("psw");
        User user = new User(8,userName,psw);
        ud.addUser(user);
        request.getRequestDispatcher("houtai.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              doPost(request,response);
    }
}
