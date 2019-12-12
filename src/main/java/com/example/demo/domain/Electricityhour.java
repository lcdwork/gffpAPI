package com.example.demo.domain;

import com.alibaba.fastjson.annotation.JSONField;

// 光伏小时发电功率信息（日）
public class Electricityhour {
    @JSONField(name = "PROVINCE_CODE")
    private String provinceCode; // 网省编号    不为空
    @JSONField(name = "DATA_DATE")
    private String dataDate; // 日期    不为空  格式 为yyyy-MM—dd hh:mm:ss
    @JSONField(name = "GC_NO")
    private String gcNo; // 发电户号 不为空
    @JSONField(name = "ORG_NO")
    private String orgNo; //  供电单位  不为空
    @JSONField(name = "METER_ID")
    private String meterId; // 电表编号  不为空
    @JSONField(name = "METER_TYPE")
    private String meterType; // 电表类型  不为空 且必须为 01 02 其中一个
    @JSONField(name = "P1")
    private String p1; // 不为空
    @JSONField(name = "P2")
    private String p2; // 不为空
    @JSONField(name = "P3")
    private String p3; // 不为空
    @JSONField(name = "P4")
    private String p4; // 不为空
    @JSONField(name = "P5")
    private String p5; // 不为空
    @JSONField(name = "P6")
    private String p6; // 不为空
    @JSONField(name = "P7")
    private String p7; // 不为空
    @JSONField(name = "P8")
    private String p8; // 不为空
    @JSONField(name = "P9")
    private String p9; // 不为空
    @JSONField(name = "P10")
    private String p10; // 不为空
    @JSONField(name = "P11")
    private String p11; // 不为空
    @JSONField(name = "P12")
    private String p12; // 不为空
    @JSONField(name = "P13")
    private String p13; // 不为空
    @JSONField(name = "P14")
    private String p14; // 不为空
    @JSONField(name = "P15")
    private String p15; // 不为空
    @JSONField(name = "P16")
    private String p16; // 不为空
    @JSONField(name = "P17")
    private String p17; // 不为空
    @JSONField(name = "P18")
    private String p18; // 不为空
    @JSONField(name = "P19")
    private String p19; // 不为空
    @JSONField(name = "P20")
    private String p20; // 不为空
    @JSONField(name = "P21")
    private String p21; // 不为空
    @JSONField(name = "P22")
    private String p22; // 不为空
    @JSONField(name = "P23")
    private String p23; // 不为空
    @JSONField(name = "P24")
    private String p24; // 不为空

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public String getGcNo() {
        return gcNo;
    }

    public void setGcNo(String gcNo) {
        this.gcNo = gcNo;
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public String getMeterId() {
        return meterId;
    }

    public void setMeterId(String meterId) {
        this.meterId = meterId;
    }

    public String getMeterType() {
        return meterType;
    }

    public void setMeterType(String meterType) {
        this.meterType = meterType;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public String getP3() {
        return p3;
    }

    public void setP3(String p3) {
        this.p3 = p3;
    }

    public String getP4() {
        return p4;
    }

    public void setP4(String p4) {
        this.p4 = p4;
    }

    public String getP5() {
        return p5;
    }

    public void setP5(String p5) {
        this.p5 = p5;
    }

    public String getP6() {
        return p6;
    }

    public void setP6(String p6) {
        this.p6 = p6;
    }

    public String getP7() {
        return p7;
    }

    public void setP7(String p7) {
        this.p7 = p7;
    }

    public String getP8() {
        return p8;
    }

    public void setP8(String p8) {
        this.p8 = p8;
    }

    public String getP9() {
        return p9;
    }

    public void setP9(String p9) {
        this.p9 = p9;
    }

    public String getP10() {
        return p10;
    }

    public void setP10(String p10) {
        this.p10 = p10;
    }

    public String getP11() {
        return p11;
    }

    public void setP11(String p11) {
        this.p11 = p11;
    }

    public String getP12() {
        return p12;
    }

    public void setP12(String p12) {
        this.p12 = p12;
    }

    public String getP13() {
        return p13;
    }

    public void setP13(String p13) {
        this.p13 = p13;
    }

    public String getP14() {
        return p14;
    }

    public void setP14(String p14) {
        this.p14 = p14;
    }

    public String getP15() {
        return p15;
    }

    public void setP15(String p15) {
        this.p15 = p15;
    }

    public String getP16() {
        return p16;
    }

    public void setP16(String p16) {
        this.p16 = p16;
    }

    public String getP17() {
        return p17;
    }

    public void setP17(String p17) {
        this.p17 = p17;
    }

    public String getP18() {
        return p18;
    }

    public void setP18(String p18) {
        this.p18 = p18;
    }

    public String getP19() {
        return p19;
    }

    public void setP19(String p19) {
        this.p19 = p19;
    }

    public String getP20() {
        return p20;
    }

    public void setP20(String p20) {
        this.p20 = p20;
    }

    public String getP21() {
        return p21;
    }

    public void setP21(String p21) {
        this.p21 = p21;
    }

    public String getP22() {
        return p22;
    }

    public void setP22(String p22) {
        this.p22 = p22;
    }

    public String getP23() {
        return p23;
    }

    public void setP23(String p23) {
        this.p23 = p23;
    }

    public String getP24() {
        return p24;
    }

    public void setP24(String p24) {
        this.p24 = p24;
    }
}
