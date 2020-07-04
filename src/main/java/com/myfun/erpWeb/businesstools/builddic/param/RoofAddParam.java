package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author czq
 * @since 2019/3/20
 */
public class RoofAddParam implements EncryParamIfc {

    @ApiModelProperty(value = "楼盘ID", hidden = true)
    private Integer buildId;

    @ApiModelProperty(value = "栋名称(不带单位,比如A栋,传A)")
    private String buildRoof;

    @ApiModelProperty(value = "栋别名(默认:栋)", hidden = true)
    private String buildRoofName;

    @ApiModelProperty(value = "用途")
    private Integer houseUseage;

    @ApiModelProperty(value = "土地年限")
    private Integer buildLandAge;

    @ApiModelProperty(value = "建筑类型")
    private Integer houseType;

    @ApiModelProperty(value = "土地性质")
    private Integer buildLandNature;

    @ApiModelProperty(value = "权力性质")
    private Integer buildRightNature;

    @ApiModelProperty(value = "建筑年代")
    private Integer houseYear;

    @ApiModelProperty(value = "单元列表")
    private List<UnitAddParam> units;

    @ApiModelProperty(value = "单元别名(默认:单元)")
    private String buildUnitName;

    @ApiModelProperty(value = "单元前缀")
    private String unitPreFix;

    @ApiModelProperty(value = "排号规则 1=数字 2=字母 3=中文:甲乙丙")
    private Byte inunitSuffixType;

    public String getBuildRoof() {
        return buildRoof;
    }

    public void setBuildRoof(String buildRoof) {
        this.buildRoof = buildRoof;
    }

    public String getBuildRoofName() {
        return buildRoofName;
    }

    public void setBuildRoofName(String buildRoofName) {
        this.buildRoofName = buildRoofName;
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

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
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

    public Integer getHouseYear() {
        return houseYear;
    }

    public void setHouseYear(Integer houseYear) {
        this.houseYear = houseYear;
    }

    public List<UnitAddParam> getUnits() {
        return units;
    }

    public void setUnits(List<UnitAddParam> units) {
        this.units = units;
    }

    public String getBuildUnitName() {
        return buildUnitName;
    }

    public void setBuildUnitName(String buildUnitName) {
        this.buildUnitName = buildUnitName;
    }

    public String getUnitPreFix() {
        return unitPreFix;
    }

    public void setUnitPreFix(String unitPreFix) {
        this.unitPreFix = unitPreFix;
    }

    public Byte getInunitSuffixType() {
        return inunitSuffixType;
    }

    public void setInunitSuffixType(Byte inunitSuffixType) {
        this.inunitSuffixType = inunitSuffixType;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }
}