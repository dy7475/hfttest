package com.myfun.erpWeb.task.vo;

import com.myfun.utils.poCovert.annotation.CommonField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.solr.client.solrj.beans.Field;

import java.math.BigDecimal;

@ApiModel("房客源实体")
public class FunAndCustVO {
    @ApiModelProperty(value= "关联房客源ID")
    private Integer caseId;
    @ApiModelProperty(value= "关联房客源类型1出售2出租3求购4求租")
    private Byte caseType;
    @ApiModelProperty(value= "房源楼盘名字")
    private String buildName;
    @ApiModelProperty(value= "房源室")
    private Byte room;
    @ApiModelProperty(value= "房源厅")
    private Byte hall;
    @ApiModelProperty(value= "房源卫")
    private Byte wei;
    @ApiModelProperty(value= "房源面积")
    private BigDecimal area;
    @ApiModelProperty(value= "房源价格")
    private BigDecimal price;
    @ApiModelProperty(value= "房源经纪人名字")
    private String brokerUserName;
    @ApiModelProperty(value= "房源经纪人电话")
    private String brokerUserTel;
    @ApiModelProperty(value= "房源出租用价格单位 中文")
    private String priceUnitCn;
    @ApiModelProperty(value= "房源图片地址")
    private String picUrl;
    @ApiModelProperty(value= "客源姓名")
    private String custName;
    @ApiModelProperty("客源价格1")
    private BigDecimal housePriceLow;
    @ApiModelProperty("客源价格2")
    private BigDecimal housePriceHigh;
    @ApiModelProperty("客源面积1")
    private BigDecimal houseAreaLow;
    @ApiModelProperty("客源面积2")
    private BigDecimal houseAreaHigh;
    @ApiModelProperty(value= "客源意向小区名")
    private String custBuildName;
    @ApiModelProperty(value= "客源经纪人名字")
    private String custBrokerUserName;
    @ApiModelProperty(value= "客源经纪人电话")
    private String custBrokerUserTel;
    @ApiModelProperty(value= "客源室  例如：1-2室")
    private String custHouseRoom;

    public String getCustHouseRoom() {
        return custHouseRoom;
    }

    public void setCustHouseRoom(String custHouseRoom) {
        this.custHouseRoom = custHouseRoom;
    }

    public String getCustBrokerUserName() {
        return custBrokerUserName;
    }

    public void setCustBrokerUserName(String custBrokerUserName) {
        this.custBrokerUserName = custBrokerUserName;
    }

    public String getCustBrokerUserTel() {
        return custBrokerUserTel;
    }

    public void setCustBrokerUserTel(String custBrokerUserTel) {
        this.custBrokerUserTel = custBrokerUserTel;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
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

    public String getCustBuildName() {
        return custBuildName;
    }

    public void setCustBuildName(String custBuildName) {
        this.custBuildName = custBuildName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Byte getCaseType() {
        return caseType;
    }

    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
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

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBrokerUserName() {
        return brokerUserName;
    }

    public void setBrokerUserName(String brokerUserName) {
        this.brokerUserName = brokerUserName;
    }

    public String getBrokerUserTel() {
        return brokerUserTel;
    }

    public void setBrokerUserTel(String brokerUserTel) {
        this.brokerUserTel = brokerUserTel;
    }

    public String getPriceUnitCn() {
        return priceUnitCn;
    }

    public void setPriceUnitCn(String priceUnitCn) {
        this.priceUnitCn = priceUnitCn;
    }
}
