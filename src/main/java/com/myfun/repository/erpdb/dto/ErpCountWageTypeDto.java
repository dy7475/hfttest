package com.myfun.repository.erpdb.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "用于查询个人战绩中个人的提成比例参数")
public class ErpCountWageTypeDto implements Serializable{

    @ApiModelProperty("用户ID")
    private Integer userId;
    
    @ApiModelProperty("ROLE_WAGETYPE_RELATIVE的ID，用于查询个人提成比例数据")
    private Integer wagetypeRelativeId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getWagetypeRelativeId() {
		return wagetypeRelativeId;
	}

	public void setWagetypeRelativeId(Integer wagetypeRelativeId) {
		this.wagetypeRelativeId = wagetypeRelativeId;
	}
}
