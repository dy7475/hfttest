package com.myfun.repository.erpdb.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class RoofInfoDto {
    @ApiModelProperty("栋座名")
    private String buildRoof;
    @ApiModelProperty("栋别名->单位")
    private String buildRoofName;
    @ApiModelProperty(value = "用途")
    private Integer houseUseage;
    @ApiModelProperty("维护人ID")
    private Integer userId;
    @ApiModelProperty(value = "建筑年代")
    private Integer houseYear;
    @ApiModelProperty(value = "单元数")
    private Integer units = 0;
    @ApiModelProperty(value = "户数")
    private Integer doors = 0;
    @ApiModelProperty("栋id")
    private Integer buildingSetRoofId;

    @ApiModelProperty(hidden = true)
    private Integer buildingManagerId;

    public Integer getBuildingManagerId() {
        return buildingManagerId;
    }

    public void setBuildingManagerId(Integer buildingManagerId) {
        this.buildingManagerId = buildingManagerId;
    }

    public String getBuildRoofName() {
        return buildRoofName;
    }

    public void setBuildRoofName(String buildRoofName) {
        this.buildRoofName = buildRoofName;
    }

    public Integer getBuildingSetRoofId() {
        return buildingSetRoofId;
    }

    public void setBuildingSetRoofId(Integer buildingSetRoofId) {
        this.buildingSetRoofId = buildingSetRoofId;
    }

    public Integer getHouseYear() {
        return houseYear;
    }

    public Integer getHouseUseage() {
        return houseUseage;
    }

    public void setHouseUseage(Integer houseUseage) {
        this.houseUseage = houseUseage;
    }

    public void setHouseYear(Integer houseYear) {
        this.houseYear = houseYear;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units == null ? 0 : units;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors == null ? 0 : doors;
    }

    public String getBuildRoof() {
        return buildRoof;
    }

    public void setBuildRoof(String buildRoof) {
        this.buildRoof = buildRoof;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
