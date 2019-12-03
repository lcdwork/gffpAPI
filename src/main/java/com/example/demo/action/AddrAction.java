package com.example.demo.action;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Addr;
import com.example.demo.domain.Data;
import com.example.demo.domain.Station;
import com.example.demo.tools.HttpTools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AddrAction {

    @Value("${token}")
    public String token;

    @RequestMapping("/putAddr")
    public String putAddr() {
        String url = "http://211.160.73.240:19018/gffp/pv/data/addrmsg";

        Addr addr = new Addr();
        addr.setGcaId("1111111");
        addr.setGcNo("111111");
        addr.setCountyName("山东省");
        addr.setCityName("XX市");
        addr.setCountyName("XX区");
        addr.setStreetName("XX街道");
        addr.setVillageName("01");
        addr.setPosX("120.222222");
        addr.setPosY("22.222222");
        addr.setPosZ("88.2222");

        List<Addr> dataList = new ArrayList<>();
        dataList.add(addr);
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
