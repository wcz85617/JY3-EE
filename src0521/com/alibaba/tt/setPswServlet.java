package com.alibaba.tt;

import com.alibaba.dao.UserDao;
import com.alibaba.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "setPswServlet",urlPatterns = "/Hello.donow")
public class setPswServlet extends HttpServlet {
    private UserDao ud;
    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("userName");
        String psw = request.getParameter("oldpsw");
        String newPsw = request.getParameter("newpsw");
        String newPsw1 = request.getParameter("newpsw1");






    }
}
