package com.yp.crm.settings.web.controller;
/**
 * @author pan
 * @date 2022/2/16 19:33
 */

import com.yp.crm.settings.domain.User;
import com.yp.crm.settings.service.UserService;
import com.yp.crm.settings.service.impl.UserServiceImpl;
import com.yp.crm.utils.MD5Util;
import com.yp.crm.utils.PrintJson;
import com.yp.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

        //在请求与中获得账号和密码
        String loginAct=request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
        System.out.println(loginAct+"        "+loginPwd);

        //将密码进行MD5加密
        loginPwd = MD5Util.getMD5(loginPwd);
        String ip = request.getRemoteAddr();
        System.out.println("-----------ip");

        //未来业务层的开发，统一使用代理类形态的接口对象
        UserService us =(UserService) ServiceFactory.getService(new UserServiceImpl());

        try{
            User user = us.login(loginAct, loginPwd, ip);
            //向session中传入user对象
            request.getSession().setAttribute("user", user);
            //如果程序能走到这里说明已经拿回了正确的user，则直接传入success
            PrintJson.printJsonFlag(response,true);
        }catch (Exception e){
            e.printStackTrace();
            //如果程序走到了这里就说明我们的程序没有在数据库中拿到对应的对象，说明登陆失败
            //我们需要传入失败的原因，也就是我们抛出的异常的msg
            String msg = e.getMessage();
            Map<String, Object> map=new HashMap<>();
            map.put("success", false);
            map.put("msg", msg);
            PrintJson.printJsonObj(response, map);
        }
    }
}
