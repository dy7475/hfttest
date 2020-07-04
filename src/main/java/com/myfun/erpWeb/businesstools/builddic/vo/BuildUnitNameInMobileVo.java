package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author czq
 * @since 2019/4/3
 */
public class BuildUnitNameInMobileVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表主键(单元id)")
    private Integer buildingSetUnitId;

    @ApiModelProperty(value = "单元名或者号位名")
    private String buildUnit;

    @ApiModelProperty(value = "单元别名或者号位别名(单位)")
    private String buildUnitName;

    @ApiModelProperty(value = "排号规则 1=按楼层排号，2=按单元排号", hidden = true)
    private Byte numberRule;

    @ApiModelProperty(value = "排号类型 1=数字0~100，2=字母A~Z", hidden = true)
    private Byte numberType;

    @ApiModelProperty(value = "组成规则 1=户号，2=楼层+户号", hidden = true)
    private Byte compriseRule;

    @ApiModelProperty(value = "多单元通排", hidden = true)
    private Byte addedByAllUnits;

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

    public Integer getBuildingSetUnitId() {
        return buildingSetUnitId;
    }

    public void setBuildingSetUnitId(Integer buildingSetUnitId) {
        this.buildingSetUnitId = buildingSetUnitId;
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

    public Byte getNumberRule() {
        return numberRule;
    }

    public void setNumberRule(Byte numberRule) {
        this.numberRule = numberRule;
    }

    public Byte getNumberType() {
        return numberType;
    }

    public void setNumberType(Byte numberType) {
        this.numberType = numberType;
    }

    public Byte getCompriseRule() {
        return compriseRule;
    }

    public void setCompriseRule(Byte compriseRule) {
        this.compriseRule = compriseRule;
    }

    public Byte getAddedByAllUnits() {
        return addedByAllUnits;
    }

    public void setAddedByAllUnits(Byte addedByAllUnits) {
        this.addedByAllUnits = addedByAllUnits;
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
}