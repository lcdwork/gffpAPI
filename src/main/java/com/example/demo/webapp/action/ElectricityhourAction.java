package com.example.demo.webapp.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.tools.HandleTools;
import com.example.demo.webapp.domain.Electricityhour;
import com.example.demo.webapp.service.IElectricityhourService;
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
public class ElectricityhourAction {

    @Autowired
    @Qualifier("electricityhourServiceImpl")
    private IElectricityhourService electricityhourService;

    @Value("${electricityhour.url}")
    public String url;

//    @Scheduled(cron = "${electricityhour.cron}")
    public void putElectricityhour() {

        List<Electricityhour> dataList = electricityhourService.findByWhere(null);
        String jsonDataList = JSONObject.toJSONString(dataList);

        if(dataList.size()>0) {
            String res = HandleTools.putData(url, dataList.size(), jsonDataList);
            if (res != null) {
                JSONObject jsonObject = JSON.parseObject(res);
                if (jsonObject.getString("resCode").equals("0000")) {
                    electricityhourService.updateSuccessList(dataList);
                } else if (jsonObject.getString("resCode").equals("3001")) {
                    List<Map> returnList = JSON.parseArray(jsonObject.getString("resData"),Map.class);
                    List<Electricityhour> failList = new ArrayList();
                    for (Map item : returnList) {
                        Iterator<Electricityhour> it = dataList.iterator();
                        while (it.hasNext()) {
                            Electricityhour c = it.next(); // next() 返回下一个元素
                            if (c.getGcNo().equals(item.get("GC_NO"))) {
                                Electricityhour failObject = new Electricityhour();
                                failObject.setGcNo(c.getGcNo());
                                failObject.setDataDate(c.getDataDate());
                                failList.add(failObject);
                                it.remove(); // remove() 移除元素
                            }
                        }
                    }
                    if(dataList.size() > 0) {
                        electricityhourService.updateSuccessList(dataList);
                    }
                    electricityhourService.updateFailList(failList);
                } else {
                    System.out.println("推送失败，未更新任何数据！");
                }
            }
        }
    }
}
