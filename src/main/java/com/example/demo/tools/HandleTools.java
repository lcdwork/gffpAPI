package com.example.demo.tools;

import com.example.demo.webapp.domain.Data;

public class HandleTools {
    public static HttpTools httpTools = new HttpTools();
    public static String putData(String url, int size, String jsonDataList){

        String token = httpTools.getToken();
        if(token != null) {
//            System.out.println(token);
            // DATA数据
            Data data =new Data();
            data.setToken(token);
            data.setDataCount(size);
            data.setDataList(jsonDataList);
            String res = httpTools.postData(url, data);
//            System.out.println(res);
            if(res != null) {
                return res;
            }
        }

        return null;
    }
}
