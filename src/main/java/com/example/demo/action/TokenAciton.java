package com.example.demo.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.tools.HttpTools;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenAciton {
    @RequestMapping("/getToken")
    public String getToken(){

        String res = HttpTools.getToken();
        System.out.println(res);
        JSONObject jsonObject = JSON.parseObject(res);
        if(jsonObject.getString("resCode").equals("0000")) {
            System.out.println(jsonObject.getJSONObject("resData").getString("token"));
        }else {
            System.out.println(res);
        }
        return res;
    }
}
