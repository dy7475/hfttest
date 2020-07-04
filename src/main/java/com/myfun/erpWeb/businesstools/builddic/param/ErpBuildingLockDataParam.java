package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

public class ErpBuildingLockDataParam implements EncryParamIfc {
    @ApiModelProperty(value = "楼盘ID")
    private Integer buildId;
    @ApiModelProperty(value = "栋座")
    private String buildRoof;
    @ApiModelProperty(value = "单元")
    private String buildUnit;
    @ApiModelProperty(value = "楼层")
    private String buildFloor;
    @ApiModelProperty(value = "房间")
    private String buildRoom;
    @ApiModelProperty(value = "用途")
    private Byte houseUseage;
    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public String getBuildRoof() {
        return buildRoof;
    }

    public void setBuildRoof(String buildRoof) {
        this.buildRoof = buildRoof;
    }

    public String getBuildUnit() {
        return buildUnit;
    }

    public void setBuildUnit(String buildUnit) {
        this.buildUnit = buildUnit;
    }

    public String getBuildFloor() {
        return buildFloor;
    }

    public void setBuildFloor(String buildFloor) {
        this.buildFloor = buildFloor;
    }

    public String getBuildRoom() {
        return buildRoom;
    }

    public void setBuildRoom(String buildRoom) {
        this.buildRoom = buildRoom;
    }

    public Byte getHouseUseage() {
        return houseUseage;
    }

    public void setHouseUseage(Byte houseUseage) {
        this.houseUseage = houseUseage;
    }
}
