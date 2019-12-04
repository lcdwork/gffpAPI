package com.example.demo.action;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Data;
import com.example.demo.domain.Photovoltaic;
import com.example.demo.tools.HttpTools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PhotovoltaicAciton {

    @Value("${token}")
    public String token;

    @RequestMapping("/putPhotovoltaic")
    public String putStation() {
        String url = "http://211.160.73.240:19018/gffp/pv/data/electricityday";

        Photovoltaic photovoltaic = new Photovoltaic();
        photovoltaic.setProvinceCode("7275257272");
        photovoltaic.setGcNo("11221212");
        photovoltaic.setEnergyDate("201910");
        photovoltaic.setPurPq("20.22");
        photovoltaic.setGraPq("33.23");

        List<Photovoltaic> dataList = new ArrayList<>();
        dataList.add(photovoltaic);
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
