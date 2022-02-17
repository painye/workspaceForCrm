package com.yp.crm.utils;
/**
 * @author pan
 * @date 2022/2/16 14:16
 */

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : com.yp.crm.utils.PrintJson
 * @Description : 类描述
 * @author pan
 * @date 2022/2/16 14:16
 */
public class PrintJson {

    //将boolean值解析为json串

    public static void printJsonFlag(HttpServletResponse response, boolean flag){
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", flag);

        ObjectMapper om =new ObjectMapper();

        try {
            //{"success":true}
            String json = om.writeValueAsString(map);
            response.getWriter().print(json);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //将对象解析为json串

    public static void printJsonObj(HttpServletResponse response,Object obj){

        /*
         *
         * Person p
         * 	id name age
         * {"id":"?","name":"?","age":?}
         *
         * List<Person> pList
         * [{"id":"?","name":"?","age":?},{"id":"?","name":"?","age":?},{"id":"?","name":"?","age":?}...]
         *
         * Map
         * 	key value
         * {key:value}
         *
         *
         */

        ObjectMapper om = new ObjectMapper();
        try {
            response.setContentType("text/json;charset=utf-8");
            String json = om.writeValueAsString(obj);
            response.getWriter().print(json);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
