package com.myfun.erpWeb.businesstools.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetKeyLogListParam extends AbstractEncryParam {
    @ApiModelProperty(value = "钥匙ID")
    private Integer keyId;

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }
}
