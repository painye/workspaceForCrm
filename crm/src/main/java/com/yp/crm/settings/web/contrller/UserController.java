package com.yp.crm.settings.web.contrller;
/**
 * @author pan
 * @date 2022/2/16 19:33
 */

import com.yp.crm.utils.MD5Util;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName : com.yp.crm.settings.web.contrller.UserController
 * @Description : 类描述
 * @author pan
 * @date 2022/2/16 19:33
 */
public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //模板模式
        System.out.println("进入到用户控制器");
        String path = request.getServletPath();
        
        if("/settings/user/login.do".equals(path)){
            login(request, response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进入到验证登录操作");

        //在请求与中获得账号和面
        String loginAct=request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
        //将密码进行MD5加密
        loginPwd = MD5Util.getMD5(loginPwd);
    }
}
