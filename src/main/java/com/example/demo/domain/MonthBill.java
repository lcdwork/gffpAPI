package com.example.demo.domain;

public class MonthBill {
    public Long PAY_INFO_ID; // 应付信息标识  不为空
    public Long CALC_ID; // 电费计算标识  不为空
    public String AMT_SORT; // 电费类别  不为空且必须是  01 02  03  04  05  06 99   0201 0202  0203 0204 其中一个
    public String PAY_YM; // 应付年月   不为空 且必须是  yyyyMM  格式
    public String GC_NO; // 发电客户编号   不为空
    public Double T_PUR_PQ; // 总上网电量   不为空 两位内小数
    public Double T_GRA_PQ; // 总发电量     非必填  如果有此参数 必须是两位内小数
    public Double PAY_AMT; // 应付金额      不为空 两位内小数
    public Double PAY_PUR_AMT; // 应付购电款金额    不为空 两位内小数
    public Double PAY_GRA_AMT; // 应付补助款金额    非必填  如果有此参数 必须是两位内小数
    public Double PAIED_PUR_AMT; // 实付购电款金额   不为空 两位内小数
    public Double PAIED_GRA_AMT; // 实付补助款金额   不为空 两位内小数
    public Double PUR_TAX_AMT; // 上网购电款税额   不为空 两位内小数
    public Double GRA_TAX_AMT; // 总补助款税额  不为空 两位内小数
    public Double TAX_AMT; // 税额  不为空 两位内小数
    public Double OWE_AMT; // 应付余额   不为空 两位内小数
    public String RELEASE_DATE; // 发行日期  不为空 且格式为  yyyy-MM-dd
    public String SETTLE_FLAG; // 结清标志  不为空  且为01 02
    public String PRINT_MARK; // 结算单打印标识   	非必填  如果有此参数 必须为01 02
    public String BATCH_ID; // 批次标识   	非必填
    public String STATUS_CODE; // 费用状态    非必填  如果有此参数 必须为01 02
}
