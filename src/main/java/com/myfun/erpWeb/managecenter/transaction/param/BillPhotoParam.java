package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2019/3/11
 */
public class BillPhotoParam implements EncryParamIfc {

    @ApiModelProperty(value = "诚意金ID")
    private Integer earbestId;

    @ApiModelProperty(value = "财务款项id")
    private Integer financId;

    @ApiModelProperty(value = "票据图片地址")
    private String photoUrl;

    @ApiModelProperty(value = "票据号")
    private String billNo;

    @ApiModelProperty(value = "合同ID")
    private Integer dealId;

    public Integer getEarbestId() {
        return earbestId;
    }

    public void setEarbestId(Integer earbestId) {
        this.earbestId = earbestId;
    }

    public Integer getFinancId() {
        return financId;
    }

    public void setFinancId(Integer financId) {
        this.financId = financId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }
}