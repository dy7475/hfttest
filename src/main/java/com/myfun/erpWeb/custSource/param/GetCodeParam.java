package com.myfun.erpWeb.custSource.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("获取编码")
public class GetCodeParam implements EncryParamIfc {
    @ApiModelProperty("名称")
    private  String sourceName;

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
