package com.example.demo.webapp.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.riozenc.titanTool.mybatis.MybatisEntity;

// 光伏发电账单应付信息（月）
public class Billmonth implements MybatisEntity {
    @JSONField(name = "PAY_INFO_ID")
    private String payInfoId; // 应付信息标识  不为空
    @JSONField(name = "CALC_ID")
    private String calcId; // 电费计算标识  不为空
    @JSONField(name = "AMT_SORT")
    private String amtSort; // 电费类别  不为空且必须是  01 02  03  04  05  06 99   0201 0202  0203 0204 其中一个
    @JSONField(name = "PAY_YM")
    private String payYm; // 应付年月   不为空 且必须是  yyyy-MM  格式
    @JSONField(name = "GC_NO")
    private String gcNo; // 发电客户编号   不为空
    @JSONField(name = "T_PUR_PQ")
    private String tPurPq; // 总上网电量   不为空 两位内小数
    @JSONField(name = "T_GRA_PQ")
    private String tGraPq; // 总发电量     非必填  如果有此参数 必须是两位内小数
    @JSONField(name = "PAY_AMT")
    private String payAmt; // 应付金额      不为空 两位内小数
    @JSONField(name = "PAY_PUR_AMT")
    private String payPurAmt; // 应付购电款金额    不为空 两位内小数
    @JSONField(name = "PAY_GRA_AMT")
    private String payGraAmt; // 应付补助款金额    非必填  如果有此参数 必须是两位内小数
    @JSONField(name = "PAIED_PUR_AMT")
    private String paiedPurAmt; // 实付购电款金额   不为空 两位内小数
    @JSONField(name = "PAIED_GRA_AMT")
    private String paredGraAmt; // 实付补助款金额   不为空 两位内小数
    @JSONField(name = "PUR_TAX_AMT")
    private String purTaxAmt; // 上网购电款税额   不为空 两位内小数
    @JSONField(name = "GRA_TAX_AMT")
    private String graTaxAmt; // 总补助款税额  不为空 两位内小数
    @JSONField(name = "TAX_AMT")
    private String taxAmt; // 税额  不为空 两位内小数
    @JSONField(name = "OWE_AMT")
    private String oweAmt; // 应付余额   不为空 两位内小数
    @JSONField(name = "RELEASE_DATE")
    private String releaseDate; // 发行日期  不为空 且格式为  yyyy-MM-dd
    @JSONField(name = "SETTLE_FLAG")
    private String settleFlag; // 结清标志  不为空  且为01 02
    @JSONField(name = "PRINT_MARK")
    private String peintMark; // 结算单打印标识   	非必填  如果有此参数 必须为01 02
    @JSONField(name = "BATCH_ID")
    private String batchId; // 批次标识   	非必填
    @JSONField(name = "STATUS_CODE")
    private String statusCode; // 费用状态    非必填  如果有此参数 必须为01 02

    public String getPayInfoId() {
        return payInfoId;
    }

    public void setPayInfoId(String payInfoId) {
        this.payInfoId = payInfoId;
    }

    public String getCalcId() {
        return calcId;
    }

    public void setCalcId(String calcId) {
        this.calcId = calcId;
    }

    public String getAmtSort() {
        return amtSort;
    }

    public void setAmtSort(String amtSort) {
        this.amtSort = amtSort;
    }

    public String getPayYm() {
        return payYm;
    }

    public void setPayYm(String payYm) {
        this.payYm = payYm;
    }

    public String getGcNo() {
        return gcNo;
    }

    public void setGcNo(String gcNo) {
        this.gcNo = gcNo;
    }

    public String gettPurPq() {
        return tPurPq;
    }

    public void settPurPq(String tPurPq) {
        this.tPurPq = tPurPq;
    }

    public String gettGraPq() {
        return tGraPq;
    }

    public void settGraPq(String tGraPq) {
        this.tGraPq = tGraPq;
    }

    public String getPayAmt() {
        return payAmt;
    }

    public void setPayAmt(String payAmt) {
        this.payAmt = payAmt;
    }

    public String getPayPurAmt() {
        return payPurAmt;
    }

    public void setPayPurAmt(String payPurAmt) {
        this.payPurAmt = payPurAmt;
    }

    public String getPayGraAmt() {
        return payGraAmt;
    }

    public void setPayGraAmt(String payGraAmt) {
        this.payGraAmt = payGraAmt;
    }

    public String getPaiedPurAmt() {
        return paiedPurAmt;
    }

    public void setPaiedPurAmt(String paiedPurAmt) {
        this.paiedPurAmt = paiedPurAmt;
    }

    public String getParedGraAmt() {
        return paredGraAmt;
    }

    public void setParedGraAmt(String paredGraAmt) {
        this.paredGraAmt = paredGraAmt;
    }

    public String getPurTaxAmt() {
        return purTaxAmt;
    }

    public void setPurTaxAmt(String purTaxAmt) {
        this.purTaxAmt = purTaxAmt;
    }

    public String getGraTaxAmt() {
        return graTaxAmt;
    }

    public void setGraTaxAmt(String graTaxAmt) {
        this.graTaxAmt = graTaxAmt;
    }

    public String getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(String taxAmt) {
        this.taxAmt = taxAmt;
    }

    public String getOweAmt() {
        return oweAmt;
    }

    public void setOweAmt(String oweAmt) {
        this.oweAmt = oweAmt;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSettleFlag() {
        return settleFlag;
    }

    public void setSettleFlag(String settleFlag) {
        this.settleFlag = settleFlag;
    }

    public String getPeintMark() {
        return peintMark;
    }

    public void setPeintMark(String peintMark) {
        this.peintMark = peintMark;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
