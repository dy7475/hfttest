package com.myfun.erpWeb.businesstools.builddic.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author czq
 * @since 2019/6/1
 */
public class CustomerByCaseIdVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("客源主键id")
    private Integer custId;

    @ApiModelProperty("房源类型,3=求购 4=求租")
    private Integer caseType;

    @ApiModelProperty("区域名字")
    private String regionName;

    @ApiModelProperty("范围名字")
    private String sectionName;

    @ApiModelProperty("客户姓名")
    private String custName;

    @ApiModelProperty(value = "客户性别，1=先生 0=女士")
    private Byte custSex;

    @ApiModelProperty(value = "房1")
    private Byte houseRoom;

    @ApiModelProperty(value = "房2")
    private Byte houseRoom1;

    @ApiModelProperty(value = "面积1")
    private BigDecimal houseAreaLow;

    @ApiModelProperty(value = "面积2")
    private BigDecimal houseAreaHigh;

    @ApiModelProperty(value = "售价1/租金1")
    private BigDecimal housePriceLow;

    @ApiModelProperty(value = "售价2/租金2")
    private BigDecimal housePriceHigh;

    @ApiModelProperty("房屋性质1=住宅2=别墅3=商铺4=写字楼5=厂房6=仓库7=车库")
    private String houseUseage;

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Integer getCaseType() {
        return caseType;
    }

    public void setCaseType(Integer caseType) {
        this.caseType = caseType;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Byte getCustSex() {
        return custSex;
    }

    public void setCustSex(Byte custSex) {
        this.custSex = custSex;
    }

    public Byte getHouseRoom() {
        return houseRoom;
    }

    public void setHouseRoom(Byte houseRoom) {
        this.houseRoom = houseRoom;
    }

    public Byte getHouseRoom1() {
        return houseRoom1;
    }

    public void setHouseRoom1(Byte houseRoom1) {
        this.houseRoom1 = houseRoom1;
    }

    public BigDecimal getHouseAreaLow() {
        return houseAreaLow;
    }

    public void setHouseAreaLow(BigDecimal houseAreaLow) {
        this.houseAreaLow = houseAreaLow;
    }

    public BigDecimal getHouseAreaHigh() {
        return houseAreaHigh;
    }

    public void setHouseAreaHigh(BigDecimal houseAreaHigh) {
        this.houseAreaHigh = houseAreaHigh;
    }

    public BigDecimal getHousePriceLow() {
        return housePriceLow;
    }

    public void setHousePriceLow(BigDecimal housePriceLow) {
        this.housePriceLow = housePriceLow;
    }

    public BigDecimal getHousePriceHigh() {
        return housePriceHigh;
    }

    public void setHousePriceHigh(BigDecimal housePriceHigh) {
        this.housePriceHigh = housePriceHigh;
    }

    public String getHouseUseage() {
        return houseUseage;
    }

    public void setHouseUseage(String houseUseage) {
        this.houseUseage = houseUseage;
    }
}