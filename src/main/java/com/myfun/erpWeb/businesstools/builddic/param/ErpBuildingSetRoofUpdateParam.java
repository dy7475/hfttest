package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2018/12/14
 */
public class ErpBuildingSetRoofUpdateParam implements EncryParamIfc {

    @ApiModelProperty(value = "楼盘ID")
    private Integer buildId;

    @ApiModelProperty(value = "栋ID")
    private Integer buildingSetRoofId;

    @ApiModelProperty(value = "栋座名称(单个添加时使用)")
    private String buildRoof;

    @ApiModelProperty(value = "建筑结构")
    private Integer houseStruct;

    @ApiModelProperty(value = "建筑年代")
    private Integer houseYear;

    @ApiModelProperty(value = "建筑类型")
    private Integer houseType;

    @ApiModelProperty(value = "用途")
    private Integer houseUseage;

    @ApiModelProperty(value = "土地年限")
    private Integer buildLandAge;

    @ApiModelProperty(value = "土地性质")
    private Integer buildLandNature;

    @ApiModelProperty(value = "权力性质")
    private Integer buildRightNature;

    @ApiModelProperty(value = "栋管理员ID")
    private Integer buildingManagerId;

    @ApiModelProperty(value = "栋别名")
    private String buildRoofName;

    @ApiModelProperty(value = "单元别名(默认:单元)", hidden = true)
    private String buildUnitName;

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

    public String getBuildRoof() {
        return buildRoof;
    }

    public void setBuildRoof(String buildRoof) {
        this.buildRoof = buildRoof;
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

    public Integer getHouseUseage() {
        return houseUseage;
    }

    public void setHouseUseage(Integer houseUseage) {
        this.houseUseage = houseUseage;
    }

    public Integer getBuildLandAge() {
        return buildLandAge;
    }

    public void setBuildLandAge(Integer buildLandAge) {
        this.buildLandAge = buildLandAge;
    }

    public Integer getBuildLandNature() {
        return buildLandNature;
    }

    public void setBuildLandNature(Integer buildLandNature) {
        this.buildLandNature = buildLandNature;
    }

    public Integer getBuildRightNature() {
        return buildRightNature;
    }

    public void setBuildRightNature(Integer buildRightNature) {
        this.buildRightNature = buildRightNature;
    }

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

    public String getBuildUnitName() {
        return buildUnitName;
    }

    public void setBuildUnitName(String buildUnitName) {
        this.buildUnitName = buildUnitName;
    }
}