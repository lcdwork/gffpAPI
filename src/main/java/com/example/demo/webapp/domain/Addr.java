package com.example.demo.webapp.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.riozenc.titanTool.mybatis.MybatisEntity;

// 发电客户地址信息
public class Addr implements MybatisEntity {
    @JSONField(name = "GCA_ID")
    private String gcaId; // 发电地址标识   不为空
    @JSONField(name = "GC_NO")
    private String gcNo; // 发电客户标识 不为空
    @JSONField(name = "PROVINCE_NAME")
    private String provinceName; // 省名称  不为空
    @JSONField(name = "CITY_NAME")
    private String cityName; // 城市名称  不为空
    @JSONField(name = "COUNTY_NAME")
    private String countyName; // 区县名称   不为空
    @JSONField(name = "STREET_NAME")
    private String streetName; // 街道名称   不为空
    @JSONField(name = "VILLAGE_NAME")
    private String villageName; // 村庄名称   不为空
    @JSONField(name = "POS_X")
    private String posX; // 经度   不为空  6位内小数
    @JSONField(name = "POS_Y")
    private String posY; // 纬度  不为空  6位内小数
    @JSONField(name = "POS_Z")
    private String posZ; // 高程  不为空  4位内小数
//    @JSONField(name = "ROAD_CODE")
//    private String roadCode;
//    @JSONField(name = "COMMUNITY_CODE")
//    private String communityCode;
//    @JSONField(name = "PLATE_NO")
//    private String plateNo;

    private Number status;

    public Number getStatus() {
        return status;
    }

    public void setStatus(Number status) {
        this.status = status;
    }

    public String getGcaId() {
        return gcaId;
    }

    public void setGcaId(String gcaId) {
        this.gcaId = gcaId;
    }

    public String getGcNo() {
        return gcNo;
    }

    public void setGcNo(String gcNo) {
        this.gcNo = gcNo;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getPosX() {
        return posX;
    }

    public void setPosX(String posX) {
        this.posX = posX;
    }

    public String getPosY() {
        return posY;
    }

    public void setPosY(String posY) {
        this.posY = posY;
    }

    public String getPosZ() {
        return posZ;
    }

    public void setPosZ(String posZ) {
        this.posZ = posZ;
    }
}
