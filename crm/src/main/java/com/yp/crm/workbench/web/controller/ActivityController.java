package com.yp.crm.workbench.web.controller;
/**
 * @author pan
 * @date 2022/2/17 16:04
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        if("/workbench/activity/xxx.do".equals(path)){

        }else if("/workbench/activity/xxx.do".equals(path)){

        }
    }
}
