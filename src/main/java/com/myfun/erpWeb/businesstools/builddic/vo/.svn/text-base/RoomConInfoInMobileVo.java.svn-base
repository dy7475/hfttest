package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author czq
 * @since 2019/4/10
 */
public class RoomConInfoInMobileVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "楼盘主键ID")
    private Integer buildId;

    @ApiModelProperty(value = "栋座名")
    private String buildingSetRoof;

    @ApiModelProperty(value = "单元名")
    private String buildingSetUnit;

    @ApiModelProperty(value = "楼层名")
    private String buildingSetFloor;

    @ApiModelProperty(value = "房间ID")
    private Integer buildingSetRoomId;

    @ApiModelProperty(value = "用户填的的房间ID(房间号),前端显示的房号")
    private String roomId;

    @ApiModelProperty(value = "系统房间ID")
    private String sysRoomId;

    @ApiModelProperty(value = "几室")
    private Byte houseRoom;

    @ApiModelProperty(value = "朝向，DD：HOUSE_DIRECT")
    private Byte houseDirect;

    @ApiModelProperty(value = "建筑面积")
    private BigDecimal houseArea;

    @ApiModelProperty(value = "房源信息列表")
    private List<RoomConInfoInMobileDetailsVo> funList;

    @ApiModelProperty(value = "房态表颜色显示 1=出售 2=出租 3=租售")
    private Byte showCaseType;

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

    public String getBuildingSetFloor() {
        return buildingSetFloor;
    }

    public void setBuildingSetFloor(String buildingSetFloor) {
        this.buildingSetFloor = buildingSetFloor;
    }

    public Integer getBuildingSetRoomId() {
        return buildingSetRoomId;
    }

    public void setBuildingSetRoomId(Integer buildingSetRoomId) {
        this.buildingSetRoomId = buildingSetRoomId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getSysRoomId() {
        return sysRoomId;
    }

    public void setSysRoomId(String sysRoomId) {
        this.sysRoomId = sysRoomId;
    }

    public Byte getHouseRoom() {
        return houseRoom;
    }

    public void setHouseRoom(Byte houseRoom) {
        this.houseRoom = houseRoom;
    }

    public Byte getHouseDirect() {
        return houseDirect;
    }

    public void setHouseDirect(Byte houseDirect) {
        this.houseDirect = houseDirect;
    }

    public BigDecimal getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(BigDecimal houseArea) {
        this.houseArea = houseArea;
    }

    public List<RoomConInfoInMobileDetailsVo> getFunList() {
        return funList;
    }

    public void setFunList(List<RoomConInfoInMobileDetailsVo> funList) {
        this.funList = funList;
    }

    public Byte getShowCaseType() {
        return showCaseType;
    }

    public void setShowCaseType(Byte showCaseType) {
        this.showCaseType = showCaseType;
    }
}