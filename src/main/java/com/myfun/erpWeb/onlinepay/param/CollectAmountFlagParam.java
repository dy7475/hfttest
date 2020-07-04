package com.myfun.erpWeb.onlinepay.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CollectAmountFlagParam implements EncryParamIfc {

    @ApiModelProperty(value = "合作Id", required = true)
    private Integer cooperateId;
    @ApiModelProperty(value = "cityId", hidden = true)
    private Integer cityId;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCooperateId() {
        return cooperateId;
    }

    public void setCooperateId(Integer cooperateId) {
        this.cooperateId = cooperateId;
    }
}
