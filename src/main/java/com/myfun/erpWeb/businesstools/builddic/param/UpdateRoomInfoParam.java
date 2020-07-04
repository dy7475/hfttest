package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel
public class UpdateRoomInfoParam implements EncryParamIfc {

    @ApiModelProperty(value = "表ID")
    private Integer buildingSetRoomId;
    @ApiModelProperty(value = "房间信息同步到本单元同房号户型(1同步)")
    private Integer sync;
    @ApiModelProperty(value = "楼盘Id")
    private Integer buildId;
    @ApiModelProperty(value = "栋ID")
    private Integer buildingSetRoofId;
    @ApiModelProperty("单元id")
    private Integer buildingSetUnitId;
    @ApiModelProperty("楼层id")
    private Integer buildingSetFloorId;
    @ApiModelProperty(value = "用户填的房间ID")
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
    @ApiModelProperty(value = "房间信息同步到本单元同房号户型的所有房间的id,以逗号分隔")
    private String buildingSetRoomIds;
    @ApiModelProperty(value = "户型图地址 逗号隔开 不改的时候不传  全部删除了传空字符串")
    private String photoUrls;
    @ApiModelProperty(value = "是否邻街，1=是0=否")
    private Byte nearStreet;
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

    @ApiModelProperty(hidden = true)
    private Integer selfUserId;
    @ApiModelProperty(hidden = true)
    private Date updateTime;

    public Integer getBuildingSetFloorId() {
        return buildingSetFloorId;
    }

    public void setBuildingSetFloorId(Integer buildingSetFloorId) {
        this.buildingSetFloorId = buildingSetFloorId;
    }

    public Byte getReplacePhotos() {
        return replacePhotos;
    }

    public void setReplacePhotos(Byte replacePhotos) {
        this.replacePhotos = replacePhotos;
    }

    public Byte getNearStreet() {
        return nearStreet;
    }

    public void setNearStreet(Byte nearStreet) {
        this.nearStreet = nearStreet;
    }

    public String getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String photoUrls) {
        this.photoUrls = photoUrls;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public String getBuildingSetRoomIds() {
        return buildingSetRoomIds;
    }

    public void setBuildingSetRoomIds(String buildingSetRoomIds) {
        this.buildingSetRoomIds = buildingSetRoomIds;
    }

    public Integer getSelfUserId() {
        return selfUserId;
    }

    public void setSelfUserId(Integer selfUserId) {
        this.selfUserId = selfUserId;
    }
}
