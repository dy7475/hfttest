package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2019/3/26
 */
public class UnitSingleAddParam implements EncryParamIfc {

    @ApiModelProperty(value = "楼盘ID")
    private Integer buildId;

    @ApiModelProperty(value = "栋ID(添加号位时不传)")
    private Integer buildingSetRoofId;

    @ApiModelProperty(value = "单元名称(不带单位,比如A单元,传A)")
    private String buildUnit;

    @ApiModelProperty(value = "单元别名(默认:单元)")
    private String buildUnitName;

    @ApiModelProperty(value = "梯")
    private String buildLadder;

    @ApiModelProperty(value = "户")
    private String buildDoors;

    @ApiModelProperty(value = "楼层起(地下楼层传负数,例如地下2层: -2)")
    private Integer floorStart;

    @ApiModelProperty(value = "楼层止")
    private Integer floorEnd;

    @ApiModelProperty(value = "房号规则 1=按楼层排号，2=按单元排号", hidden = true)
    private Byte numberRule;

    @ApiModelProperty(value = "多单元通排", hidden = true)
    private Byte addedByAllUnits;

    @ApiModelProperty(value = "组成规则 1(无)=户号，2(楼层)=楼层+户号", hidden = true)
    private Byte compriseRule;

    @ApiModelProperty(value = "组成规则 数字,字母", hidden = true)
    private Byte numberType;

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