package com.example.demo.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.collect.monitor.utils.MD5Utils;
import com.example.demo.domain.Base;
import com.example.demo.domain.Data;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;

public class HttpTools {
    public static String postData(String url, Data...data) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // REGION_ID、REGION_KEY均由接口提供方提供
        String regionId = "900090000000";
        String regionKey = "90009";
        String secretKey = "FPDDSZJR";
        Date date = new Date();

        JSONObject jsonObject = new JSONObject();
        if (data.length == 0) {
            // DATA数据格式
            HashMap<String, String> map= new HashMap<String, String>();
            map.put("REGION_KEY",regionKey);

            jsonObject.put("REGION_ID", regionId);
            jsonObject.put("DATA", map);
            jsonObject.put("TIME_STAMP", date.getTime());
            // 生成签名
            jsonObject.put("SIGN", MD5Utils.getSign(regionId,String.valueOf(date.getTime()), JSON.toJSONString(map),regionKey));
        } else {
            // BASE数据
            Base base = new Base();
            base.setREGION_ID(regionId);
            base.setTIME_STAMP(date.getTime());
            base.setDATA(data[0]);
            // 生成签名
            base.setSIGN(MD5Utils.getSign(base.getREGION_ID(),String.valueOf(date.getTime()), JSON.toJSONString(base.getDATA()),regionKey));

            jsonObject.put("REGION_ID", base.getREGION_ID());
            // jsonObject.put("DATA", DESUtils.encrypt(JSONObject.toJSONString(base.getDATA()),secretKey));
            jsonObject.put("DATA", base.getDATA());
            jsonObject.put("TIME_STAMP", base.getTIME_STAMP());
            jsonObject.put("SIGN", base.getSIGN());
        }
        System.out.println(jsonObject.toJSONString());
        HttpEntity<String> request = new HttpEntity<>(jsonObject.toJSONString(), headers);
        ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
        // ResponseEntity<Map> response = restTemplate.postForEntity( url, request , Map.class );
        return response.getBody();
    }
}
