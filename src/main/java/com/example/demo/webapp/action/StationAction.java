package com.example.demo.webapp.action;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.tools.HandleTools;
import com.example.demo.webapp.domain.Station;
import com.example.demo.webapp.service.IStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;

@ControllerAdvice
public class StationAction {

    @Autowired
    @Qualifier("stationServiceImpl")
    private IStationService stationService;

    @Value("${station.url}")
    public String url;

//    @Scheduled(cron = "${station.cron}")
    public void putStation() {

        List<Station> dataList = stationService.findByWhere(null);
        String jsonDataList = JSONObject.toJSONString(dataList);

        HandleTools.putData(url,dataList.size(),jsonDataList);
    }
}
