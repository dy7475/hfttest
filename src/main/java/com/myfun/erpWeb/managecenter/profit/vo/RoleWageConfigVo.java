package com.myfun.erpWeb.managecenter.profit.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class RoleWageConfigVo implements Serializable {
	
    @ApiModelProperty("薪资配置ID")
    private Integer wageConfigId;

	public Integer getWageConfigId() {
		return wageConfigId;
	}

	public void setWageConfigId(Integer wageConfigId) {
		this.wageConfigId = wageConfigId;
	}
}
