package com.example.demo.webapp.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.tools.HandleTools;
import com.example.demo.webapp.domain.Electricityday;
import com.example.demo.webapp.service.IElectricitydayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ElectricitydayAciton {

    @Autowired
    @Qualifier("electricitydayServiceImpl")
    private IElectricitydayService electricitydayService;

    @Value("${electricityday.url}")
    public String url;

//    @Scheduled(cron = "${electricityday.cron}")
    public void putStation() {

        List<Electricityday> dataList = electricitydayService.findByWhere(null);
        String jsonDataList = JSONObject.toJSONString(dataList);

        if(dataList.size()>0) {
            String res = HandleTools.putData(url, dataList.size(), jsonDataList);
            if (res != null) {
                JSONObject jsonObject = JSON.parseObject(res);
                if (jsonObject.getString("resCode").equals("0000")) {
                    electricitydayService.updateSuccessList(dataList);
                } else if (jsonObject.getString("resCode").equals("3001")) {
                    List<Map> returnList = JSON.parseArray(jsonObject.getString("resData"),Map.class);
                    List<Electricityday> failList = new ArrayList();
                    for (Map item : returnList) {
                        Iterator<Electricityday> it = dataList.iterator();
                        while (it.hasNext()) {
                            Electricityday c = it.next(); // next() 返回下一个元素
                            if (c.getGcNo().equals(item.get("GC_NO"))) {
                                Electricityday failObject = new Electricityday();
                                failObject.setGcNo(c.getGcNo());
                                failObject.setEnergyDate(c.getEnergyDate());
                                failList.add(failObject);
                                it.remove(); // remove() 移除元素
                            }
                        }
                    }
                    if(dataList.size() > 0) {
                        electricitydayService.updateSuccessList(dataList);
                    }
                    electricitydayService.updateFailList(failList);
                } else {
                    System.out.println("推送失败，未更新任何数据！");
                }
            }
        }
    }
}
