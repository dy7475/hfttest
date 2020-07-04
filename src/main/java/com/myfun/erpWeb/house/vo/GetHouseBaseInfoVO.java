package com.myfun.erpWeb.house.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author HuangJiang
 * @since 2019年11月25日 14:05:20
 * Modified XXX HuangJiang 2019年11月25日
 */
@ApiModel
public class GetHouseBaseInfoVO {
    @ApiModelProperty(value = "是否是租售房源，1=是，0=否")
    private Integer isSaleLease;
    @ApiModelProperty(value = "产权地址")
    private String houseAddr;
    @ApiModelProperty(value = "是否开启电子委托 0=否 1=是")
    private String isOpenElectronicEntrust;
    @ApiModelProperty(value = "租售房源委托资料是否共用 0=否 1=是")
    private String isShareEntrustData;
    @ApiModelProperty(value = "委托资料的房屋说明书是否必填 1=是 0=否 默认1")
    private Byte entrustHouseInstruction;
    @ApiModelProperty(value = "委托资料的房屋说明书是否必填 1=是 0=否 默认1")
    private Integer cityId;
    @ApiModelProperty(value = "委托资料的房屋说明书是否必填 1=是 0=否 默认1")
    private String cityName;
    @ApiModelProperty(value = "物业情况 建筑面积")
    private String propertySituation;
    
    public Byte getEntrustHouseInstruction() {
        return entrustHouseInstruction;
    }
    
    public void setEntrustHouseInstruction(Byte entrustHouseInstruction) {
        this.entrustHouseInstruction = entrustHouseInstruction;
    }
    
    public String getIsOpenElectronicEntrust() {
        return isOpenElectronicEntrust;
    }
    
    public void setIsOpenElectronicEntrust(String isOpenElectronicEntrust) {
        this.isOpenElectronicEntrust = isOpenElectronicEntrust;
    }
    
    public String getIsShareEntrustData() {
        return isShareEntrustData;
    }
    
    public void setIsShareEntrustData(String isShareEntrustData) {
        this.isShareEntrustData = isShareEntrustData;
    }
    
    public Integer getIsSaleLease() {
        return isSaleLease;
    }
    
    public void setIsSaleLease(Integer isSaleLease) {
        this.isSaleLease = isSaleLease;
    }
    
    public String getHouseAddr() {
        return houseAddr;
    }
    
    public void setHouseAddr(String houseAddr) {
        this.houseAddr = houseAddr;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPropertySituation() {
        return propertySituation;
    }

    public void setPropertySituation(String propertySituation) {
        this.propertySituation = propertySituation;
    }
}
