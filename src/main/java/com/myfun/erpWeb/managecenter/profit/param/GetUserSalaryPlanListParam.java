package com.myfun.erpWeb.managecenter.profit.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetUserSalaryPlanListParam extends AbstractEncryParam {
    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
