package com.example.demo.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.webapp.domain.Data;

public class HandleTools {
    public static String getToken(){
        String res = HttpTools.getToken();
        JSONObject jsonObject = JSON.parseObject(res);
        if(jsonObject.getString("resCode").equals("0000")) {
            return jsonObject.getJSONObject("resData").getString("token");
        }else {
            return null;
        }
    }
    public static String putData(String url, int size, String jsonDataList){
        String token = getToken();
        if(token != null) {
            System.out.println(token);
            // DATA数据
            Data data =new Data();
            data.setToken(token);
            data.setDataCount(size);
            data.setDataList(jsonDataList);
            String res = HttpTools.postData(url, data);
            System.out.println(res);
            return res;
        }else {
            System.out.println("fail");
            return null;
        }
    }
}
