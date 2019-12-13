package com.example.demo.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.collect.monitor.utils.DESUtils;
import com.example.demo.domain.Base;
import com.example.demo.domain.Data;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.HashMap;

public class HttpTools {
    public static String regionId = "900090000000";
    public static String regionKey = "90009";
    public static String secretKey = "FPDDSZJR";
    // 推送数据方法
    public static String postData(String url, Data data) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // REGION_ID、REGION_KEY均由接口提供方提供
//        String regionId = "900090000000";
//        String regionKey = "90009";
//        String secretKey = "FPDDSZJR";

        Base base = new Base();
        base.setRegionId(regionId);
        base.setTimeStamp(System.currentTimeMillis()/1000+"");


        String encryptDataStr = DESUtils.encrypt(JSONObject.toJSONString(data), secretKey);
        String decryptDateStr = DESUtils.decrypt(encryptDataStr, secretKey);
        System.out.println(decryptDateStr);

        base.setData(encryptDataStr);
        StringBuilder sb = new StringBuilder();
        sb.append(base.getRegionId());
        sb.append(base.getTimeStamp());
        sb.append(base.getData());
        sb.append(regionKey);
        String cSign = DigestUtils.sha256Hex(sb.toString());
        base.setSign(cSign);
        String json = JSONObject.toJSONString(base);
        System.out.println(json);
        try {
            HttpEntity<String> request = new HttpEntity<>(json, headers);
            ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
            // ResponseEntity<Map> response = restTemplate.postForEntity( url, request , Map.class );
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }
    // 获取token方法
    public static String getToken() {
        String url = "http://211.160.73.240:19018/gffp/pv/data/gettoken";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Base base = new Base();
        base.setRegionId(regionId);
        base.setTimeStamp(System.currentTimeMillis()/1000+"");

        HashMap<String, String> map= new HashMap<String, String>();
        map.put("REGION_KEY",regionKey);

        base.setData(JSON.toJSONString(map));
        StringBuilder sb = new StringBuilder();
        sb.append(base.getRegionId());
        sb.append(base.getTimeStamp());
        sb.append(base.getData());
        sb.append(regionKey);
        String cSign = DigestUtils.sha256Hex(sb.toString());
        base.setSign(cSign);
        String json = JSONObject.toJSONString(base);
        System.out.println(json);
        try {
            HttpEntity<String> request = new HttpEntity<>(json, headers);
            ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return "{\"resCode\":\"抛出异常\",\"resMsg\":" + e.toString() + ",\"resTime\":"+sdf.format(System.currentTimeMillis())+"}";
        }
    }
}
