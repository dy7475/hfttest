package com.myfun.erpWeb.managecenter.transaction.param;

import javax.validation.constraints.NotNull;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class QueryDepositDetailParam implements EncryParamIfc{
	@NotNull(message="定金id不能为空！")
	@ApiModelProperty("定金id")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
