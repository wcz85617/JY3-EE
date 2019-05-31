package com.neuedu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter(filterName = "FilterDemo",urlPatterns = "*.jsp")
public class FilterDemo implements Filter {
    String allpage = null;
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response =(HttpServletResponse) resp;
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        if("/login2.jsp".equals(requestURI)){
            chain.doFilter(request,response);
            return;
        }

        List<String> strings = Arrays.asList(allpage.split(","));
        if (strings.contains("requestURI")){
            Object username = request.getSession().getAttribute("username");
            if(null != username){
                chain.doFilter(request,response);

            }else {
               response.sendRedirect("/login2.jsp");
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

       allpage = config.getServletContext().getInitParameter("allege");
        System.out.println(allpage);

    }

}
