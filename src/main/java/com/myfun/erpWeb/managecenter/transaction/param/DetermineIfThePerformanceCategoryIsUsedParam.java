package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DetermineIfThePerformanceCategoryIsUsedParam implements EncryParamIfc {
    @ApiModelProperty(value="主键id (多个用英文逗号隔开)")
    private String performanceIdStr;

    public String getPerformanceIdStr() {
        return performanceIdStr;
    }

    public void setPerformanceIdStr(String performanceIdStr) {
        this.performanceIdStr = performanceIdStr;
    }
}
