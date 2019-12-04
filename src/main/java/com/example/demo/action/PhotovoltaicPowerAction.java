package com.example.demo.action;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Data;
import com.example.demo.domain.PhotovoltaicPower;
import com.example.demo.tools.HttpTools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PhotovoltaicPowerAction {

    @Value("${token}")
    public String token;

    @RequestMapping("/putPhotovoltaicPower")
    public String putPhotovoltaicPower() {
        String url = "http://211.160.73.240:19018/gffp/pv/data/push";

        PhotovoltaicPower photovoltaicPower = new PhotovoltaicPower();
        photovoltaicPower.setProvinceCode("900090000000");
        photovoltaicPower.setEnergyDate("2019-10-22 10:20:30");
        photovoltaicPower.setGcNo("231232");
        photovoltaicPower.setOrgNo("231232");
        photovoltaicPower.setMeterId("231232");
        photovoltaicPower.setMeterType("01");
        photovoltaicPower.setP1("20");
        photovoltaicPower.setP2("20");
        photovoltaicPower.setP3("20");
        photovoltaicPower.setP4("20");
        photovoltaicPower.setP5("20");
        photovoltaicPower.setP6("20");
        photovoltaicPower.setP7("20");
        photovoltaicPower.setP8("20");
        photovoltaicPower.setP9("20");
        photovoltaicPower.setP10("20");
        photovoltaicPower.setP11("20");
        photovoltaicPower.setP12("20");
        photovoltaicPower.setP13("20");
        photovoltaicPower.setP14("20");
        photovoltaicPower.setP15("20");
        photovoltaicPower.setP16("20");
        photovoltaicPower.setP17("20");
        photovoltaicPower.setP18("20");
        photovoltaicPower.setP19("20");
        photovoltaicPower.setP20("20");
        photovoltaicPower.setP21("20");
        photovoltaicPower.setP22("20");
        photovoltaicPower.setP23("20");
        photovoltaicPower.setP24("20");

        List<PhotovoltaicPower> dataList = new ArrayList<>();
        dataList.add(photovoltaicPower);
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
