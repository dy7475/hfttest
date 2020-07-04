package com.myfun.erpWeb.managecenter.transaction.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DetermineIfThePerformanceCategoryIsUsedVO {
    @ApiModelProperty(value = "0未使用 1已使用")
    private Integer flag;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
