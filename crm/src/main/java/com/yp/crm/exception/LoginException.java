package com.yp.crm.exception;
/**
 * @author pan
 * @date 2022/2/16 20:33
 */

/**
 * @ClassName : com.yp.crm.exception.LoginException
 * @Description : 该类是表示登陆中出现的异常
 * @author pan
 * @date 2022/2/16 20:33
 */
public class LoginException extends Exception{
    public LoginException(String msg){
        super(msg);
    }
}
