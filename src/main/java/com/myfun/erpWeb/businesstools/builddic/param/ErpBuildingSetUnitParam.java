package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2018/12/14
 */
public class ErpBuildingSetUnitParam implements EncryParamIfc {

    @ApiModelProperty(value = "楼盘ID")
    private Integer buildId;

    @ApiModelProperty(value = "栋ID")
    private Integer buildingSetRoofId;

    @ApiModelProperty(value = "单元ID")
    private Integer buildingSetUnitId;

    @ApiModelProperty(value = "用户输入的单元名")
    private String buildUnit;

    @ApiModelProperty(value = "几梯")
    private String buildLadder;

    @ApiModelProperty(value = "几户")
    private String buildDoors;

    @ApiModelProperty(value = "楼层起")
    private Integer floorStart;

    @ApiModelProperty(value = "楼层止")
    private Integer floorEnd;

    @ApiModelProperty(value = "单元单位")
    private String buildUnitName;

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Integer getBuildingSetRoofId() {
        return buildingSetRoofId;
    }

    public void setBuildingSetRoofId(Integer buildingSetRoofId) {
        this.buildingSetRoofId = buildingSetRoofId;
    }

    public Integer getBuildingSetUnitId() {
        return buildingSetUnitId;
    }

    public void setBuildingSetUnitId(Integer buildingSetUnitId) {
        this.buildingSetUnitId = buildingSetUnitId;
    }

    public String getBuildUnit() {
        return buildUnit;
    }

    public void setBuildUnit(String buildUnit) {
        this.buildUnit = buildUnit;
    }

    public String getBuildLadder() {
        return buildLadder;
    }

    public void setBuildLadder(String buildLadder) {
        this.buildLadder = buildLadder;
    }

    public String getBuildDoors() {
        return buildDoors;
    }

    public void setBuildDoors(String buildDoors) {
        this.buildDoors = buildDoors;
    }

    public Integer getFloorStart() {
        return floorStart;
    }

    public void setFloorStart(Integer floorStart) {
        this.floorStart = floorStart;
    }

    public Integer getFloorEnd() {
        return floorEnd;
    }

    public void setFloorEnd(Integer floorEnd) {
        this.floorEnd = floorEnd;
    }

    public String getBuildUnitName() {
        return buildUnitName;
    }

    public void setBuildUnitName(String buildUnitName) {
        this.buildUnitName = buildUnitName;
    }
}