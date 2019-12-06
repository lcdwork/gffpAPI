package com.example.demo.action;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Data;
import com.example.demo.domain.Station;
import com.example.demo.tools.HttpTools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class StationAction {

    @Value("${token}")
    public String token;

    @RequestMapping("/putStation")
    public String putStation() {
        String url = "http://211.160.73.240:19018/gffp/pv/data/stationmsg";

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Station station = new Station();
        station.setGcNo("11224411");
        station.setGcId("1111311");
        station.setContractCap("20.00");
        station.setVoltCode("220V");
        station.setGcDate("2019-10-11 10:20:30");
        station.setAbsoMode("01");
        station.setPovertyAllevFlag("01");
        station.setStatusCode("1");

        List<Station> dataList = new ArrayList<>();
        dataList.add(station);
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
