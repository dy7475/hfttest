package com.myfun.erpWeb.usercenter.vo;

import com.myfun.repository.admindb.dto.AdminFunDeptsDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "获取保证金门店列表VO")
public class DistBuildingListVo   implements Serializable {
	@ApiModelProperty("门店列表")
	private List<AdminFunDeptsDto> resultList;

	public List<AdminFunDeptsDto> getResultList() {
		return resultList;
	}

	public void setResultList(List<AdminFunDeptsDto> resultList) {
		this.resultList = resultList;
	}
}
