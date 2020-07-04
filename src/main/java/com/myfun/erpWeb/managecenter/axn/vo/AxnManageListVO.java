package com.myfun.erpWeb.managecenter.axn.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AxnManageListVO implements Serializable{

	@ApiModelProperty(value = "号码列表")
	private List<AxnManageVO> axnManageList;

	@ApiModelProperty(value = "号码总数")
	private Integer totalNumber;
	
	@ApiModelProperty(value = "已绑定数")
	private Integer bindNumber;
	
	@ApiModelProperty(value = "未绑定数")
	private Integer unbindNumber;
	
	public List<AxnManageVO> getAxnManageList() {
		return axnManageList;
	}

	public void setAxnManageList(List<AxnManageVO> axnManageList) {
		this.axnManageList = axnManageList;
	}

	public Integer getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}

	public Integer getBindNumber() {
		return bindNumber;
	}

	public void setBindNumber(Integer bindNumber) {
		this.bindNumber = bindNumber;
	}

	public Integer getUnbindNumber() {
		return unbindNumber;
	}

	public void setUnbindNumber(Integer unbindNumber) {
		this.unbindNumber = unbindNumber;
	}
	
}
