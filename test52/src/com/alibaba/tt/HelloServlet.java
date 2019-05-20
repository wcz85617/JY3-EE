package com.alibaba.tt;

import com.alibaba.dao.UserDao;
import com.alibaba.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@WebServlet(name = "HelloServlet",urlPatterns = "/Hello.do")
public class HelloServlet extends HttpServlet {
    private UserDao ud;
    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("userName");
        String psw = request.getParameter("psw");
        //密码加密
        Base64.Encoder encoder = Base64.getEncoder();
        String s = encoder.encodeToString(psw.getBytes());
        ud.regsiter(user,s);
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
}
