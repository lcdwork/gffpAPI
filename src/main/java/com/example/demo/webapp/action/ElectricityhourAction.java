package com.example.demo.webapp.action;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.tools.HandleTools;
import com.example.demo.webapp.domain.Electricityhour;
import com.example.demo.webapp.service.IElectricityhourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ElectricityhourAction {

    @Autowired
    @Qualifier("electricityhourServiceImpl")
    private IElectricityhourService electricityhourService;

    @Value("${electricityhour.url}")
    public String url;

//    @Scheduled(cron = "${electricityhour.cron}")
    public void putPhotovoltaicPower() {

        List<Electricityhour> dataList = electricityhourService.findByWhere(null);
        String jsonDataList = JSONObject.toJSONString(dataList);

        HandleTools.putData(url,dataList.size(),jsonDataList);
    }
}
