package com.myfun.erpWeb.managecenter.sysmanager.vo;

import java.util.List;

import com.myfun.repository.erpdb.dto.ErpFunAreaDto;

public class ErpFunAreaVo {
	
	private List<ErpFunAreaDto> areaList;

	public List<ErpFunAreaDto> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<ErpFunAreaDto> areaList) {
		this.areaList = areaList;
	}
}
