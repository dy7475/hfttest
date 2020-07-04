package com.myfun.erpWeb.managecenter.sysmanager.vo;

import java.util.List;

import com.myfun.repository.erpdb.dto.ErpFunRegionDto;

public class ErpFunRegionVo {

	private List<ErpFunRegionDto> funRegionList;

	public List<ErpFunRegionDto> getFunRegionList() {
		return funRegionList;
	}

	public void setFunRegionList(List<ErpFunRegionDto> funRegionList) {
		this.funRegionList = funRegionList;
	}
}
