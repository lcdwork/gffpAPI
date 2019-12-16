package com.example.demo.webapp.action;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.webapp.domain.Data;
import com.example.demo.webapp.domain.Electricityday;
import com.example.demo.tools.HttpTools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ElectricitydayAciton {

    @Value("${electricityday.url}")
    public String url;

    @Value("${token}")
    public String token;

//    @Scheduled(cron = "${electricityday.cron}")
    public String putStation() {

        Electricityday electricityday = new Electricityday();
        electricityday.setProvinceCode("7275257272");
        electricityday.setGcNo("11224411");
        electricityday.setEnergyDate("2019-10-22");
        electricityday.setPurPq("20.22");
        electricityday.setGraPq("33.23");

        List<Electricityday> dataList = new ArrayList<>();
        dataList.add(electricityday);
        String jsonDataList = JSONObject.toJSONString(dataList);

        // DATA数据
        Data data =new Data();
        data.setToken(token);
        data.setDataCount(1);
        data.setDataList(jsonDataList);

        String res = HttpTools.postData(url, data);
        System.out.println(res);
        return res;
    }
}
