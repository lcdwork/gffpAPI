package com.example.demo.action;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Data;
import com.example.demo.domain.Company;
import com.example.demo.tools.HttpTools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@RestController
@Component
public class CompanyAction {

    @Value("${token}")
    public String token;

    @Scheduled(cron = "${scheduleTask.companyCron}")
    public String putMonthBill() {
        String url = "http://211.160.73.240:19018/gffp/pv/data/company";

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
