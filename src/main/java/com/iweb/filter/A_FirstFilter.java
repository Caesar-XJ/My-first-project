package com.iweb.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试使用的过滤器，写这个是为了证明我们有写过滤器，不想某些公司
 * @author Caesar
 * @date 2022 08 2022/8/12 15:47
 * @description 类的描述与介绍
 */
@WebFilter(urlPatterns = {"/*"})
public class A_FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("可以通过重写init方法来定义我们需要在过滤器启动的时候要做什么" +
                "Filter一定会随着Tomcat的启动而自启动，如果filter启动失败" +
                "或者本身有编译错误，不仅filter不能使用，Tomcat也无法使用");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//       为了保证方法能够征程的调用，需要对参数据进行类型转换
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse resp=(HttpServletResponse)servletResponse;
        String ip=req.getRemoteAddr();
        String url=req.getRequestURL().toString();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d=new Date();
        String  date=sdf.format(d);

        System.out.printf("%s %s 访问了%s%n",date,ip,url);
        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println("在过滤器被销毁的时候执行的方法，一般没啥用");
    }
}
