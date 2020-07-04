package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetRoomConInfoParam implements EncryParamIfc {

    @ApiModelProperty("楼盘ID")
    private Integer buildId;
    @ApiModelProperty("楼盘栋座名  号时不传")
    private String buildingSetRoof;
    @ApiModelProperty("单元名")
    private String buildingSetUnit;

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
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
}
