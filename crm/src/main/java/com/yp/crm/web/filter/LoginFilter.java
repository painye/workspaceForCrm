package com.yp.crm.web.filter;
/**
 * @author pan
 * @date 2022/2/17 14:54
 */

import com.yp.crm.settings.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName : com.yp.crm.web.filter.LoginFilter
 * @Description : 该类是浏览器的拦截器，主要是拦截不通过登录就访问服务器的内部资源
 * @author pan
 * @date 2022/2/17 14:54
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入到登陆拦截器");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        //如果当前servlet的路径是以下两种路径该拦截器需要进行放行
        String servletPath = httpServletRequest.getServletPath();
        if("/login.jsp".equals(servletPath) || "/settings/user/login.do".equals(servletPath)){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        HttpSession session = httpServletRequest.getSession();

        User user = (User) session.getAttribute("user");

        if(user != null){
            //证明已经通过登录拿到了用户的信息
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            //说明没有登录过,进行重定向
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
