package com.iweb.servlet;

import com.iweb.DAO.CategoryDAO;
import com.iweb.DAO.impl.CategoryDAOImpl;
import com.iweb.pojo.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Caesar
 * @date 2022 08 2022/8/11 20:00
 * @description 类的描述与介绍
 */
@WebServlet(urlPatterns = {"/updateCategory"})
public class CategoryUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        Category c=new Category(id,name);
        new CategoryDAOImpl().update(c);
        resp.sendRedirect("/listCategory");


    }
}
