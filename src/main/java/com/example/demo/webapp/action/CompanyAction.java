package com.example.demo.webapp.action;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.tools.HandleTools;
import com.example.demo.webapp.domain.Company;
import com.example.demo.webapp.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;

@ControllerAdvice
public class CompanyAction {

    @Autowired
    @Qualifier("companyServiceImpl")
    private ICompanyService companyService;

    @Value("${company.url}")
    public String url;

//    @Scheduled(cron = "${company.cron}")
    public void putMonthBill() {

        List<Company> dataList = companyService.findByWhere(null);
        String jsonDataList = JSONObject.toJSONString(dataList);

        HandleTools.putData(url,dataList.size(),jsonDataList);
    }
}
