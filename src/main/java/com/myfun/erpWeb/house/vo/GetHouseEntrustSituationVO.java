package com.myfun.erpWeb.house.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author HuangJiang
 * @since 2019年11月25日 10:03:31
 * Modified XXX HuangJiang 2019年11月25日
 */
@ApiModel
public class GetHouseEntrustSituationVO {
    
    @ApiModelProperty(value = "有无历史委托 0=无；1=有")
    private Integer hasHisEntrust;
    @ApiModelProperty(value = "有无当前委托 0=无；1=有")
    private Integer hasEffectiveEntrust;
    @ApiModelProperty(value = "能否新增委托 0=无；1=有")
    private Integer canAddEntrust;
    
    public Integer getHasHisEntrust() {
        return hasHisEntrust;
    }
    
    public void setHasHisEntrust(Integer hasHisEntrust) {
        this.hasHisEntrust = hasHisEntrust;
    }
    
    public Integer getHasEffectiveEntrust() {
        return hasEffectiveEntrust;
    }
    
    public void setHasEffectiveEntrust(Integer hasEffectiveEntrust) {
        this.hasEffectiveEntrust = hasEffectiveEntrust;
    }
    
    public Integer getCanAddEntrust() {
        return canAddEntrust;
    }
    
    public void setCanAddEntrust(Integer canAddEntrust) {
        this.canAddEntrust = canAddEntrust;
    }
}
