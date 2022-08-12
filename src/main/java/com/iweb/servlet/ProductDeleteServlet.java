package com.iweb.servlet;

import com.iweb.DAO.ProductDAO;
import com.iweb.DAO.impl.ProductDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Caesar
 * @date 2022 08 2022/8/12 13:53
 * @description 类的描述与介绍
 */
@WebServlet(urlPatterns = {"/deleteProduct"})
public class ProductDeleteServlet extends HttpServlet {
    private static ProductDAO dao=new ProductDAOImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pid=Integer.parseInt(req.getParameter("id"));
//        先根据pid获取该商品对应的cid
        int cid=dao.get(pid).getCid();
//        调用DAO，删除对应的商品
        dao.delete(pid);
//        重定向到listProduct，并且在发送请求的时候携带参数id
//        这样在listProduct在运行的时候才知道访问哪个分类的商品列表
        resp.sendRedirect("/listProduct?id="+cid);
    }
}
