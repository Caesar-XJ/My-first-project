package com.iweb.servlet;

import com.iweb.DAO.impl.UserDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Caesar
 * @date 2022 08 2022/8/12 18:42
 * @description 类的描述与介绍
 */
@WebFilter(urlPatterns = {"/*"})
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        UserDAOImpl u=new UserDAOImpl();
        if(u.login(username,password)==true){
            req.getRequestDispatcher("listCategory.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("login.jsp");
        }
    }
}
