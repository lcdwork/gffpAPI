package com.example.demo.action;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Data;
import com.example.demo.domain.Billmonth;
import com.example.demo.tools.HttpTools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BillmonthAction {

    @Value("${token}")
    public String token;

    @RequestMapping("/putMonthBill")
    public String putMonthBill() {
        String url = "http://211.160.73.240:19018/gffp/pv/data/billmonth";

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
