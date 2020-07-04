package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetRoofInfoParam implements EncryParamIfc {
    @ApiModelProperty("楼盘ID")
    private Integer buildId;
    @ApiModelProperty("栋座名 查号的时候不传")
    private String buildingSetRoof;
    @ApiModelProperty("号名 查栋的时候这个不传")
    private String buildingSetUnit;
    @ApiModelProperty("1:查询模板")
    private Integer isTmp;

    public Integer getIsTmp() {
        if (isTmp == null) {
            return 0;
        }
        return isTmp;
    }

    public String getBuildingSetRoof() {
        return buildingSetRoof;
    }

    public void setBuildingSetRoof(String buildingSetRoof) {
        this.buildingSetRoof = buildingSetRoof;
    }

    public String getBuildingSetUnit() {
        return buildingSetUnit;
    }

    public void setBuildingSetUnit(String buildingSetUnit) {
        this.buildingSetUnit = buildingSetUnit;
    }

    public void setIsTmp(Integer isTmp) {
        this.isTmp = isTmp;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

}
