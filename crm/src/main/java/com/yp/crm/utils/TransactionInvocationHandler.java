package com.yp.crm.utils;
/**
 * @author pan
 * @date 2022/2/16 14:22
 */

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName : com.yp.crm.utils.TransactionInvocationHandler
 * @Description : 使用动态代理创建dao接口的实现类
 *          动态代理的结构是主要有一个接口叫做 InvocationHandler接口，其中的方法invoke可以做功能增强
 *                      invoke(proxy, method, args)
 *
 * @author pan
 * @date 2022/2/16 14:22
 */
public class TransactionInvocationHandler implements InvocationHandler {
    private Object target;

    public TransactionInvocationHandler(Object target){
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession sqlSession = null;
        Object  obj = null;

        try{
            sqlSession = SqlSessionUtil.getSqlSession();
            //实现目标类的方法
            obj = method.invoke(target, args);
            //做功能增强,提交事务
            sqlSession.commit();
        }catch(Exception e){
            sqlSession.rollback();
            e.printStackTrace();

            //注意这里加入这个是为了防止目标类的异常被代理类捕获，所以需要再一次抛出已捕捉到的异常
            throw e.getCause();
        }finally {
            SqlSessionUtil.myClose(sqlSession);
        }

        return obj;
    }


    public Object getProxy(){

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), this );
    }
}
