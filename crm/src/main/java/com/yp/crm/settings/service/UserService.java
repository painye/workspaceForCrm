package com.yp.crm.settings.service;

import com.yp.crm.settings.domain.User;
import com.yp.crm.exception.LoginException;

/**
 * @author pan
 * @date 2022/2/16 19:55
 */
public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;
}
