package com.yp.crm.utils;
/**
 * @author pan
 * @date 2022/2/16 20:11
 */

import java.util.UUID;

/**
 * @ClassName : com.yp.crm.utils.UUIDUtil
 * @Description : 创建Id
 * @author pan
 * @date 2022/2/16 20:11
 */
public class UUIDUtil {
    public static String getUUID(){

        return UUID.randomUUID().toString().replaceAll("-","");

    }
}
