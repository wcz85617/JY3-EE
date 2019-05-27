package com.neuedu.controller;

import com.neuedu.dao.ProDao;
import com.neuedu.dao.ProDaoImpl;
import com.neuedu.pojo.Product;
import com.neuedu.util.FileAction;
import com.neuedu.util.proUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(name = "addServlet",urlPatterns = "/add.do")
@MultipartConfig
public class addServlet extends HttpServlet {
    private ProDao pd;

    @Override
    public void init() throws ServletException {
        pd = new ProDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");

        String proName = request.getParameter("proName");
        String proPrice = request.getParameter("proPrice");
        //拿到图片并上传
        Part file1 = request.getPart("file1");
        String realFileName = FileAction.uploadFile(file1);

        String proDes = request.getParameter("proDes");
        String proStock = request.getParameter("proStock");
        String proDate = request.getParameter("proDate");
        String proCateID = request.getParameter("proCateID");
        String proFactroy = request.getParameter("proFactroy");


        Product product = new Product(proUtil.getProId(),proName,Double.parseDouble(proPrice),realFileName,proDes,Integer.parseInt(proStock),proUtil.getStringConverseDate(proDate),proFactroy,proCateID);
        pd.addOnePro(product);
        response.sendRedirect("addOk.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
