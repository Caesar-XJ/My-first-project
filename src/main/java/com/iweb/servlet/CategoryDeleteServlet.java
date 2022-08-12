package com.iweb.servlet;

import com.iweb.DAO.CategoryDAO;
import com.iweb.DAO.impl.CategoryDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Caesar
 * @date 2022 08 2022/8/11 19:25
 * @description 类的描述与介绍
 */
@WebServlet(urlPatterns = {"/deleteCategory"})
public class CategoryDeleteServlet extends HttpServlet {
    public static CategoryDAO categoryDAO=new CategoryDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       获取参数id
        int id=Integer.parseInt(req.getParameter("id"));
//       调用DAO实心删除
        categoryDAO.delete(id);
//        直接进行页面跳转，ListCategory.jsp本身是没有数据的
//        发送/listServlet的请求，让应对的servlet从数据库获取数据之后
//        转发跳转到listCategory.jsp
        req.getRequestDispatcher("/listCategory");
//        req.getRequestDispatcher("/listCategory").forward(req,resp);
    }
}
