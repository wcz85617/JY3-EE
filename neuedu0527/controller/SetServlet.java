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

@WebServlet(name = "SetServlet",urlPatterns = "/updata.do")
public class SetServlet extends HttpServlet {

    private UserDao ud;
    @Override
    public void init() throws ServletException {
        ud = new UserDameImpl();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String id = request.getParameter("id");
        String userName = request.getParameter("userName");
        String psw = request.getParameter("psw");
        User user = new User(1,userName,psw);
        ud.setUser(user);
        request.getRequestDispatcher("user.do").forward(request,response);
        response.sendRedirect("user.do");

    }
}
