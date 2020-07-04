package com.myfun.erpWeb.managecenter.sysmanager.vo;

import java.util.List;

import com.myfun.repository.erpdb.dto.ErpFunDeptsDto;

public class ErpFunDeptsVo {

	private List<ErpFunDeptsDto> funDeptsList;

	public List<ErpFunDeptsDto> getFunDeptsList() {
		return funDeptsList;
	}

	public void setFunDeptsList(List<ErpFunDeptsDto> funDeptsList) {
		this.funDeptsList = funDeptsList;
	}
}
