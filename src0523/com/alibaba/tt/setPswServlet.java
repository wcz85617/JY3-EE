package com.alibaba.tt;

import com.alibaba.dao.UserDao;
import com.alibaba.dao.UserDaoImpl;
import com.alibaba.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "setPswServlet",urlPatterns = "/Hello.donow")
public class setPswServlet extends HttpServlet {
    private UserDao ud;
     User e;
    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("userName");
        String psw = request.getParameter("oldpsw");
        String newPsw = request.getParameter("newpsw");
        String newPsw1 = request.getParameter("newpsw1");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String s = ud.pswGet(user);
        if (s != null){
            if(s == psw){
                ud.pswSte(newPsw,user);
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("notok.jsp").forward(request,response);
            }
        }
    }
}
