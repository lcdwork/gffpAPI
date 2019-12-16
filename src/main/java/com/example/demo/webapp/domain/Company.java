package com.example.demo.webapp.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.riozenc.titanTool.mybatis.MybatisEntity;

// 供电单位
public class Company implements MybatisEntity {
    @JSONField(name = "ORG_NO")
    private String orgNo; // 供电单位编号 不为空
    @JSONField(name = "ORG_NAME")
    private String orgName; // 供电单位名称  不为空
    @JSONField(name = "P_ORG_NO")
    private String pOrgNo; // 上级供电单位名称  不为空
    @JSONField(name = "ORG_TYPE")
    private String orgType; // 单位类型   不为空且 必须是 01  02  03  04  05  06  其中一个
    @JSONField(name = "SORT_NO")
    private String sortNo; // 排序序号
    @JSONField(name = "ORG_PROPERTY")
    private String orgProperty; // 供电单位属性   不为空且必须是 01  02  03  其中一个
    @JSONField(name = "ORG_SHORTHAND")
    private String orgShorthand; // 供电单位缩写   不为空

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getpOrgNo() {
        return pOrgNo;
    }

    public void setpOrgNo(String pOrgNo) {
        this.pOrgNo = pOrgNo;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getSortNo() {
        return sortNo;
    }

    public void setSortNo(String sortNo) {
        this.sortNo = sortNo;
    }

    public String getOrgProperty() {
        return orgProperty;
    }

    public void setOrgProperty(String orgProperty) {
        this.orgProperty = orgProperty;
    }

    public String getOrgShorthand() {
        return orgShorthand;
    }

    public void setOrgShorthand(String orgShorthand) {
        this.orgShorthand = orgShorthand;
    }
}
