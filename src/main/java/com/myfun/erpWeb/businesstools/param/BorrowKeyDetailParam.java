package com.myfun.erpWeb.businesstools.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BorrowKeyDetailParam implements EncryParamIfc {

    @ApiModelProperty("钥匙Id")
    private Integer keyId;

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }
}
