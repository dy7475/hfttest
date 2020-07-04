package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author czq
 * @since 2019/3/29
 */
public class RoomConInfoVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "楼盘主键ID")
    private Integer buildId;

    @ApiModelProperty(value = "用户填的的房间ID(房间号),前端显示的房号")
    private String roomId;

    @ApiModelProperty(value = "几室")
    private Byte houseRoom;

    @ApiModelProperty(value = "朝向，DD：HOUSE_DIRECT")
    private Byte houseDirect;

    @ApiModelProperty(value = "建筑面积")
    private BigDecimal houseArea;

    @ApiModelProperty(value = "租售类型 1=出售 2=出租")
    private Byte caseType;

    @ApiModelProperty(value = "出售房源ID")
    private Integer saleId;

    @ApiModelProperty(value = "出售房源编号")
    private String saleNo;

    @ApiModelProperty(value = "出售房源状态")
    private Byte saleStatus;

    @ApiModelProperty(value = "售价(单位:万元)")
    private BigDecimal salePrice;

    @ApiModelProperty(value = "出租房源ID")
    private Integer leaseId;

    @ApiModelProperty(value = "出租房源编号")
    private String leaseNo;

    @ApiModelProperty(value = "出租房源状态")
    private Byte leaseStatus;

    @ApiModelProperty(value = "租金")
    private BigDecimal leasePrice;

    @ApiModelProperty(value = "租金单位，DD:PRICE_UNIT")
    private Byte leasePriceUnit;

    @ApiModelProperty(value = "栋座名")
    private String buildingSetRoof;

    @ApiModelProperty(value = "单元名")
    private String buildingSetUnit;

    @ApiModelProperty(value = "楼层名")
    private String buildingSetFloor;

    @ApiModelProperty(value = "房间MD5", hidden = true)
    private String addrMd5;

    @ApiModelProperty(value = "栋别名(默认:栋)")
    private String buildRoofName;

    @ApiModelProperty(value = "单元别名(默认:单元)")
    private String buildUnitName;
    @ApiModelProperty(value = "出租方 1：业主，2：包租方，3：转租方")
    private Byte lessor;
    @ApiModelProperty(value = "组织业务类型 0=初始  1=住宅 2=工商铺 3=后勤部门")
    private Byte organizationBussinessType;
    
    public Byte getOrganizationBussinessType() {
        return organizationBussinessType;
    }
    
    public void setOrganizationBussinessType(Byte organizationBussinessType) {
        this.organizationBussinessType = organizationBussinessType;
    }
    
    public Byte getLessor() {
        return lessor;
    }

    public void setLessor(Byte lessor) {
        this.lessor = lessor;
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

    public Byte getCaseType() {
        return caseType;
    }

    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public String getSaleNo() {
        return saleNo;
    }

    public void setSaleNo(String saleNo) {
        this.saleNo = saleNo;
    }

    public Byte getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Byte saleStatus) {
        this.saleStatus = saleStatus;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(Integer leaseId) {
        this.leaseId = leaseId;
    }

    public String getLeaseNo() {
        return leaseNo;
    }

    public void setLeaseNo(String leaseNo) {
        this.leaseNo = leaseNo;
    }

    public Byte getLeaseStatus() {
        return leaseStatus;
    }

    public void setLeaseStatus(Byte leaseStatus) {
        this.leaseStatus = leaseStatus;
    }

    public BigDecimal getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(BigDecimal leasePrice) {
        this.leasePrice = leasePrice;
    }

    public Byte getLeasePriceUnit() {
        return leasePriceUnit;
    }

    public void setLeasePriceUnit(Byte leasePriceUnit) {
        this.leasePriceUnit = leasePriceUnit;
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

    public String getAddrMd5() {
        return addrMd5;
    }

    public void setAddrMd5(String addrMd5) {
        this.addrMd5 = addrMd5;
    }

    public String getBuildRoofName() {
        return buildRoofName;
    }

    public void setBuildRoofName(String buildRoofName) {
        this.buildRoofName = buildRoofName;
    }

    public String getBuildUnitName() {
        return buildUnitName;
    }

    public void setBuildUnitName(String buildUnitName) {
        this.buildUnitName = buildUnitName;
    }
}