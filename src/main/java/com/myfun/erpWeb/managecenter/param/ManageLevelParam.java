package com.myfun.erpWeb.managecenter.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("查询模块权限")
public class ManageLevelParam implements EncryParamIfc {

    @ApiModelProperty(value = "模块编码：1000 = 组织机构")
    private Integer modelCode;

    public Integer getModelCode() {
        return modelCode;
    }

    public void setModelCode(Integer modelCode) {
        this.modelCode = modelCode;
    }
}
