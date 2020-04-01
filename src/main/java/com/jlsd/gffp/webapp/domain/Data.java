package com.jlsd.gffp.webapp.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class Data {

    @JSONField(name = "TOKEN")
    private String token;

    @JSONField(name = "DATA_COUNT")
    private int dataCount;

    @JSONField(name = "DATA_LIST")
    private String dataList;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public String getDataList() {
        return dataList;
    }

    public void setDataList(String dataList) {
        this.dataList = dataList;
    }
}
