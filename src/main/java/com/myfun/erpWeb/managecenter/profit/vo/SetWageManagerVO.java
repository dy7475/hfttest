package com.myfun.erpWeb.managecenter.profit.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel
public class SetWageManagerVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "业绩类别列表")
	List<AppFunPerformanceTypeVO> performanceTypeList;

	public List<AppFunPerformanceTypeVO> getPerformanceTypeList() {
		return performanceTypeList;
	}

	public void setPerformanceTypeList(List<AppFunPerformanceTypeVO> performanceTypeList) {
		this.performanceTypeList = performanceTypeList;
	}
	
	

}
