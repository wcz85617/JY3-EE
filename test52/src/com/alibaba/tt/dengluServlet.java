package com.alibaba.tt;

import com.alibaba.dao.UserDao;
import com.alibaba.dao.UserDaoImpl;
import com.alibaba.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dengluServlet",urlPatterns = "/Hello.doit")
public class dengluServlet extends HttpServlet {
    private UserDao ud;
    String u = null;
    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("dengluname");
        String psw = request.getParameter("denglupsw");
        //密码加密
       // Base64.Encoder encoder = Base64.getEncoder();
        //String s = encoder.encodeToString(psw.getBytes());
        // s就是加密后的密码 但是出不来效果啊 数据库里面还是正常值
        //System.out.println(s);
        User user2 = ud.login(new User(user,psw));
        if(null != user2 ){
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("notok.jsp").forward(request,response);
        }

       // request.getRequestDispatcher("login.jsp").forward(request,response);
    }
}
