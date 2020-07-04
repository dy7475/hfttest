package com.myfun.erpWeb.businesstools.builddic.vo;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class ErpRegisterBuildingSetRoomVO  implements Serializable, Comparable<ErpRegisterBuildingSetRoomVO> {

    private static final long serialVersionUID = 1L;

    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键自增ID")
    private Integer buildingSetRoomId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "楼盘ID")
    private Integer buildId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房间ID")
    private String roomId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "几室")
    private Byte houseRoom;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "几厅")
    private Byte houseHall;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "几卫")
    private Byte houseWei;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "几厨")
    private Integer kitchen;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "阳台")
    private Byte houseYang;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "朝向，DD：HOUSE_DIRECT")
    private Byte houseDirect;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "建筑面积")
    private BigDecimal houseArea;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "套内面积")
    private BigDecimal houseInnerarea;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "栋座")
    private String buildRoof;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "单元")
    private String buildUnit;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房间所在楼层")
    private String roomFloor;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "合并房间号（一个单元从1~X）")
    private Integer mergeRoom;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "栋ID")
    private Integer buildingSetRoofId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "单元ID")
    private Integer buildingSetUnitId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "楼层ID")
    private Integer buildingSetFloorId;

    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否邻街，1=是0=否")
    private Byte nearStreet;

    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "前端计算出的房间ID")
    private String sysRoomId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    public Integer getKitchen() {
        return kitchen;
    }

    public void setKitchen(Integer kitchen) {
        this.kitchen = kitchen;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSysRoomId() {
        return sysRoomId;
    }

    public void setSysRoomId(String sysRoomId) {
        this.sysRoomId = sysRoomId;
    }

    public Integer getBuildingSetRoomId() {
        return buildingSetRoomId;
    }

    public void setBuildingSetRoomId(Integer buildingSetRoomId) {
        this.buildingSetRoomId = buildingSetRoomId;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Byte getHouseRoom() {
        return houseRoom;
    }

    public void setHouseRoom(Byte houseRoom) {
        this.houseRoom = houseRoom;
    }

    public Byte getHouseHall() {
        return houseHall;
    }

    public void setHouseHall(Byte houseHall) {
        this.houseHall = houseHall;
    }

    public Byte getHouseWei() {
        return houseWei;
    }

    public void setHouseWei(Byte houseWei) {
        this.houseWei = houseWei;
    }

    public Byte getHouseYang() {
        return houseYang;
    }

    public void setHouseYang(Byte houseYang) {
        this.houseYang = houseYang;
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

    public BigDecimal getHouseInnerarea() {
        return houseInnerarea;
    }

    public void setHouseInnerarea(BigDecimal houseInnerarea) {
        this.houseInnerarea = houseInnerarea;
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

    public String getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(String roomFloor) {
        this.roomFloor = roomFloor;
    }

    public Integer getMergeRoom() {
        return mergeRoom;
    }

    public void setMergeRoom(Integer mergeRoom) {
        this.mergeRoom = mergeRoom;
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

    public Byte getNearStreet() {
        return nearStreet;
    }

    public void setNearStreet(Byte nearStreet) {
        this.nearStreet = nearStreet;
    }

    /**
     * Compares two Dates for ordering.
     */
    public int compareTo(ErpRegisterBuildingSetRoomVO vo) {
        if (this.updateTime == null || vo==null || vo.updateTime==null)  {
            return 0;
        }
        return this.updateTime.compareTo(vo.updateTime);
    }
}
