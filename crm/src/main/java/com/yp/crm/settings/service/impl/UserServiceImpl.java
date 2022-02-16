package com.yp.crm.settings.service.impl;
/**
 * @author pan
 * @date 2022/2/16 20:06
 */


import com.yp.crm.settings.dao.UserDao;
import com.yp.crm.settings.domain.User;
import com.yp.crm.settings.exception.LoginException;
import com.yp.crm.settings.service.UserService;
import com.yp.crm.utils.DateTimeUtil;
import com.yp.crm.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : com.yp.crm.settings.service.impl.UserServiceImpl
 * @Description : 类描述
 * @author pan
 * @date 2022/2/16 20:06
 */
public class UserServiceImpl implements UserService {
   private UserDao userDao= SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    @Override
    public User login(String loginAct, String loginPwd, String ip) throws LoginException {

       Map<String, String> map = new HashMap<>();
       map.put("loginAct", loginAct);
       map.put("loginPwd", loginPwd);

       User user =userDao.login(map);

       if(user == null){
           throw new LoginException("账号密码错误");
       }
       //如果程序运行到此处说明账户密码是正确豆的，则还需要验证以下三项
       //1、验证失效时间

       String expireTime = user.getExpireTime();
        System.out.println(expireTime);
       String currentTime = DateTimeUtil.getSysTime();
       if(expireTime.compareTo(currentTime) < 0){
            throw new LoginException("账号已失效");
       }

       //判断账号状态
       String lockState = user.getLockState();
       if("0".equals(lockState)){
           throw  new LoginException("账号已锁定");
       }


//       //判断IP地址 0:0:0:0:0:0:0:1
//       String allowIp = user.getAllowIps();
//        System.out.println(allowIp);
//        System.out.println(ip);
//
//       if(!allowIp.contains(ip)){
//           throw new LoginException("ip不允许");
//       }


        return user;
    }
}
