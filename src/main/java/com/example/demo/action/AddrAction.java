package com.example.demo.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Addr;
import com.example.demo.domain.Data;
import com.example.demo.tools.HttpTools;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddrAction {

    @Scheduled(cron = "${scheduleTask.addrCron}")
    public void putAddr() {
        String url = "http://211.160.73.240:19018/gffp/pv/data/addrmsg";
        String token = null;

        Addr addr = new Addr();
        addr.setGcaId("7275257272");
        addr.setGcNo("11224411");
        addr.setProvinceName("山东省");
        addr.setCityName("XX市");
        addr.setCountyName("XX区");
        addr.setStreetName("XX街道");
        addr.setVillageName("XX村庄");
        addr.setPosX("120.222222");
        addr.setPosY("22.222222");
        addr.setPosZ("88.20");
//        addr.setRoadCode("7");
//        addr.setCommunityCode("1");
//        addr.setPlateNo("706");

        List<Addr> dataList = new ArrayList<>();
        dataList.add(addr);
        String jsonDataList = JSONObject.toJSONString(dataList);


        String getToken = HttpTools.getToken();
        JSONObject jsonObject = JSON.parseObject(getToken);
        if(jsonObject.getString("resCode").equals("0000")) {
            token = jsonObject.getJSONObject("resData").getString("token");
            System.out.println(token);
            // DATA数据
            Data data =new Data();
            data.setToken(token);
            data.setDataCount(1);
            data.setDataList(jsonDataList);
            String res = HttpTools.postData(url, data);
            System.out.println(res);
        }else {
            System.out.println(getToken);
        }
    }
}
