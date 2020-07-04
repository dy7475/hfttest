package com.myfun.erpWeb.managecenter.buildData.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author czq
 * @since 2019/4/28
 */
public class HouseTrackListVo implements Serializable {

    @ApiModelProperty("跟进内容")
    private String trackContent;

    @ApiModelProperty("跟进时间")
    private String trackTime;

    @ApiModelProperty("跟进人")
    private Integer createUid;

    @ApiModelProperty("楼盘资料ID外键")
    private Integer buildRuleId;

    @ApiModelProperty("单元栋号详细地址")
    private String address;

    @ApiModelProperty("楼盘ID")
    private Integer buildId;

    @ApiModelProperty(value = "栋")
    private String roof;

    @ApiModelProperty(value = "单元")
    private String unit;

    @ApiModelProperty(value = "楼")
    private String num;

    @ApiModelProperty(value = "号")
    private String house;

    @ApiModelProperty("楼盘名称")
    private String buildName;

    public String getTrackContent() {
        return trackContent;
    }

    public void setTrackContent(String trackContent) {
        this.trackContent = trackContent;
    }

    public String getTrackTime() {
        return trackTime;
    }

    public void setTrackTime(String trackTime) {
        this.trackTime = trackTime;
    }

    public Integer getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Integer createUid) {
        this.createUid = createUid;
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

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
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

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }
}