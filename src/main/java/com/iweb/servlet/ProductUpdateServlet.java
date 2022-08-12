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
 * @date 2022 08 2022/8/12 14:39
 * @description 类的描述与介绍
 */
@WebServlet(urlPatterns = {"/updateProduct"})
public class ProductUpdateServlet extends HttpServlet {
    private static ProductDAO dao=new ProductDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pid=Integer.parseInt(req.getParameter("id"));
        String  name=req.getParameter("name");
        float price=Float.parseFloat(req.getParameter("price"));
        int stock=Integer.parseInt(req.getParameter("stock"));
        int cid=Integer.parseInt(req.getParameter("cid"));
        Product p=new Product();
        p.setId(pid);
        p.setName(name);
        p.setPrice(price);
        p.setStock(stock);
        p.setCid(cid);
        dao.update(p);
        resp.sendRedirect("/listProduct?id="+cid);
    }
}
