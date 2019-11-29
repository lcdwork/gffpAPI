package com.example.demo.domain;

public class Addr {
    public Long GCA_ID; // 发电地址标识   不为空
    public Long GC_NO; // 发电客户标识 不为空
    public String PROVINCE_NAME; // 省名称  不为空
    public String CITY_NAME; // 城市名称  不为空
    public String COUNTY_NAME; // 区县名称   不为空
    public String STREET_NAME; // 街道名称   不为空
    public String VILLAGE_NAME; // 村庄名称   不为空
    public String POS_X; // 经度   不为空  6位内小数
    public String POS_Y; // 纬度  不为空  6位内小数
    public String POS_Z; // 高程  不为空  4位内小数
}
