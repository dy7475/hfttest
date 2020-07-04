package com.myfun.erpWeb.deal.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class PdfInfoParam implements EncryParamIfc {
    @NotNull
    @ApiModelProperty(value = "甲方（卖方）", required = true)
    private String signPartyA;
    @NotNull
    @ApiModelProperty(value = "乙方（买方）", required = true)
    private String signPartyB;
    @NotNull
    @ApiModelProperty(value = "甲方（卖方）签约时间", required = true)
    private String signPartyADate;
    @NotNull
    @ApiModelProperty(value = "乙方（买方）签约时间", required = true)
    private String signPartyBDate;
    @NotNull
    @ApiModelProperty(value = "联系地址", required = true)
    private String signAdress;
    @NotNull
    @ApiModelProperty(value = "pdf路径", required = true)
    private String pdfPath;
    @NotNull
    @ApiModelProperty(value = "合同Id", required = true)
    private Integer dealId;
    @NotNull
    @ApiModelProperty(value = "城市Id", required = true)
    private Integer cityId;
    @NotNull
    @ApiModelProperty(value = "pdf路径 不带域名", required = true)
    private String pdfOssPath;

    public String getSignPartyA() {
        return signPartyA;
    }

    public void setSignPartyA(String signPartyA) {
        this.signPartyA = signPartyA;
    }

    public String getSignPartyB() {
        return signPartyB;
    }

    public void setSignPartyB(String signPartyB) {
        this.signPartyB = signPartyB;
    }

    public String getSignPartyADate() {
        return signPartyADate;
    }

    public void setSignPartyADate(String signPartyADate) {
        this.signPartyADate = signPartyADate;
    }

    public String getSignPartyBDate() {
        return signPartyBDate;
    }

    public void setSignPartyBDate(String signPartyBDate) {
        this.signPartyBDate = signPartyBDate;
    }

    public String getSignAdress() {
        return signAdress;
    }

    public void setSignAdress(String signAdress) {
        this.signAdress = signAdress;
    }

    public String getPdfPath() {
        return pdfPath;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getPdfOssPath() {
        return pdfOssPath;
    }

    public void setPdfOssPath(String pdfOssPath) {
        this.pdfOssPath = pdfOssPath;
    }
}
