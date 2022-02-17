package com.yp.crm.settings.dao;
/**
 * @author pan
 * @date 2022/2/16 20:22
 */

import com.yp.crm.settings.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @ClassName : com.yp.crm.settings.dao.UserDao
 * @Description : 类描述
 * @author pan
 * @date 2022/2/16 20:22
 */
public interface UserDao {
    public User login(Map<String, String> map);

    List<User> getUserList();
}
