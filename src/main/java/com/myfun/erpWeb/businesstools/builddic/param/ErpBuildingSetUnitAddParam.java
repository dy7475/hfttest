package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2018/12/14
 */
public class ErpBuildingSetUnitAddParam implements EncryParamIfc {

    @ApiModelProperty(value = "楼盘ID")
    private Integer buildId;

    @ApiModelProperty(value = "栋ID(添加号位时不传)")
    private Integer buildingSetRoofId;

    @ApiModelProperty(value = "栋名称(添加号位时不传)")
    private String buildRoof;

    @ApiModelProperty(value = "单元名称或者号位名称(单个添加时使用)")
    private String buildUnit;

    @ApiModelProperty(value = "单元前缀")
    private String unitPreFix;

    @ApiModelProperty(value = "单元起")
    private String unitSuffixStart;

    @ApiModelProperty(value = "单元止")
    private String unitSuffixEnd;

    @ApiModelProperty(value = "数字或字母(单元)")
    private Byte inunitSuffixType;

    @ApiModelProperty(value = "单元别名(单位)")
    private String buildUnitName;

    @ApiModelProperty(value = "楼层起")
    private Integer floorStart;

    @ApiModelProperty(value = "楼层止")
    private Integer floorEnd;

    @ApiModelProperty(value = "几梯")
    private String buildLadder;

    @ApiModelProperty(value = "几户")
    private String buildDoors;

    @ApiModelProperty(value = "房号规则 1=按楼层排号，2=按单元排号")
    private Byte numberRule;

    @ApiModelProperty(value = "多单元通排")
    private Byte addedByAllUnits;

    @ApiModelProperty(value = "房号起始")
    private Integer doorStart;

    @ApiModelProperty(value = "组成规则 1(无)=户号，2(楼层)=楼层+户号")
    private Byte compriseRule;

    @ApiModelProperty(value = "组成规则 数字,字母")
    private Byte numberType;

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

    public String getBuildUnit() {
        return buildUnit;
    }

    public void setBuildUnit(String buildUnit) {
        this.buildUnit = buildUnit;
    }

    public String getUnitPreFix() {
        return unitPreFix;
    }

    public void setUnitPreFix(String unitPreFix) {
        this.unitPreFix = unitPreFix;
    }

    public String getUnitSuffixStart() {
        return unitSuffixStart;
    }

    public void setUnitSuffixStart(String unitSuffixStart) {
        this.unitSuffixStart = unitSuffixStart;
    }

    public String getUnitSuffixEnd() {
        return unitSuffixEnd;
    }

    public void setUnitSuffixEnd(String unitSuffixEnd) {
        this.unitSuffixEnd = unitSuffixEnd;
    }

    public Byte getInunitSuffixType() {
        return inunitSuffixType;
    }

    public void setInunitSuffixType(Byte inunitSuffixType) {
        this.inunitSuffixType = inunitSuffixType;
    }

    public String getBuildUnitName() {
        return buildUnitName;
    }

    public void setBuildUnitName(String buildUnitName) {
        this.buildUnitName = buildUnitName;
    }

    public Integer getFloorStart() {
        return floorStart;
    }

    public void setFloorStart(Integer floorStart) {
        this.floorStart = floorStart;
    }

    public Integer getFloorEnd() {
        return floorEnd;
    }

    public void setFloorEnd(Integer floorEnd) {
        this.floorEnd = floorEnd;
    }

    public String getBuildLadder() {
        return buildLadder;
    }

    public void setBuildLadder(String buildLadder) {
        this.buildLadder = buildLadder;
    }

    public String getBuildDoors() {
        return buildDoors;
    }

    public void setBuildDoors(String buildDoors) {
        this.buildDoors = buildDoors;
    }

    public Byte getNumberRule() {
        return numberRule;
    }

    public void setNumberRule(Byte numberRule) {
        this.numberRule = numberRule;
    }

    public Byte getAddedByAllUnits() {
        return addedByAllUnits;
    }

    public void setAddedByAllUnits(Byte addedByAllUnits) {
        this.addedByAllUnits = addedByAllUnits;
    }

    public Integer getDoorStart() {
        return doorStart;
    }

    public void setDoorStart(Integer doorStart) {
        this.doorStart = doorStart;
    }

    public Byte getCompriseRule() {
        return compriseRule;
    }

    public void setCompriseRule(Byte compriseRule) {
        this.compriseRule = compriseRule;
    }

    public Byte getNumberType() {
        return numberType;
    }

    public void setNumberType(Byte numberType) {
        this.numberType = numberType;
    }
}