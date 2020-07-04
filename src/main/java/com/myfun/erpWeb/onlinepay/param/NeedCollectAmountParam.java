package com.myfun.erpWeb.onlinepay.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class NeedCollectAmountParam implements EncryParamIfc {

    @ApiModelProperty(value = "业务ID", required = true)
    private Integer businessId;
    @ApiModelProperty(value = "业务类型", required = true)
    private Byte businessType;
    @ApiModelProperty(value = "应收款项Id, businessType=2 必传", required = true)
    private Integer pfId;
    @ApiModelProperty(value = "付款方 businessType=1 必传", required = true)
    private Byte payer;
    @ApiModelProperty(hidden = true)
    private Integer cityId;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Byte getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Byte businessType) {
        this.businessType = businessType;
    }

    public Integer getPfId() {
        return pfId;
    }

    public void setPfId(Integer pfId) {
        this.pfId = pfId;
    }

    public Byte getPayer() {
        return payer;
    }

    public void setPayer(Byte payer) {
        this.payer = payer;
    }
}
