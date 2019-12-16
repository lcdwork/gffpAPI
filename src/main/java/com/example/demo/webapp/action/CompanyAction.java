package com.example.demo.webapp.action;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.webapp.domain.Data;
import com.example.demo.webapp.domain.Company;
import com.example.demo.tools.HttpTools;
import com.example.demo.webapp.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CompanyAction {

    @Autowired
    @Qualifier("companyServiceImpl")
    private ICompanyService companyService;

    @Value("${company.url}")
    public String url;

    @Value("${token}")
    public String token;

//    @Scheduled(cron = "${company.cron}")
    public String putMonthBill() {

        Company company = new Company();
        company.setOrgNo("11224411");
        company.setOrgName("1");
        company.setpOrgNo("23456");
        company.setOrgType("01");
        company.setSortNo("12");
        company.setOrgProperty("01");
        company.setOrgShorthand("DW");

        List<Company> dataList = new ArrayList<>();
        dataList.add(company);
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
