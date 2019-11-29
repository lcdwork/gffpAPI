package com.example.demo.action;

import com.example.demo.domain.Data;
import com.example.demo.domain.PowerSupply;
import com.example.demo.tools.HttpTools;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PowerSupplyAction {
    @RequestMapping("/putPowerSupply")
    public String putMonthBill() {
        String url = "http://211.160.73.240:19018/gffp/pv/data/push";
        // String url = "http://127.0.0.1:8000/test";

        // TOKEN由单独方法获取
        String token = "718f04ced8f5925f2963b022697e11e7";

        PowerSupply powerSupply = new PowerSupply();
        powerSupply.ORG_NO = "022321";
        powerSupply.ORG_NAME = "NAOE";
        powerSupply.P_ORG_NO = "NAME";
        powerSupply.ORG_TYPE = "01";
        powerSupply.ORG_PROPERTY = "01";
        powerSupply.ORG_SHORTHAND = "DW";

        List<PowerSupply> sList = new ArrayList<>();
        sList.add(powerSupply);

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
