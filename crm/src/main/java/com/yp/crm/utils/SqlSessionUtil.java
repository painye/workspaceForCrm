package com.yp.crm.utils;
/**
 * @author pan
 * @date 2022/2/16 14:57
 */

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName : com.yp.crm.utils.SqlSessionUtil
 * @Description : 类描述
 * @author pan
 * @date 2022/2/16 14:57
 */
public class SqlSessionUtil {

    //在这里给工具类上加一个私有的构造方法是为了不让其他程序创建该对象的实例

    private SqlSessionUtil(){}

    //单例模式，整个程序只需用一个工厂

    private static SqlSessionFactory factory;

    static{
        String resources = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    private static ThreadLocal<SqlSession> t = new ThreadLocal<>();

    public static SqlSession getSqlSession(){
        SqlSession sqlSession = t.get();
        if(sqlSession == null){
            sqlSession = factory.openSession();
            t.set(sqlSession);
        }
        return sqlSession;
    }

    public static void myClose(SqlSession sqlSession){
        if(sqlSession != null){
            sqlSession.close();
        }
    }
}
