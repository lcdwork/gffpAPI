package com.example.demo.action;

import com.example.demo.domain.Data;
import com.example.demo.domain.PhotovoltaicPower;
import com.example.demo.tools.HttpTools;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PhotovoltaicPowerAction {
    @RequestMapping("/putPhotovoltaicPower")
    public String putPhotovoltaicPower() {
        String url = "http://211.160.73.240:19018/gffp/pv/data/push";
        // String url = "http://127.0.0.1:8000/test";
        // TOKEN由单独方法获取
        String token = "718f04ced8f5925f2963b022697e11e7";

        PhotovoltaicPower photovoltaicPower = new PhotovoltaicPower();
        photovoltaicPower.PROVINCE_CODE = "900090000000";
        photovoltaicPower.ENERGY_DATE = "2019-10-22 10:20:30";
        photovoltaicPower.GC_NO = "231232";
        photovoltaicPower.ORG_NO = "供电单位";
        photovoltaicPower.METER_ID = "22222";
        photovoltaicPower.METER_TYPE = "01";
        photovoltaicPower.P1 = "10";
        photovoltaicPower.P2 = "10";
        photovoltaicPower.P3 = "10";
        photovoltaicPower.P4 = "10";
        photovoltaicPower.P5 = "10";
        photovoltaicPower.P6 = "10";
        photovoltaicPower.P6 = "10";
        photovoltaicPower.P7 = "10";
        photovoltaicPower.P8 = "10";
        photovoltaicPower.P9 = "10";
        photovoltaicPower.P10 = "10";
        photovoltaicPower.P11 = "10";
        photovoltaicPower.P12 = "10";
        photovoltaicPower.P13 = "10";
        photovoltaicPower.P14 = "10";
        photovoltaicPower.P15 = "10";
        photovoltaicPower.P16 = "10";
        photovoltaicPower.P17 = "10";
        photovoltaicPower.P18 = "10";
        photovoltaicPower.P19 = "10";
        photovoltaicPower.P20 = "10";
        photovoltaicPower.P21 = "10";
        photovoltaicPower.P22 = "10";
        photovoltaicPower.P23 = "10";
        photovoltaicPower.P24 = "10";

        List<PhotovoltaicPower> sList = new ArrayList<>();
        sList.add(photovoltaicPower);

        // DATA数据
        Data data =new Data();
        data.TOKEN = token;
        data.DATA_COUNT = "1";
        data.DATA_LIST = sList;

        String res = HttpTools.postData(url, data);
        System.out.println(res);
        return res;
    }
}
