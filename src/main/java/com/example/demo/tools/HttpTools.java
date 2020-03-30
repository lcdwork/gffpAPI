package com.example.demo.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.collect.monitor.utils.DESUtils;
import com.example.demo.configurationFile.ConfigurationProperties;
import com.example.demo.webapp.domain.Base;
import com.example.demo.webapp.domain.Data;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class HttpTools {

    // 推送数据方法
    @Retryable
    public static String postData(String url, Data data) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Base base = new Base();
        base.setRegionId(ConfigurationProperties.regionId);
        base.setTimeStamp(System.currentTimeMillis()/1000+"");

        String encryptDataStr = DESUtils.encrypt(JSONObject.toJSONString(data), ConfigurationProperties.secretKey);
        String decryptDateStr = DESUtils.decrypt(encryptDataStr, ConfigurationProperties.secretKey);
//        System.out.println(decryptDateStr);

        base.setData(encryptDataStr);
        StringBuilder sb = new StringBuilder();
        sb.append(base.getRegionId());
        sb.append(base.getTimeStamp());
        sb.append(base.getData());
        sb.append(ConfigurationProperties.regionKey);
        String cSign = DigestUtils.sha256Hex(sb.toString());
        base.setSign(cSign);
        String json = JSONObject.toJSONString(base);
        try {
             HttpEntity<String> request = new HttpEntity<>(json, headers);
             ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
            // ResponseEntity<Map> response = restTemplate.postForEntity( url, request , Map.class );
             return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
//            return e.toString();
            return null;
        }
    }
    // 获取token方法
    @Retryable
    public static String getToken() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Base base = new Base();
        base.setRegionId(ConfigurationProperties.regionId);
        base.setTimeStamp(System.currentTimeMillis()/1000+"");

        HashMap<String, String> map= new HashMap<String, String>();
        map.put("REGION_KEY", ConfigurationProperties.regionKey);

        base.setData(JSON.toJSONString(map));
        StringBuilder sb = new StringBuilder();
        sb.append(base.getRegionId());
        sb.append(base.getTimeStamp());
        sb.append(base.getData());
        sb.append(ConfigurationProperties.regionKey);
        String cSign = DigestUtils.sha256Hex(sb.toString());
        base.setSign(cSign);
        String json = JSONObject.toJSONString(base);
        try {
            HttpEntity<String> request = new HttpEntity<>(json, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(ConfigurationProperties.tokenUrl, request , String.class );
            JSONObject jsonObject = JSON.parseObject(response.getBody());
            if(jsonObject.getString("resCode").equals("0000")) {
                return jsonObject.getJSONObject("resData").getString("token");
            }else {
                throw new Exception(response.getBody());
            }
            // return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // String res = "{\"resCode\":\"抛出异常\",\"resMsg\":" + e.toString() + ",\"resTime\":"+sdf.format(System.currentTimeMillis())+"}";
            return null;
        }
    }
}
