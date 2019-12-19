package com.example.demo.webapp.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.tools.HandleTools;
import com.example.demo.webapp.domain.Addr;
import com.example.demo.webapp.service.IAddrService;
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
public class AddrAction {

    @Autowired
    @Qualifier("addrServiceImpl")
    private IAddrService addrService;

    @Value("${addr.url}")
    public String url;

    @Scheduled(cron = "${addr.cron}")
    public void putAddr() {

        List<Addr> dataList = addrService.findByWhere(null);
        String jsonDataList = JSONObject.toJSONString(dataList);

        if(dataList.size()>0) {
            String res = HandleTools.putData(url, dataList.size(), jsonDataList);
            if (res != null) {
                JSONObject jsonObject = JSON.parseObject(res);
                if (jsonObject.getString("resCode").equals("0000")) {
                    addrService.updateSuccessList(dataList);
                } else if (jsonObject.getString("resCode").equals("3001")) {
                    List<Map> returnList = JSON.parseArray(jsonObject.getString("resData"),Map.class);
                    List<Addr> failList = new ArrayList();
                    for (int i = 0; i < returnList.size(); i++) {
                        Iterator<Addr> it = dataList.iterator();
                        while (it.hasNext()) {
                            Addr c = it.next(); // next() 返回下一个元素
                            if (c.getGcNo().equals(returnList.get(i).get("GCA_ID"))) {
                                failList.add(c);
                                it.remove(); // remove() 移除元素
                            }
                        }
                    }
                    if(dataList.size() > 0) {
                        addrService.updateSuccessList(dataList);
                    }
                    addrService.updateFailList(failList);
                } else {
                    addrService.updateFailList(dataList);
                    System.out.println("{\"resCode\":\"" + jsonObject.getString("resCode") + "\",\"resMsg\":\"" + jsonObject.getString("resMsg") + "\",\"resTime\":\"" + jsonObject.getString("resTime") +"\"}");
                }
            }
            else {
                System.out.println("网络问题请求失败！");
            }
        }
    }
}
