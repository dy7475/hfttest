package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class ErpbuildingSetUnitByRoofIdVO {
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "表主键")
    private Integer buildingSetUnitId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "栋座名称")
    private String buildRoof;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "栋ID")
    private Integer buildingSetRoofId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "单元名")
    private String buildUnit;

    public Integer getBuildingSetUnitId() {
        return buildingSetUnitId;
    }

    public void setBuildingSetUnitId(Integer buildingSetUnitId) {
        this.buildingSetUnitId = buildingSetUnitId;
    }

    public String getBuildRoof() {
        return buildRoof;
    }

    public void setBuildRoof(String buildRoof) {
        this.buildRoof = buildRoof;
    }

    public Integer getBuildingSetRoofId() {
        return buildingSetRoofId;
    }

    public void setBuildingSetRoofId(Integer buildingSetRoofId) {
        this.buildingSetRoofId = buildingSetRoofId;
    }

    public String getBuildUnit() {
        return buildUnit;
    }

    public void setBuildUnit(String buildUnit) {
        this.buildUnit = buildUnit;
    }
}
