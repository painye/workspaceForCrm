package com.yp.crm.workbench.service.impl;
/**
 * @author pan
 * @date 2022/2/17 15:58
 */

import com.yp.crm.utils.SqlSessionUtil;
import com.yp.crm.utils.TransactionInvocationHandler;
import com.yp.crm.workbench.dao.ActivityDao;
import com.yp.crm.workbench.service.ActivityService;

/**
 * @ClassName : com.yp.crm.workbench.service.impl.ActivityServiceImpl
 * @Description : 类描述
 * @author pan
 * @date 2022/2/17 15:58
 */
public class ActivityServiceImpl implements ActivityService {
    //使用动态代理创建ActivityDao的实现类

    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);


}
