package com.myfun.repository.erpdb.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2018/12/28
 */
public class RoomWithBuildFloorDto {

    @ApiModelProperty(value = "主键自增ID(房间ID)")
    private Integer buildingSetRoomId;

    @ApiModelProperty(value = "栋ID")
    private Integer buildingSetRoofId;

    @ApiModelProperty(value = "单元ID")
    private Integer buildingSetUnitId;

    @ApiModelProperty(value = "楼层ID")
    private Integer buildingSetFloorId;

    @ApiModelProperty(value = "后端计算出的房间ID")
    private String sysRoomId;

    @ApiModelProperty(value = "用户填的的房间ID")
    private String roomId;

    @ApiModelProperty(value = "栋座名称")
    private String buildRoof;

    @ApiModelProperty(value = "单元名")
    private String buildUnit;

    @ApiModelProperty(value = "用户填的楼层名")
    private String buildFloor;

    public Integer getBuildingSetRoomId() {
        return buildingSetRoomId;
    }

    public void setBuildingSetRoomId(Integer buildingSetRoomId) {
        this.buildingSetRoomId = buildingSetRoomId;
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

    public Integer getBuildingSetFloorId() {
        return buildingSetFloorId;
    }

    public void setBuildingSetFloorId(Integer buildingSetFloorId) {
        this.buildingSetFloorId = buildingSetFloorId;
    }

    public String getSysRoomId() {
        return sysRoomId;
    }

    public void setSysRoomId(String sysRoomId) {
        this.sysRoomId = sysRoomId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
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
}