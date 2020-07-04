package com.myfun.erpWeb.managecenter.profit.vo;

import com.myfun.repository.erpdb.dto.ErpFunBasewageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "获取薪资方案列表VO")
public class SalarySchemeListByUserVo  implements Serializable {
	@ApiModelProperty("薪资方案列表")
	private List<ErpFunBasewageDto> funBasewageList;

	public List<ErpFunBasewageDto> getFunBasewageList() {
		return funBasewageList;
	}

	public void setFunBasewageList(List<ErpFunBasewageDto> funBasewageList) {
		this.funBasewageList = funBasewageList;
	}
}
