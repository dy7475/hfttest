package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


public class ErpRegisterBuildingSetRoofVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "栋座id表主键")
    private Integer buildingSetRoofId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "楼盘ID")
    private Integer buildId;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "栋座名称")
    private String buildRoof;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "建筑结构")
    private Integer houseStruct;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "建筑年代")
    private Integer houseYear;
    /**
     * @mbggenerated
     */
    @ApiModelProperty(value = "建筑类型")
    private Integer houseType;

    @ApiModelProperty("用途")
    private Integer houseUseage;

    public Integer getHouseUseage() {
        return houseUseage;
    }

    public void setHouseUseage(Integer houseUseage) {
        this.houseUseage = houseUseage;
    }

    public Integer getBuildingSetRoofId() {
        return buildingSetRoofId;
    }

    public void setBuildingSetRoofId(Integer buildingSetRoofId) {
        this.buildingSetRoofId = buildingSetRoofId;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Integer getHouseStruct() {
        return houseStruct;
    }

    public void setHouseStruct(Integer houseStruct) {
        this.houseStruct = houseStruct;
    }

    public Integer getHouseYear() {
        return houseYear;
    }

    public void setHouseYear(Integer houseYear) {
        this.houseYear = houseYear;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public String getBuildRoof() {
        return buildRoof;
    }

    public void setBuildRoof(String buildRoof) {
        this.buildRoof = buildRoof;
    }
}
