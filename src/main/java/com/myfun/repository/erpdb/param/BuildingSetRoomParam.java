package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author czq
 * @since 2018/12/13
 */
public class BuildingSetRoomParam implements EncryParamIfc {

    @ApiModelProperty(value = "房间信息同步到本单元同房号户型(1同步)")
    private Integer sync;

    @ApiModelProperty(value = "楼盘ID")
    private Integer buildId;

    @ApiModelProperty(value = "栋ID")
    private Integer buildingSetRoofId;

    @ApiModelProperty(value = "单元ID")
    private Integer buildingSetUnitId;

    @ApiModelProperty(value = "楼层ID")
    private Integer buildingSetFloorId;

    @ApiModelProperty(value = "用户填的的房间ID")
    private String roomId;

    @ApiModelProperty(value = "几室")
    private Byte houseRoom;

    @ApiModelProperty(value = "几厅")
    private Byte houseHall;

    @ApiModelProperty(value = "几卫")
    private Byte houseWei;

    @ApiModelProperty(value = "阳台")
    private Byte houseYang;

    @ApiModelProperty(value = "朝向，DD：HOUSE_DIRECT")
    private Byte houseDirect;

    @ApiModelProperty(value = "建筑面积")
    private BigDecimal houseArea;

    @ApiModelProperty(value = "套内面积")
    private BigDecimal houseInnerarea;

    @ApiModelProperty(value = "房间户型图(以逗号分隔开)")
    private String photoUrls;

    @ApiModelProperty(value = "房间信息同步到本单元同房号户型的所有id,以逗号分隔")
    private String roomIds;

    @ApiModelProperty("是否替换已登记房源户型图 1=是")
    private Byte replacePhotos;
    @ApiModelProperty(value = "层高")
    private BigDecimal floorHeight;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "房屋结构 DD：HOUSE_GRADATION ")
    private Integer houseStructure;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "厕所类型 DD： TOILET_TYPE")
    private Integer toiletType;
    @ApiModelProperty(value = "厨房")
    private Integer kitchen;

    public Integer getKitchen() {
        return kitchen;
    }

    public void setKitchen(Integer kitchen) {
        this.kitchen = kitchen;
    }

    public BigDecimal getFloorHeight() {
        return floorHeight;
    }

    public void setFloorHeight(BigDecimal floorHeight) {
        this.floorHeight = floorHeight;
    }

    public Integer getHouseStructure() {
        return houseStructure;
    }

    public void setHouseStructure(Integer houseStructure) {
        this.houseStructure = houseStructure;
    }

    public Integer getToiletType() {
        return toiletType;
    }

    public void setToiletType(Integer toiletType) {
        this.toiletType = toiletType;
    }

    /**
     * @mbggenerated
     */

    public Integer getSync() {
        return sync;
    }

    public void setSync(Integer sync) {
        this.sync = sync;
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

    public Integer getBuildingSetFloorId() {
        return buildingSetFloorId;
    }

    public void setBuildingSetFloorId(Integer buildingSetFloorId) {
        this.buildingSetFloorId = buildingSetFloorId;
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

    public String getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String photoUrls) {
        this.photoUrls = photoUrls;
    }

    public String getRoomIds() {
        return roomIds;
    }

    public void setRoomIds(String roomIds) {
        this.roomIds = roomIds;
    }

    public Byte getReplacePhotos() {
        return replacePhotos;
    }

    public void setReplacePhotos(Byte replacePhotos) {
        this.replacePhotos = replacePhotos;
    }
}