package com.neuedu.controller;

import com.neuedu.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowServlet",urlPatterns = "/show.do")
public class ShowServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //String id = request.getParameter("id");
        String userName= request.getParameter("userName");
        String psw = request.getParameter("psw");
        //int id1 = Integer.parseInt(id);
        User user = new User(userName, psw);

        request.setAttribute("user",user);
        request.getRequestDispatcher("xiugai.jsp").forward(request,response);


    }
}
