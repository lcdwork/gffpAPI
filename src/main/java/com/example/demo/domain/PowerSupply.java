package com.example.demo.domain;

public class PowerSupply {
    public String ORG_NO; // 供电单位编号 不为空
    public String ORG_NAME; // 供电单位名称  不为空
    public String P_ORG_NO; // 上级供电单位名称  不为空
    public String ORG_TYPE; // 单位类型   不为空且 必须是 01  02  03  04  05  06  其中一个
    public Long SORT_NO; // 排序序号
    public String ORG_PROPERTY; // 供电单位属性   不为空且必须是 01  02  03  其中一个
    public String ORG_SHORTHAND; // 供电单位缩写   不为空
}
