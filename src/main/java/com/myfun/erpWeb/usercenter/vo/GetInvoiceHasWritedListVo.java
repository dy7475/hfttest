package com.myfun.erpWeb.usercenter.vo;

import com.myfun.repository.admindb.dto.AdminFunPaidDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class GetInvoiceHasWritedListVo {

	@ApiModelProperty(value = "用户充值消费记录列表")
	private List<AdminFunPaidDto> list;

	public List<AdminFunPaidDto> getList() {
		return list;
	}

	public void setList(List<AdminFunPaidDto> list) {
		this.list = list;
	}
}