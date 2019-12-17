package com.example.demo.webapp.action;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.tools.HandleTools;
import com.example.demo.webapp.domain.Electricityday;
import com.example.demo.webapp.service.IElectricitydayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;

@ControllerAdvice
public class ElectricitydayAciton {

    @Autowired
    @Qualifier("electricitydayServiceImpl")
    private IElectricitydayService electricitydayService;

    @Value("${electricityday.url}")
    public String url;

//    @Scheduled(cron = "${electricityday.cron}")
    public void putStation() {

        List<Electricityday> dataList = electricitydayService.findByWhere(null);
        String jsonDataList = JSONObject.toJSONString(dataList);

        if(dataList.size()>0){
            HandleTools.putData(url,dataList.size(),jsonDataList);
        }
    }
}
