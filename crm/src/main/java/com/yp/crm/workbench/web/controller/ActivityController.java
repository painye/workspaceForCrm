package com.yp.crm.workbench.web.controller;
/**
 * @author pan
 * @date 2022/2/17 16:04
 */

import com.yp.crm.settings.domain.User;
import com.yp.crm.settings.service.UserService;
import com.yp.crm.settings.service.impl.UserServiceImpl;
import com.yp.crm.utils.PrintJson;
import com.yp.crm.utils.ServiceFactory;
import com.yp.crm.utils.TransactionInvocationHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName : com.yp.crm.workbench.web.controller.ActivityConmtroller
 * @Description : s晒场活动控制器
 * @author pan
 * @date 2022/2/17 16:04
 */
public class ActivityController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入市场活动控制器");

        String path = request.getServletPath();

        if("/workbench/activity/getUserList.do".equals(path)){
            getUserList(request, response);

        }else if("/workbench/activity/xxx.do".equals(path)){

        }
    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) {
        //为service层创建代理
        UserService us =(UserService) ServiceFactory.getService(new UserServiceImpl());
        List<User> users =  us.getUserList();
        PrintJson.printJsonObj(response, users);
    }
}
