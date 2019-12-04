package com.example.demo.action;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Data;
import com.example.demo.domain.PowerSupply;
import com.example.demo.tools.HttpTools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PowerSupplyAction {

    @Value("${token}")
    public String token;

    @RequestMapping("/putPowerSupply")
    public String putMonthBill() {
        String url = "http://211.160.73.240:19018/gffp/pv/data/push";

        PowerSupply powerSupply = new PowerSupply();
        powerSupply.setOrgNo("022321");
        powerSupply.setOrgName("1");
        powerSupply.setpOrgNo("23456");
        powerSupply.setOrgType("01");
        powerSupply.setSortNo("01");
        powerSupply.setOrgProperty("01");
        powerSupply.setOrgShorthand("DW");

        List<PowerSupply> dataList = new ArrayList<>();
        dataList.add(powerSupply);
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
