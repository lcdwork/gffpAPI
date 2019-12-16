package com.example.demo.webapp.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.tools.HttpTools;
import com.example.demo.webapp.domain.Addr;
import com.example.demo.webapp.domain.Data;
import com.example.demo.webapp.service.IAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class AddrAction {

    @Autowired
    @Qualifier("addrServiceImpl")
    private IAddrService addrService;

    @Value("${addr.url}")
    public String url;

    @Scheduled(cron = "${addr.cron}")
    public void putAddr() {
        String token = null;

        List<Addr> dataList = addrService.findByWhere(null);
        String jsonDataList = JSONObject.toJSONString(dataList);


        String getToken = HttpTools.getToken();
        JSONObject jsonObject = JSON.parseObject(getToken);
        if(jsonObject.getString("resCode").equals("0000")) {
            token = jsonObject.getJSONObject("resData").getString("token");
            System.out.println(token);
            // DATA数据
            Data data =new Data();
            data.setToken(token);
            data.setDataCount(dataList.size());
            data.setDataList(jsonDataList);
            String res = HttpTools.postData(url, data);
            System.out.println(res);
        }else {
            System.out.println(getToken);
        }
    }
}
