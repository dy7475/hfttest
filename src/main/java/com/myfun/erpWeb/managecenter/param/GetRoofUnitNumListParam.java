package com.myfun.erpWeb.managecenter.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetRoofUnitNumListParam implements EncryParamIfc {
    @ApiModelProperty(hidden = true)
    private Integer compId;
    @ApiModelProperty(value = "楼盘id")
    private Integer buildId;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }
}
