package com.myfun.erpWeb.managecenter.financialLoan.vo;

import com.myfun.erpWeb.common.vo.BaseListResultVo;
import com.myfun.repository.admindb.po.AdminJrFinancePhoto;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class JrFinancePhotoVo extends BaseListResultVo {
	@ApiModelProperty(value = "列表")
	private List<AdminJrFinancePhoto> list;

	public List<AdminJrFinancePhoto> getList() {
		return list;
	}

	public void setList(List<AdminJrFinancePhoto> list) {
		this.list = list;
	}
}
