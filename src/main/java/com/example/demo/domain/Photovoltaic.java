package com.example.demo.domain;

public class Photovoltaic {
    public String PROVINCE_CODE; // 网省编号    不为空
    public String ENERGY_DATE; // 日期    不为空  格式 为yyyyMMdd
    public String  GC_NO; // 发电户号 不为空
    public Double PUR_PQ; // 总上网电量   不为空 两位内小数
    public Double GRA_PQ; // 总发电量   不为空 两位内小数
}
