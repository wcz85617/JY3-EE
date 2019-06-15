package com.neuedu.controller;

import com.neuedu.dao.UserDameImpl;
import com.neuedu.dao.UserDao;
import com.neuedu.pojo.User;
import org.apache.commons.dbutils.DbUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "loginServlet",urlPatterns = "/login.do")
public class loginServlet extends HttpServlet {

    private UserDao ud;
    @Override
    public void init() throws ServletException {
        ud = new UserDameImpl();

    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String psw = req.getParameter("psw");
        User denglu = null;
        try {
            denglu = ud.denglu(new User(username, psw));
            if (null !=denglu) {
                HttpSession session = req.getSession();
                session.setAttribute("username",username);
                resp.sendRedirect("login.jsp");

            }else {
                req.getRequestDispatcher("login2.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
