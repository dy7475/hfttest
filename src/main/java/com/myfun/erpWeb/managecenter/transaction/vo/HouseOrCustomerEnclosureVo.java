package com.myfun.erpWeb.managecenter.transaction.vo;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class HouseOrCustomerEnclosureVo {

	@ApiModelProperty("附件信息")
	private List<EnclosureVo> enclosureList;

	public List<EnclosureVo> getEnclosureList() {
		return enclosureList;
	}

	public void setEnclosureList(List<EnclosureVo> enclosureList) {
		this.enclosureList = enclosureList;
	}
	
	
}
