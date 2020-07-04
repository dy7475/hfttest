package com.myfun.erpWeb.businesstools.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetBuildingRuleListParam extends AbstractEncryParam {
    @ApiModelProperty(value = "楼盘ID")
    private Integer buildId;
    @ApiModelProperty(value = "是否锁定")
    private Integer isLock;

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Integer getIsLock() {
        return isLock;
    }

    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }
}
