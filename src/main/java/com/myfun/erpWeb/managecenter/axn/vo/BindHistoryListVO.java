package com.myfun.erpWeb.managecenter.axn.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BindHistoryListVO implements Serializable{
	
	@ApiModelProperty(value = "历史绑定列表")
	private List<BindHistoryVO> bindHistoryList;

	public List<BindHistoryVO> getBindHistoryList() {
		return bindHistoryList;
	}

	public void setBindHistoryList(List<BindHistoryVO> bindHistoryList) {
		this.bindHistoryList = bindHistoryList;
	}
	
}
