package com.example.demo.webapp.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.tools.HandleTools;
import com.example.demo.webapp.domain.Station;
import com.example.demo.webapp.service.IStationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class StationAction {

    @Autowired
    @Qualifier("stationServiceImpl")
    private IStationService stationService;

    @Value("${station.url}")
    public String url;

    @Scheduled(cron = "${station.cron}")
    public void putStation() {
        Logger logger = LoggerFactory.getLogger(this.getClass());

        List<Station> dataList = stationService.findByWhere(null);

        if(dataList.size()>0) {
            String jsonDataList = JSONObject.toJSONString(dataList);
            String res = HandleTools.putData(url, dataList.size(), jsonDataList);
            if (res != null) {
                JSONObject jsonObject = JSON.parseObject(res);
                if (jsonObject.getString("resCode").equals("0000")) {
                    stationService.updateSuccessList(dataList);
                } else if (jsonObject.getString("resCode").equals("3001")) {
                    List<Map> returnList = JSON.parseArray(jsonObject.getString("resData"),Map.class);
                    List<Station> failList = new ArrayList();
                    for (int i = 0; i < returnList.size(); i++) {
                        Iterator<Station> it = dataList.iterator();
                        while (it.hasNext()) {
                            Station c = it.next(); // next() 返回下一个元素
                            if (c.getGcNo().equals(returnList.get(i).get("GC_NO"))) {
                                failList.add(c);
                                it.remove(); // remove() 移除元素
                            }
                        }
                    }
                    if(dataList.size() > 0) {
                        stationService.updateSuccessList(dataList);
                    }
                    stationService.updateFailList(failList);
                } else {
                    stationService.updateFailList(dataList);
                    logger.error("{\"resCode\":\"" + jsonObject.getString("resCode") + "\",\"resMsg\":\"" + jsonObject.getString("resMsg") + "\",\"resTime\":\"" + jsonObject.getString("resTime") +"\"}");
                }
            }
            else {
                logger.error("网络问题请求失败！");
            }
        }
    }
}
