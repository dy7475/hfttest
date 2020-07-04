package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetRoofInfoVo {
    @ApiModelProperty("单元数")
    private Integer units = 0;
    @ApiModelProperty("户数")
    private Integer doors = 0;
    @ApiModelProperty("用途")
    private Integer houseUseage;
    @ApiModelProperty("建筑年代")
    private Integer houseYear;
    @ApiModelProperty("在售量")
    private Integer saleCount = 0;
    @ApiModelProperty("在租量")
    private Integer leaseCount = 0;
    @ApiModelProperty("内成交量")
    private Integer innerDealCount = 0;
    @ApiModelProperty("外成交量")
    private Integer outerDealCount = 0;
    @ApiModelProperty("栋维护人")
    private Integer roofManager;
    @ApiModelProperty("栋id")
    private Integer buildingSetRoofId;
    @ApiModelProperty("户id")
    private Integer buildingSetUnitId;

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public Integer getHouseUseage() {
        return houseUseage;
    }

    public void setHouseUseage(Integer houseUseage) {
        this.houseUseage = houseUseage;
    }

    public Integer getHouseYear() {
        return houseYear;
    }

    public void setHouseYear(Integer houseYear) {
        this.houseYear = houseYear;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Integer getLeaseCount() {
        return leaseCount;
    }

    public void setLeaseCount(Integer leaseCount) {
        this.leaseCount = leaseCount;
    }

    public Integer getInnerDealCount() {
        return innerDealCount;
    }

    public void setInnerDealCount(Integer innerDealCount) {
        this.innerDealCount = innerDealCount;
    }

    public Integer getOuterDealCount() {
        return outerDealCount;
    }

    public void setOuterDealCount(Integer outerDealCount) {
        this.outerDealCount = outerDealCount;
    }

    public Integer getRoofManager() {
        return roofManager;
    }

    public void setRoofManager(Integer roofManager) {
        this.roofManager = roofManager;
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
}
