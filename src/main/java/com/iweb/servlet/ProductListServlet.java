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
import java.util.List;

/**
 * @author Caesar
 * @date 2022 08 2022/8/12 10:19
 * @description 类的描述与介绍
 */
@WebServlet(urlPatterns = {"/listProduct"})
public class ProductListServlet extends HttpServlet {
    private static ProductDAO dao=new ProductDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cid=Integer.parseInt(req.getParameter("id"));
        //获取我们的商品集合
        List<Product> products=new ProductDAOImpl().list(cid);
//        将集合存入到请求中
        req.setAttribute("products",products);
//        利用转发
        req.setAttribute("cid",cid);
        req.getRequestDispatcher("page/product/listProduct.jsp").forward(req,resp);
    }
}
