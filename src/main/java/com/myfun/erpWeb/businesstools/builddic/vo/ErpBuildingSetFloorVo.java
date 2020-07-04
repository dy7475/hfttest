package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author czq
 * @since 2018/12/13
 */
public class ErpBuildingSetFloorVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键自增ID(楼层ID)")
    private Integer buildingSetFloorId;

    @ApiModelProperty(value = "楼盘ID")
    private Integer buildId;

    @ApiModelProperty(value = "栋ID")
    private Integer buildingSetRoofId;

    @ApiModelProperty(value = "单元ID")
    private Integer buildingSetUnitId;

    @ApiModelProperty(value = "用户输入的楼层(用来显示)")
    private String buildFloor;

    @ApiModelProperty(value = "本来是在几楼(前端原来排序)")
    private String sysBuildFloor;

    @ApiModelProperty(value = "楼层用途")
    private Byte floorUseage;

    @ApiModelProperty(value = "总楼层")
    private Integer floorCount;

    public Integer getBuildingSetFloorId() {
        return buildingSetFloorId;
    }

    public void setBuildingSetFloorId(Integer buildingSetFloorId) {
        this.buildingSetFloorId = buildingSetFloorId;
    }

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

    public String getBuildFloor() {
        return buildFloor;
    }

    public void setBuildFloor(String buildFloor) {
        this.buildFloor = buildFloor;
    }

    public String getSysBuildFloor() {
        return sysBuildFloor;
    }

    public void setSysBuildFloor(String sysBuildFloor) {
        this.sysBuildFloor = sysBuildFloor;
    }

    public Byte getFloorUseage() {
        return floorUseage;
    }

    public void setFloorUseage(Byte floorUseage) {
        this.floorUseage = floorUseage;
    }

    public Integer getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(Integer floorCount) {
        this.floorCount = floorCount;
    }
}