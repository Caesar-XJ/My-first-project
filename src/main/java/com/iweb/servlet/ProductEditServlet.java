package com.iweb.servlet;

import com.iweb.DAO.ProductDAO;
import com.iweb.DAO.impl.ProductDAOImpl;
import com.iweb.pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Caesar
 * @date 2022 08 2022/8/12 14:22
 * @description 类的描述与介绍
 */
@WebServlet(urlPatterns = {"/editProduct"})
public class ProductEditServlet extends HttpServlet {
    private static ProductDAO dao=new ProductDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        先获取商品id
        int pid=Integer.parseInt(req.getParameter("id"));
//        获取商品的对象
        Product p=dao.get(pid);
//        数据存入请求
        req.setAttribute("p",p);
//        通过转发跳转到aditProduct.jsp
        req.getRequestDispatcher("page/product/editProduct.jsp").forward(req,resp);
    }
}
