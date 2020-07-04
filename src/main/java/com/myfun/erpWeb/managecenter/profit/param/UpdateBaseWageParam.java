package com.myfun.erpWeb.managecenter.profit.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UpdateBaseWageParam extends AbstractEncryParam {
    @ApiModelProperty(value = "基本薪资json")
    private String baseWageJson;

    public String getBaseWageJson() {
        return baseWageJson;
    }

    public void setBaseWageJson(String baseWageJson) {
        this.baseWageJson = baseWageJson;
    }
}
