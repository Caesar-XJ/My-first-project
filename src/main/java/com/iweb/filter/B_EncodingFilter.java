package com.iweb.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Caesar
 * @date 2022 08 2022/8/12 16:04
 * @description 类的描述与介绍
 */
@WebFilter(urlPatterns = {"/*"})
public class B_EncodingFilter  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        我们利用过滤器，拦截所有请求的特性
//        我们可以利用过滤器对所有的请求统一设置中文编码
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        HttpServletResponse resp=(HttpServletResponse) servletResponse;
        req.setCharacterEncoding("UTF-8");
        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}
