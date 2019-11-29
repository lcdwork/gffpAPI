package com.example.demo.action;

import com.example.demo.domain.Addr;
import com.example.demo.domain.Data;
import com.example.demo.tools.HttpTools;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AddrAction {
    @RequestMapping("/putAddr")
    public String putAddr() {
        String url = "http://211.160.73.240:19018/gffp/pv/data/addrmsg";
        // String url = "http://127.0.0.1:8000/test";
        // TOKEN由单独方法获取
        String token = "718f04ced8f5925f2963b022697e11e7";

        Addr addr = new Addr();
        addr.GCA_ID = 900090000000L;
        addr.GC_NO = 129786L;
        addr.PROVINCE_NAME = "XX省";
        addr.CITY_NAME = "XX市";
        addr.COUNTY_NAME = "XX县";
        addr.STREET_NAME = "XX街道";
        addr.VILLAGE_NAME = "XX村";
        addr.POS_X = "120.22222";
        addr.POS_Y = "33.22222";
        addr.POS_Z = "100";

        List<Addr> sList = new ArrayList<>();
        sList.add(addr);

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
