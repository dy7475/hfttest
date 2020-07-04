package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author czq
 * @since 2018/12/20
 */
public class ErpBuildingSetUnitDetailsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表主键")
    private Integer buildingSetUnitId;

    @ApiModelProperty(value = "栋ID(号位时没有)")
    private Integer buildingSetRoofId;

    @ApiModelProperty(value = "单元名")
    private String buildUnit;

    @ApiModelProperty(value = "单元别名(单位)")
    private String buildUnitName;

    @ApiModelProperty(value = "几梯")
    private String buildLadder;

    @ApiModelProperty(value = "几户")
    private String buildDoors;

    @ApiModelProperty(value = "楼层起")
    private Integer floorStart;

    @ApiModelProperty(value = "楼层止")
    private Integer floorEnd;

    @ApiModelProperty(value = "房号规则 1=按楼层排号，2=按单元排号")
    private Byte numberRule;

    @ApiModelProperty(value = "多单元通排")
    private Byte addedByAllUnits;

    @ApiModelProperty(value = "房号起始")
    private String doorStart;

    @ApiModelProperty(value = "组成规则 1(无)=户号，2(楼层)=楼层+户号")
    private Byte compriseRule;

    @ApiModelProperty(value = "组成规则 数字,字母")
    private Byte numberType;

    @ApiModelProperty(value = "房间是否生成完毕(1完毕）")
    private Byte roomGenerated;

    @ApiModelProperty(value = "前端显示的房号起始", hidden = true)
    private String doorStartInPage;

    public Integer getBuildingSetUnitId() {
        return buildingSetUnitId;
    }

    public void setBuildingSetUnitId(Integer buildingSetUnitId) {
        this.buildingSetUnitId = buildingSetUnitId;
    }

    public Integer getBuildingSetRoofId() {
        return buildingSetRoofId;
    }

    public void setBuildingSetRoofId(Integer buildingSetRoofId) {
        this.buildingSetRoofId = buildingSetRoofId;
    }

    public String getBuildUnit() {
        return buildUnit;
    }

    public void setBuildUnit(String buildUnit) {
        this.buildUnit = buildUnit;
    }

    public String getBuildUnitName() {
        return buildUnitName;
    }

    public void setBuildUnitName(String buildUnitName) {
        this.buildUnitName = buildUnitName;
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

    public String getDoorStart() {
        return doorStart;
    }

    public void setDoorStart(String doorStart) {
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

    public Byte getRoomGenerated() {
        return roomGenerated;
    }

    public void setRoomGenerated(Byte roomGenerated) {
        this.roomGenerated = roomGenerated;
    }

    public String getDoorStartInPage() {
        return doorStartInPage;
    }

    public void setDoorStartInPage(String doorStartInPage) {
        this.doorStartInPage = doorStartInPage;
    }
}