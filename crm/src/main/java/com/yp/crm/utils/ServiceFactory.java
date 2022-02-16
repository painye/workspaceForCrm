package com.yp.crm.utils;
/**
 * @author pan
 * @date 2022/2/16 20:08
 */

/**
 * @ClassName : com.yp.crm.utils.ServiceFactory
 * @Description : 为service层创建动态代理的工具类
 * @author pan
 * @date 2022/2/16 20:08
 */
public class ServiceFactory {

    public static Object getService(Object service){
        return new TransactionInvocationHandler(service).getProxy();
    }
}
