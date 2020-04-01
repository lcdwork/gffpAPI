package com.jlsd.gffp.webapp.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jlsd.gffp.tools.HandleTools;
import com.jlsd.gffp.webapp.domain.Electricityday;
import com.jlsd.gffp.webapp.service.IElectricitydayService;
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
public class ElectricitydayAciton {

    @Autowired
    @Qualifier("electricitydayServiceImpl")
    private IElectricitydayService electricitydayService;

    @Value("${electricityday.url}")
    public String url;

    @Scheduled(cron = "${electricityday.cron}")
    public void putElectricityday() {
        Logger logger = LoggerFactory.getLogger(this.getClass());

        List<Electricityday> dataList = electricitydayService.findByWhere(null);

        if(dataList.size()>0) {
//            System.out.println("electricityday触发");
            String jsonDataList = JSONObject.toJSONString(dataList);
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
                                failList.add(c);
                                it.remove(); // remove() 移除元素
                            }
                        }
                    }
                    if(dataList.size() > 0) {
                        electricitydayService.updateSuccessList(dataList);
                    }
                    electricitydayService.updateFailList(failList);
                } else {
                    electricitydayService.updateFailList(dataList);
                    logger.error("{\"resCode\":\"" + jsonObject.getString("resCode") + "\",\"resMsg\":\"" + jsonObject.getString("resMsg") + "\",\"resTime\":\"" + jsonObject.getString("resTime") +"\"}");
                }
            }
            else {
                logger.error("网络问题请求失败！");
            }
        }
    }
}
