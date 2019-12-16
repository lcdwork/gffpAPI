package com.example.demo.action;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Data;
import com.example.demo.domain.Electricityhour;
import com.example.demo.tools.HttpTools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ElectricityhourAction {

    @Value("${electricityhour.url}")
    public String url;

    @Value("${token}")
    public String token;

//    @Scheduled(cron = "${electricityhour.cron}")
    public String putPhotovoltaicPower() {

        Electricityhour Electricityhour = new Electricityhour();
        Electricityhour.setProvinceCode("900090000000");
        Electricityhour.setDataDate("2019-10-22 10:20:30");
        Electricityhour.setGcNo("11224411");
        Electricityhour.setOrgNo("231232");
        Electricityhour.setMeterId("231232");
        Electricityhour.setMeterType("01");
        Electricityhour.setP1("20");
        Electricityhour.setP2("20");
        Electricityhour.setP3("20");
        Electricityhour.setP4("20");
        Electricityhour.setP5("20");
        Electricityhour.setP6("20");
        Electricityhour.setP7("20");
        Electricityhour.setP8("20");
        Electricityhour.setP9("20");
        Electricityhour.setP10("20");
        Electricityhour.setP11("20");
        Electricityhour.setP12("20");
        Electricityhour.setP13("20");
        Electricityhour.setP14("20");
        Electricityhour.setP15("20");
        Electricityhour.setP16("20");
        Electricityhour.setP17("20");
        Electricityhour.setP18("20");
        Electricityhour.setP19("20");
        Electricityhour.setP20("20");
        Electricityhour.setP21("20");
        Electricityhour.setP22("20");
        Electricityhour.setP23("20");
        Electricityhour.setP24("20");

        List<Electricityhour> dataList = new ArrayList<>();
        dataList.add(Electricityhour);
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
