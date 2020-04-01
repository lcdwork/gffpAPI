package com.jlsd.gffp.webapp.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jlsd.gffp.tools.HandleTools;
import com.jlsd.gffp.webapp.domain.Billmonth;
import com.jlsd.gffp.webapp.service.IBillmonthService;
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
public class BillmonthAction {

    @Autowired
    @Qualifier("billmonthServiceImpl")
    private IBillmonthService billmonthService;

    @Value("${billmonth.url}")
    public String url;

    @Scheduled(cron = "${billmonth.cron}")
    public void putMonthBill() {
        Logger logger = LoggerFactory.getLogger(this.getClass());

        List<Billmonth> dataList = billmonthService.findByWhere(null);

        if(dataList.size()>0) {
//            System.out.println("billmonth触发");
            String jsonDataList = JSONObject.toJSONString(dataList);
            String res = HandleTools.putData(url, dataList.size(), jsonDataList);
            if (res != null) {
                JSONObject jsonObject = JSON.parseObject(res);
                if (jsonObject.getString("resCode").equals("0000")) {
                    billmonthService.updateSuccessList(dataList);
                } else if (jsonObject.getString("resCode").equals("3001")) {
                    List<Billmonth> failList = new ArrayList();
                    List<Map> returnList = JSON.parseArray(jsonObject.getString("resData"),Map.class);
                    for (int i = 0; i < returnList.size(); i++) {
                        Iterator<Billmonth> it = dataList.iterator();
                        while (it.hasNext()) {
                            Billmonth c = it.next(); // next() 返回下一个元素
                            if (c.getGcNo().equals(returnList.get(i).get("GC_NO"))) {
                                failList.add(c);
                                it.remove(); // remove() 移除元素
                            }
                        }
                    }
                    if(dataList.size() > 0) {
                        billmonthService.updateSuccessList(dataList);
                    }
                    billmonthService.updateFailList(failList);
                } else {
                    billmonthService.updateFailList(dataList);
                    logger.error("{\"resCode\":\"" + jsonObject.getString("resCode") + "\",\"resMsg\":\"" + jsonObject.getString("resMsg") + "\",\"resTime\":\"" + jsonObject.getString("resTime") +"\"}");
                }
            }
            else {
                logger.error("网络问题请求失败！");
            }
        }
    }
}
