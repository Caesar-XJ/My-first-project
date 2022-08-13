package com.iweb.servlet;

import com.iweb.DAO.impl.UserDAOImpl;
import com.iweb.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Caesar
 * @date 2022 08 2022/8/13 9:16
 * @description 类的描述与介绍
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        接受参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

        boolean isLogin=new UserDAOImpl().login(user);
        if(isLogin){
//            将用户的数据存于session中，用于交给后续的过滤器进行获取
            HttpSession session=req.getSession();
            session.setAttribute("user",user);
//            跳转到分类管理页面
            resp.sendRedirect("/listCategory");
        }else{
//            登录不成功，跳转到登录页面
            resp.sendRedirect("login.jsp");
        }
    }
}
