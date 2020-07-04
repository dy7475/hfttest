package com.myfun.erpWeb.managecenter.profit.param;

import javax.validation.constraints.NotNull;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 分销模式的参数
 * @Package com.myfun.erpWeb.managecenter.profit.param 
 * @author 陈文超   
 * @date 2019年8月28日 下午8:46:42
 */
@ApiModel
public class ProfitDistributionParam implements EncryParamIfc {
	
	@ApiModelProperty("查询类型：1实发提成、2应发提成、3签约提成，默认：1")
    private Byte queryType = 1;
	
	@ApiModelProperty("查询月份，格式：2019-01，默认：当前月份")
    private String monthStr;
	
	@ApiModelProperty("被查询员工的userId")
	@NotNull
    private String userId;

	public Byte getQueryType() {
		return queryType;
	}

	public void setQueryType(Byte queryType) {
		this.queryType = queryType;
	}

	public String getMonthStr() {
		return monthStr;
	}

	public void setMonthStr(String monthStr) {
		this.monthStr = monthStr;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
