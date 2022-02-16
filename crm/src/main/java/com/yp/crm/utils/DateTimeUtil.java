package com.yp.crm.utils;
/**
 * @author pan
 * @date 2022/2/16 14:10
 */

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName : com.yp.crm.utils.DateTimeUtil
 * @Description : 类描述
 * @author pan
 * @date 2022/2/16 14:10
 */
public class DateTimeUtil {

    //按照指定格式获取当前系统时间

    public static String getSysTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String dateStr = sdf.format(date);

        return dateStr;
    }
}
