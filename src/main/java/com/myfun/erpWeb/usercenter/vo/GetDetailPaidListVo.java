package com.myfun.erpWeb.usercenter.vo;

import java.util.List;

import com.myfun.repository.admindb.dto.AdminFunPaidDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class GetDetailPaidListVo {

	@ApiModelProperty(value = "发票消费详情列表")
	private List<AdminFunPaidDto> list;

	public List<AdminFunPaidDto> getList() {
		return list;
	}

	public void setList(List<AdminFunPaidDto> list) {
		this.list = list;
	}
}