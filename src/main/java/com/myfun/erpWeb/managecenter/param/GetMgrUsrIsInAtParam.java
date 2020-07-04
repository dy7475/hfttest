package com.myfun.erpWeb.managecenter.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetMgrUsrIsInAtParam extends AbstractEncryParam {
    @ApiModelProperty(value = "公司id")
    private Integer compId;
    @ApiModelProperty(value = "用户id")
    private Integer userId;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
