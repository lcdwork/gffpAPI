package com.example.demo.action;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Data;
import com.example.demo.domain.MonthBill;
import com.example.demo.domain.Station;
import com.example.demo.tools.HttpTools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MonthBillAction {

    @Value("${token}")
    public String token;

    @RequestMapping("/putMonthBill")
    public String putMonthBill() {
        String url = "http://211.160.73.240:19018/gffp/pv/data/push";

        MonthBill monthBill = new MonthBill();
        monthBill.setPayInfoId("111111");
        monthBill.setCalcId("111111");
        monthBill.setAmtSort("01");
        monthBill.setPayYm("201910");
        monthBill.setGcNo("111111");
        monthBill.settPurPq("20.22");
        monthBill.settGraPq("20.22");
        monthBill.setPayAmt("33.33");
        monthBill.setPayPurAmt("23.23");
        monthBill.setPayGraAmt("23.23");
        monthBill.setPaiedPurAmt("23.23");
        monthBill.setParedGraAmt("23.23");
        monthBill.setPurTaxAmt("23.23");
        monthBill.setGraTaxAmt("23.23");
        monthBill.setTaxAmt("23.23");
        monthBill.setOweAmt("23.23");
        monthBill.setReleaseDate("2019-10-22");
        monthBill.setSettleFlag("01");
        monthBill.setPeintMark("01");
        monthBill.setBatchId("22");
        monthBill.setStatusCode("01");

        List<MonthBill> dataList = new ArrayList<>();
        dataList.add(monthBill);
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
