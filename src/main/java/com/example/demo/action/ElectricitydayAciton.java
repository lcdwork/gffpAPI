package com.example.demo.action;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Data;
import com.example.demo.domain.Electricityday;
import com.example.demo.tools.HttpTools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ElectricitydayAciton {

    @Value("${token}")
    public String token;

    @RequestMapping("/putPhotovoltaic")
    public String putStation() {
        String url = "http://211.160.73.240:19018/gffp/pv/data/electricityday";

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
