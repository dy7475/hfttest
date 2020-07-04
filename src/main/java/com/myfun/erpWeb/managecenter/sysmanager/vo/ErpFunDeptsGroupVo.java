package com.myfun.erpWeb.managecenter.sysmanager.vo;

import java.util.List;

import com.myfun.repository.erpdb.dto.ErpFunDeptsgroupDto;

public class ErpFunDeptsGroupVo {

	private List<ErpFunDeptsgroupDto> funDeptsgroupList;

	public List<ErpFunDeptsgroupDto> getFunDeptsgroupList() {
		return funDeptsgroupList;
	}

	public void setFunDeptsgroupList(List<ErpFunDeptsgroupDto> funDeptsgroupList) {
		this.funDeptsgroupList = funDeptsgroupList;
	}
}
