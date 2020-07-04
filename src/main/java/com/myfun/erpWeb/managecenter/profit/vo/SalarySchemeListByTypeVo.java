package com.myfun.erpWeb.managecenter.profit.vo;

import com.myfun.repository.erpdb.po.ErpFunWageTypeNew;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "获取薪资方案列表VO")
public class SalarySchemeListByTypeVo  implements Serializable {
	@ApiModelProperty("薪资方案列表")
	private List<ErpFunWageTypeNew> wageTypeList;

	public List<ErpFunWageTypeNew> getWageTypeList() {
		return wageTypeList;
	}

	public void setWageTypeList(List<ErpFunWageTypeNew> wageTypeList) {
		this.wageTypeList = wageTypeList;
	}
}
