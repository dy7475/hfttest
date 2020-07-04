package com.myfun.erpWeb.managecenter.transaction.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DepositListVO {

	private List<DepositVO> list;

	public List<DepositVO> getList() {
		return list;
	}

	public void setList(List<DepositVO> list) {
		this.list = list;
	}
}
