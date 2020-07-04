package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


public class ErpRegisterBuildingSetRoofparam implements EncryParamIfc {
    @ApiModelProperty("楼盘id")
    private Integer buildId;

    @ApiModelProperty("用途")
    private Integer houseUseage;

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Integer getHouseUseage() {
        return houseUseage;
    }

    public void setHouseUseage(Integer houseUseage) {
        this.houseUseage = houseUseage;
    }
}
