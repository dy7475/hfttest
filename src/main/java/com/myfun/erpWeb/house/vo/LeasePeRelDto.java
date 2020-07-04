package com.myfun.erpWeb.house.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class LeasePeRelDto implements Serializable {

    @ApiModelProperty("表id")
    private Integer leaseRelativeId;
    @ApiModelProperty("相关人类型，1=登记人 2=维护人 3=钥匙人  4=房堪人  5=委托人  6=议价人  7=楼盘责任人")
    private Integer peopleType;
    @ApiModelProperty("相关人对应的用户id")
    private Integer userId;
    @ApiModelProperty("相关人对应的用户名")
    private String userName;
    @ApiModelProperty("电话")
    private String userMobile;
    @ApiModelProperty("门店名称")
    private String deptName;
    @ApiModelProperty("委托类型 1=现实  0=独家")
    private Integer entrustType;
    @ApiModelProperty("")
    private String grName;
    @ApiModelProperty("业绩分配比例")
    private BigDecimal performanceProportion;

    public Integer getLeaseRelativeId() {
        return leaseRelativeId;
    }

    public void setLeaseRelativeId(Integer leaseRelativeId) {
        this.leaseRelativeId = leaseRelativeId;
    }

    public Integer getPeopleType() {
        return peopleType;
    }

    public void setPeopleType(Integer peopleType) {
        this.peopleType = peopleType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getEntrustType() {
        return entrustType;
    }

    public void setEntrustType(Integer entrustType) {
        this.entrustType = entrustType;
    }

    public String getGrName() {
        return grName;
    }

    public void setGrName(String grName) {
        this.grName = grName;
    }

    public BigDecimal getPerformanceProportion() {
        return performanceProportion;
    }

    public void setPerformanceProportion(BigDecimal performanceProportion) {
        this.performanceProportion = performanceProportion;
    }
}
