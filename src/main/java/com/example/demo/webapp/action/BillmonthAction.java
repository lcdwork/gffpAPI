package com.example.demo.webapp.action;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.tools.HandleTools;
import com.example.demo.webapp.domain.Billmonth;
import com.example.demo.webapp.service.IBillmonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;

@ControllerAdvice
public class BillmonthAction {

    @Autowired
    @Qualifier("billmonthServiceImpl")
    private IBillmonthService billmonthService;

    @Value("${billmonth.url}")
    public String url;

//    @Scheduled(cron = "${billmonth.cron}")
    public void putMonthBill() {

        List<Billmonth> dataList = billmonthService.findByWhere(null);
        String jsonDataList = JSONObject.toJSONString(dataList);

        if(dataList.size()>0){
            HandleTools.putData(url,dataList.size(),jsonDataList);
        }    }
}
