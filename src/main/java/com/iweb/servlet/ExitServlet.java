package com.iweb.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Caesar
 * @date 2022 08 2022/8/13 9:48
 * @description 类的描述与介绍
 */
@WebServlet(urlPatterns = {"/exit"})
public class ExitServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session=req.getSession();
        session.setAttribute("user",null);
        resp.sendRedirect("login.jsp");
    }
}
