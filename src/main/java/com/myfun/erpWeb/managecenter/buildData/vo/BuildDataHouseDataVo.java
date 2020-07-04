package com.myfun.erpWeb.managecenter.buildData.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author czq
 * @since 2019/4/28
 */
public class BuildDataHouseDataVo implements Serializable {

    @ApiModelProperty("楼盘ID")
    private Integer buildId;

    @ApiModelProperty("楼盘名称")
    private String buildName;

    @ApiModelProperty("跟进时间")
    private String trackTime;

    @ApiModelProperty(value = "用途")
    private Byte useage;

    @ApiModelProperty("楼盘资料ID外键")
    private Integer buildRuleId;

    @ApiModelProperty("单元栋号详细地址")
    private String address;

    @ApiModelProperty(value = "栋")
    private String roof;

    @ApiModelProperty(value = "单元")
    private String unit;

    @ApiModelProperty(value = "楼")
    private String num;

    @ApiModelProperty(value = "号")
    private String house;

    @ApiModelProperty(value = "几室")
    private Byte room;

    @ApiModelProperty(value = "几厅")
    private Byte hall;

    @ApiModelProperty(value = "几卫")
    private Byte wei;

    @ApiModelProperty("房源编号")
    private String caseNo;

    @ApiModelProperty("房源ID")
    private Integer caseId;

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getTrackTime() {
        return trackTime;
    }

    public void setTrackTime(String trackTime) {
        this.trackTime = trackTime;
    }

    public Byte getUseage() {
        return useage;
    }

    public void setUseage(Byte useage) {
        this.useage = useage;
    }

    public Integer getBuildRuleId() {
        return buildRuleId;
    }

    public void setBuildRuleId(Integer buildRuleId) {
        this.buildRuleId = buildRuleId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public Byte getRoom() {
        return room;
    }

    public void setRoom(Byte room) {
        this.room = room;
    }

    public Byte getHall() {
        return hall;
    }

    public void setHall(Byte hall) {
        this.hall = hall;
    }

    public Byte getWei() {
        return wei;
    }

    public void setWei(Byte wei) {
        this.wei = wei;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }
}