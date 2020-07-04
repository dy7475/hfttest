package com.myfun.erpWeb.managecenter.axn.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class PoolNameListVO implements Serializable {

	@ApiModelProperty(value = "号池名称列表")
	private List<PoolNameVO> poolNameList;

	public List<PoolNameVO> getPoolNameList() {
		return poolNameList;
	}

	public void setPoolNameList(List<PoolNameVO> poolNameList) {
		this.poolNameList = poolNameList;
	}
}
