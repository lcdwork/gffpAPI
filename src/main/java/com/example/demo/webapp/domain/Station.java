package com.example.demo.webapp.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.riozenc.titanTool.mybatis.MybatisEntity;

// 发电客户信息
public class Station implements MybatisEntity {
    @JSONField(name = "GC_ID")
    private String gcId; // 发电客户标识
    @JSONField(name = "GC_NO")
    private String gcNo; // 发电客户编号
    @JSONField(name = "ORG_NO")
    private String orgNo; // 发电客户实际所属发电公司  不为空  发电公司code值
    @JSONField(name = "VOLT_CODE")
    private String VoltCode; // 并网电压 不为空且必须是    220v 380v  3kV 6kV  10kV 20kV  35kV  其中一个    k小谢  V大写
    @JSONField(name = "STATUS_CODE")
    private String StatusCode; // 发电客户状态   不为空 且必须是   0  1  2  9 其中一个
    @JSONField(name = "ABSO_MODE")
    private String AbsoMode; // 发电消滞方式    不为空 且必须是  01  02  03 其中一个
    @JSONField(name = "POVERTY_ALLEV_FLAG")
    private String PovertyAllevFlag; // 光伏扶贫标志   不为空  且必须是  01  02  03  04  05  06  其中一个
    @JSONField(name = "CONTRACT_CAP")
    private String ContractCap; // 合同电压  不为空 且必须是 2位以内小数
    @JSONField(name = "GC_DATE")
    private String GcDate; // 并网日期  不为空  且必须是  yyyy-MM-dd hh:mm:ss  格式

    public String getGcId() {
        return gcId;
    }

    public void setGcId(String gcId) {
        this.gcId = gcId;
    }

    public String getGcNo() {
        return gcNo;
    }

    public void setGcNo(String gcNo) {
        this.gcNo = gcNo;
    }

    public String getVoltCode() {
        return VoltCode;
    }

    public void setVoltCode(String voltCode) {
        VoltCode = voltCode;
    }

    public String getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(String statusCode) {
        StatusCode = statusCode;
    }

    public String getAbsoMode() {
        return AbsoMode;
    }

    public void setAbsoMode(String absoMode) {
        AbsoMode = absoMode;
    }

    public String getPovertyAllevFlag() {
        return PovertyAllevFlag;
    }

    public void setPovertyAllevFlag(String povertyAllevFlag) {
        PovertyAllevFlag = povertyAllevFlag;
    }

    public String getContractCap() {
        return ContractCap;
    }

    public void setContractCap(String contractCap) {
        ContractCap = contractCap;
    }

    public String getGcDate() {
        return GcDate;
    }

    public void setGcDate(String gcDate) {
        GcDate = gcDate;
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }
}
