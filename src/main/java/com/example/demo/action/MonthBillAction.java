package com.example.demo.action;

import com.example.demo.domain.Data;
import com.example.demo.domain.MonthBill;
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
        // String url = "http://127.0.0.1:8000/test";

        MonthBill monthBill = new MonthBill();
        monthBill.PAY_INFO_ID = 100L;
        monthBill.CALC_ID = 100L;
        monthBill.AMT_SORT = "01";
        monthBill.PAY_YM = "201910";
        monthBill.GC_NO = "22222";
        monthBill.T_PUR_PQ = 20.00;
        monthBill.T_GRA_PQ = 200.00;
        monthBill.PAY_AMT = 120.00;
        monthBill.PAY_PUR_AMT = 120.00;
        monthBill.PAY_GRA_AMT = 120.00;
        monthBill.PAIED_PUR_AMT = 120.00;
        monthBill.PAIED_GRA_AMT = 120.00;
        monthBill.PUR_TAX_AMT = 120.00;
        monthBill.GRA_TAX_AMT = 120.00;
        monthBill.TAX_AMT = 120.00;
        monthBill.OWE_AMT = 120.00;
        monthBill.RELEASE_DATE = "2019-10-22";
        monthBill.SETTLE_FLAG = "01";
        monthBill.PRINT_MARK = "01";
        monthBill.STATUS_CODE = "01";

        List<MonthBill> sList = new ArrayList<>();
        sList.add(monthBill);

        // DATA数据
        Data data =new Data();
        data.TOKEN = token;
        data.DATA_COUNT = "1";
        data.DATA_LIST = sList;

        String res = HttpTools.postData(url, data);
        System.out.println(res);
        return res;
    }
}
