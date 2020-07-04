package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetBuildBaseInfoParam implements EncryParamIfc {

    @ApiModelProperty("楼盘ID")
    private Integer buildId;
    @ApiModelProperty("1:查询模板")
    private Integer isTmp;

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Integer getIsTmp() {
        return isTmp;
    }

    public void setIsTmp(Integer isTmp) {
        this.isTmp = isTmp;
    }
}
