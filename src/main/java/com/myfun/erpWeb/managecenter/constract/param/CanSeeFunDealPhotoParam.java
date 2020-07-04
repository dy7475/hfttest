package com.myfun.erpWeb.managecenter.constract.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2019/9/26
 */
public class CanSeeFunDealPhotoParam implements EncryParamIfc {

    @ApiModelProperty("合同ID")
    private Integer dealId;

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }
}