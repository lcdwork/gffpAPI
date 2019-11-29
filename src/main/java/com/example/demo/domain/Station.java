package com.example.demo.domain;

public class Station {


    public Long GC_ID; // 发电客户标识
    public String GC_NO; // 发电客户编号
    public String VOLT_CODE; // 并网电压 不为空且必须是    220v 380v  3kV 6kV  10kV 20kV  35kV  其中一个    k小谢  V大写

    public String STATUS_CODE; // 发电客户状态   不为空 且必须是   0  1  2  9 其中一个

    public String ABSO_MODE; // 发电消滞方式    不为空 且必须是  01  02  03 其中一个

    public String POVERTY_ALLEV_FLAG; // 光伏扶贫标志   不为空  且必须是  01  02  03  04  05  06  其中一个

    public Double CONTRACT_CAP; // 合同电压  不为空 且必须是 2位以内小数

    public String GC_DATE; // 并网日期  不为空  且必须是  yyyy-MM-dd hh:mm:ss  格式
}
