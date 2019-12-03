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

        String json = null;
        if (data.length == 0) {
            // DATA数据格式
            HashMap<String, String> map= new HashMap<String, String>();
            map.put("REGION_KEY",regionKey);

            Base base = new Base();
            base.setRegionId(regionId);
            base.setTimeStamp(System.currentTimeMillis()/1000+"");
            base.setData(JSON.toJSONString(map));

            StringBuilder sb = new StringBuilder();
            sb.append(base.getRegionId());
            sb.append(base.getTimeStamp());
            sb.append(base.getData());
            sb.append(regionKey);
            String cSign = DigestUtils.sha256Hex(sb.toString());
            base.setSign(cSign);
            json = JSONObject.toJSONString(base);
            System.out.print(json);
        } else {
            String encryptDataStr = DESUtils.encrypt(JSONObject.toJSONString(data), secretKey);
            String decryptDateStr = DESUtils.decrypt(encryptDataStr, secretKey);
            System.out.println(decryptDateStr);

            Base base = new Base();
            base.setRegionId(regionId);
            base.setTimeStamp(System.currentTimeMillis()/1000+"");
            base.setData(encryptDataStr);

            StringBuilder sb = new StringBuilder();
            sb.append(base.getRegionId());
            sb.append(base.getTimeStamp());
            sb.append(base.getData());
            sb.append(regionKey);
            String cSign = DigestUtils.sha256Hex(sb.toString());
            base.setSign(cSign);
            json = JSONObject.toJSONString(base);
            System.out.print(json);
        }
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
}
