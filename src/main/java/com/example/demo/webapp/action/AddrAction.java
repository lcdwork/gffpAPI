package com.example.demo.webapp.action;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.tools.HandleTools;
import com.example.demo.webapp.domain.Addr;
import com.example.demo.webapp.service.IAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;

@ControllerAdvice
public class AddrAction {

    @Autowired
    @Qualifier("addrServiceImpl")
    private IAddrService addrService;

    @Value("${addr.url}")
    public String url;

//    @Scheduled(cron = "${addr.cron}")
    public void putAddr() {

        List<Addr> dataList = addrService.findByWhere(null);
        String jsonDataList = JSONObject.toJSONString(dataList);

        HandleTools.putData(url,dataList.size(),jsonDataList);
    }
}
