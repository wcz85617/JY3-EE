package com.neuedu.controller;

import com.neuedu.dao.ProDao;
import com.neuedu.dao.ProDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delServlet",urlPatterns = "/delete.do")
@MultipartConfig
public class delServlet extends HttpServlet {
    private ProDao pd;
    @Override
    public void init() throws ServletException {
        pd = new ProDaoImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String proName = request.getParameter("proName");
        pd.delOnePro(proName);
        response.sendRedirect("addOk.jsp");
    }
}
