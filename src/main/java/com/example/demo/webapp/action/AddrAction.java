package com.example.demo.webapp.action;

import com.example.demo.webapp.domain.Addr;
import com.example.demo.webapp.service.IAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;

@ControllerAdvice
public class AddrAction {

    @Autowired
    @Qualifier("addrServiceImpl")
    private IAddrService addrService;

    @Value("${addr.url}")
    public String url;

    @Scheduled(cron = "${addr.cron}")
    public void putAddr() {
        String token = null;


        Addr addr = new Addr();
        List list = addrService.findByWhere(addr);
        System.out.println(list.size());
//        addr.setGcaId("7275257272");
//        addr.setGcNo("11224411");
//        addr.setProvinceName("山东省");
//        addr.setCityName("XX市");
//        addr.setCountyName("XX区");
//        addr.setStreetName("XX街道");
//        addr.setVillageName("XX村庄");
//        addr.setPosX("120.222222");
//        addr.setPosY("22.222222");
//        addr.setPosZ("88.20");
////        addr.setRoadCode("7");
////        addr.setCommunityCode("1");
////        addr.setPlateNo("706");
//
//        List<Addr> dataList = new ArrayList<>();
//        dataList.add(addr);
//        String jsonDataList = JSONObject.toJSONString(dataList);
//
//
//        String getToken = HttpTools.getToken();
//        JSONObject jsonObject = JSON.parseObject(getToken);
//        if(jsonObject.getString("resCode").equals("0000")) {
//            token = jsonObject.getJSONObject("resData").getString("token");
//            System.out.println(token);
//            // DATA数据
//            Data data =new Data();
//            data.setToken(token);
//            data.setDataCount(1);
//            data.setDataList(jsonDataList);
//            String res = HttpTools.postData(url, data);
//            System.out.println(res);
//        }else {
//            System.out.println(getToken);
//        }
    }
}
