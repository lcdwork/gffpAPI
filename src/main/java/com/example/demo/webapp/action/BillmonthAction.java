package com.example.demo.webapp.action;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.webapp.domain.Data;
import com.example.demo.webapp.domain.Billmonth;
import com.example.demo.tools.HttpTools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BillmonthAction {

    @Value("${billmonth.url}")
    public String url;

    @Value("${token}")
    public String token;

//    @Scheduled(cron = "${billmonth.cron}")
    public String putMonthBill() {

        Billmonth billmonth = new Billmonth();
        billmonth.setPayInfoId("111111");
        billmonth.setCalcId("111111");
        billmonth.setAmtSort("01");
        billmonth.setPayYm("2019-10");
        billmonth.setGcNo("11224411");
        billmonth.settPurPq("20.22");
        billmonth.settGraPq("20.22");
        billmonth.setPayAmt("33.33");
        billmonth.setPayPurAmt("23.23");
        billmonth.setPayGraAmt("23.23");
        billmonth.setPaiedPurAmt("23.23");
        billmonth.setParedGraAmt("23.23");
        billmonth.setPurTaxAmt("23.23");
        billmonth.setGraTaxAmt("23.23");
        billmonth.setTaxAmt("23.23");
        billmonth.setOweAmt("23.23");
        billmonth.setReleaseDate("2019-10-22");
        billmonth.setSettleFlag("01");
        billmonth.setPeintMark("01");
        billmonth.setBatchId("22");
        billmonth.setStatusCode("01");

        List<Billmonth> dataList = new ArrayList<>();
        dataList.add(billmonth);
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
