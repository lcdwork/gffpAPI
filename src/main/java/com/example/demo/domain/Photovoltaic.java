package com.example.demo.domain;

import com.alibaba.fastjson.annotation.JSONField;

public class Photovoltaic {
    @JSONField(name = "PROVINCE_CODE")
    private String provinceCode; // 网省编号    不为空
    @JSONField(name = "ENERGY_DATE")
    private String energyDate; // 日期    不为空  格式 为yyyyMMdd
    @JSONField(name = "GC_NO")
    private String  gcNo; // 发电户号 不为空
    @JSONField(name = "PUR_PQ")
    private String purPq; // 总上网电量   不为空 两位内小数
    @JSONField(name = "GRA_PQ")
    private String graPq; // 总发电量   不为空 两位内小数

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getEnergyDate() {
        return energyDate;
    }

    public void setEnergyDate(String energyDate) {
        this.energyDate = energyDate;
    }

    public String getGcNo() {
        return gcNo;
    }

    public void setGcNo(String gcNo) {
        this.gcNo = gcNo;
    }

    public String getPurPq() {
        return purPq;
    }

    public void setPurPq(String purPq) {
        this.purPq = purPq;
    }

    public String getGraPq() {
        return graPq;
    }

    public void setGraPq(String graPq) {
        this.graPq = graPq;
    }
}
