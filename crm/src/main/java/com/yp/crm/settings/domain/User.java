package com.yp.crm.settings.domain;
/**
 * @author pan
 * @date 2022/2/16 14:06
 */

import lombok.Data;

/**
 * @ClassName : com.yp.crm.settings.domain.User
 * @Description : 类描述
 * @author pan
 * @date 2022/2/16 14:06
 */

@Data
public class User {
    String id ;
    String loginAct;
    String name ;
    String loginPwd;
    String email;
    String expireTime;
    String lockState;
    String deptNo;
    String allowIps;
    String createTime;
    String createBy;
    String editTime;
    String editBy;

}
