package com.example.demo.domain;

import com.alibaba.fastjson.annotation.JSONField;

public class Base {
    @JSONField(name = "REGION_ID")
    private String regionId;

    @JSONField(name = "TIME_STAMP")
    private String timeStamp;

    @JSONField(name = "SIGN")
    private String sign;

    @JSONField(name = "DATA")
    private String data;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
