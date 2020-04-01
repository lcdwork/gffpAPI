package com.jlsd.gffp.webapp.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jlsd.gffp.tools.HandleTools;
import com.jlsd.gffp.webapp.domain.Company;
import com.jlsd.gffp.webapp.service.ICompanyService;
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
public class CompanyAction {

    @Autowired
    @Qualifier("companyServiceImpl")
    private ICompanyService companyService;

    @Value("${company.url}")
    public String url;

    @Scheduled(cron = "${company.cron}")
    public void putCompany() {
        Logger logger = LoggerFactory.getLogger(this.getClass());

        List<Company> dataList = companyService.findByWhere(null);

        if(dataList.size()>0) {
//            System.out.println("company触发");
            String jsonDataList = JSONObject.toJSONString(dataList);
            String res = HandleTools.putData(url, dataList.size(), jsonDataList);
            if (res != null) {
                JSONObject jsonObject = JSON.parseObject(res);
                if (jsonObject.getString("resCode").equals("0000")) {
                    companyService.updateSuccessList(dataList);
                } else if (jsonObject.getString("resCode").equals("3001")) {
                    List<Map> returnList = JSON.parseArray(jsonObject.getString("resData"),Map.class);
                    List<Company> failList = new ArrayList();
                    for (int i = 0; i < returnList.size(); i++) {
                        Iterator<Company> it = dataList.iterator();
                        while (it.hasNext()) {
                            Company c = it.next(); // next() 返回下一个元素
                            if (c.getOrgNo().equals(returnList.get(i).get("ORG_NO"))) {
                                failList.add(c);
                                it.remove(); // remove() 移除元素
                            }
                        }
                    }
                    if(dataList.size() > 0) {
                        companyService.updateSuccessList(dataList);
                    }
                    companyService.updateFailList(failList);
                } else {
                    companyService.updateFailList(dataList);
                    logger.error("{\"resCode\":\"" + jsonObject.getString("resCode") + "\",\"resMsg\":\"" + jsonObject.getString("resMsg") + "\",\"resTime\":\"" + jsonObject.getString("resTime") +"\"}");
                }
            }
            else {
                logger.error("网络问题请求失败！");
            }
        }
    }
}
