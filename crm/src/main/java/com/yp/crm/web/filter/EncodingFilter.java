package com.yp.crm.web.filter;
/**
 * @author pan
 * @date 2022/2/17 10:33
 */

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName : com.yp.crm.web.filter.EncodeingFilter
 * @Description : 用来过滤中文字符乱码的过滤器
 * @author pan
 * @date 2022/2/17 10:33
 */
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入到字符编码过滤的过滤器");

        //过滤post请求中文参数乱码
        servletRequest.setCharacterEncoding("UTF-8");
        //过滤相应的中文编码
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
