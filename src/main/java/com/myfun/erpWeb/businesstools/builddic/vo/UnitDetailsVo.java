package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author czq
 * @since 2019/3/26
 */
public class UnitDetailsVo implements Serializable {

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

    @ApiModelProperty(value = "房间是否生成完毕(1完毕）")
    private Byte roomGenerated;

    @ApiModelProperty(value = "精耕二期房号规则 " +
            "1=按楼层排号(相当于一期:numberRule=1, addedByAllUnits=0) " +
            "2=按单元排号(相当于一期:numberRule=2,addedByAllUnits=0) " +
            "3=按楼层多单元通排(相当于一期:numberRule=1,addedByAllUnits=1) " +
            "4=按单元多单元通排(相当于一期:numberRule=2,addedByAllUnits=1)")
    private Byte roomSortRule;

    @ApiModelProperty(value = "精耕二期房号组成规则 " +
            "1=数字(相当于一期:numberType=1, compriseRule=1, 房号: 1 2 3) " +
            "2=字母(相当于一期:numberType=2,compriseRule=1, 房号: A B C) " +
            "3=楼层加数字组合(相当于一期:numberType=1,compriseRule=2,房号:101 102 103) " +
            "4=楼层加字母组合(相当于一期:numberType=2,compriseRule=2,房号:1A 1B 1C)" +
            "5=楼层补0加字母组合(numberType=2,compriseRule=3(楼层补0),房号:10A 10B 10C)")
    private Byte roomCompositionRule;

    @ApiModelProperty(value = "房号起始")
    private String doorStart;

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

    public Byte getRoomGenerated() {
        return roomGenerated;
    }

    public void setRoomGenerated(Byte roomGenerated) {
        this.roomGenerated = roomGenerated;
    }

    public Byte getRoomSortRule() {
        return roomSortRule;
    }

    public void setRoomSortRule(Byte roomSortRule) {
        this.roomSortRule = roomSortRule;
    }

    public Byte getRoomCompositionRule() {
        return roomCompositionRule;
    }

    public void setRoomCompositionRule(Byte roomCompositionRule) {
        this.roomCompositionRule = roomCompositionRule;
    }

    public String getDoorStart() {
        return doorStart;
    }

    public void setDoorStart(String doorStart) {
        this.doorStart = doorStart;
    }
}