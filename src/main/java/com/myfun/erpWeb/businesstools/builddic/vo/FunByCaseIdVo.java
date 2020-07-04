package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author czq
 * @since 2019/4/11
 */
public class FunByCaseIdVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("房源主键id")
    private Integer caseId;

    @ApiModelProperty("房源类型,1=出售2=出租")
    private Integer caseType;

    @ApiModelProperty("房源创建时间")
    private String creationTime;

    @ApiModelProperty("楼盘Id")
    private Integer buildId;

    @ApiModelProperty("楼盘名称")
    private String buildName;

    @ApiModelProperty("区域名字")
    private String regionName;

    @ApiModelProperty("范围名字")
    private String sectionName;

    @ApiModelProperty("配套及特色")
    private String houseCharact;

    @ApiModelProperty("房屋性质1=住宅2=别墅3=商铺4=写字楼5=厂房6=仓库7=车库")
    private Byte houseUseage;

    @ApiModelProperty("几室")
    private Byte houseRoom;

    @ApiModelProperty("几厅")
    private Byte houseHall;

    @ApiModelProperty("几卫")
    private Byte houseWei;

    @ApiModelProperty("阳台")
    private Byte houseYang;

    @ApiModelProperty("房屋面积")
    private BigDecimal houseArea;

    @ApiModelProperty("楼层")
    private Short houseFloor;

    @ApiModelProperty("总楼层")
    private Integer houseFloors;

    @ApiModelProperty("房屋最高价")
    private BigDecimal houseTotalPrice;

    @ApiModelProperty("房屋最低价")
    private BigDecimal houseLowestPrice;

    @ApiModelProperty("租金单位，DD:PRICE_UNIT")
    private Byte priceUnit;

    @ApiModelProperty("首图路径")
    private String thumbUrl;

    @ApiModelProperty(value = "VR显示标记 0=不显示（crm审核不通过） 1=显示")
    private Byte hasPanorama;

    @ApiModelProperty(value = "视频数量，Def：0")
    private Byte videoNum;

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Integer getCaseType() {
        return caseType;
    }

    public void setCaseType(Integer caseType) {
        this.caseType = caseType;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getHouseCharact() {
        return houseCharact;
    }

    public void setHouseCharact(String houseCharact) {
        this.houseCharact = houseCharact;
    }

    public Byte getHouseUseage() {
        return houseUseage;
    }

    public void setHouseUseage(Byte houseUseage) {
        this.houseUseage = houseUseage;
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

    public BigDecimal getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(BigDecimal houseArea) {
        this.houseArea = houseArea;
    }

    public Short getHouseFloor() {
        return houseFloor;
    }

    public void setHouseFloor(Short houseFloor) {
        this.houseFloor = houseFloor;
    }

    public Integer getHouseFloors() {
        return houseFloors;
    }

    public void setHouseFloors(Integer houseFloors) {
        this.houseFloors = houseFloors;
    }

    public BigDecimal getHouseTotalPrice() {
        return houseTotalPrice;
    }

    public void setHouseTotalPrice(BigDecimal houseTotalPrice) {
        this.houseTotalPrice = houseTotalPrice;
    }

    public BigDecimal getHouseLowestPrice() {
        return houseLowestPrice;
    }

    public void setHouseLowestPrice(BigDecimal houseLowestPrice) {
        this.houseLowestPrice = houseLowestPrice;
    }

    public Byte getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(Byte priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public Byte getHasPanorama() {
        return hasPanorama;
    }

    public void setHasPanorama(Byte hasPanorama) {
        this.hasPanorama = hasPanorama;
    }

    public Byte getVideoNum() {
        return videoNum;
    }

    public void setVideoNum(Byte videoNum) {
        this.videoNum = videoNum;
    }
}