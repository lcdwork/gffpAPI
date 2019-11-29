package com.example.demo.action;

import com.example.demo.domain.Data;
import com.example.demo.domain.Photovoltaic;
import com.example.demo.tools.HttpTools;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PhotovoltaicAciton {
    @RequestMapping("/putPhotovoltaic")
    public String putStation() {
        String url = "http://211.160.73.240:19018/gffp/pv/data/push";
        // String url = "http://127.0.0.1:8000/test";

        // TOKEN由单独方法获取
        String token = "718f04ced8f5925f2963b022697e11e7";

        Photovoltaic photovoltaic = new Photovoltaic();
        photovoltaic.PROVINCE_CODE = "7275257272";
        photovoltaic.ENERGY_DATE = "201910";
        photovoltaic.GC_NO = "11221212";
        photovoltaic.PUR_PQ = 10.00;
        photovoltaic.GRA_PQ = 20.00;

        List<Photovoltaic> sList = new ArrayList<>();
        sList.add(photovoltaic);

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
