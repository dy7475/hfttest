package com.myfun.erpWeb.managecenter.profit.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SalarySchemeUserListParam  extends AbstractEncryParam {
	@ApiModelProperty(value = "方案ID")
	private Integer wageTypeId;

	public Integer getWageTypeId() {
		return wageTypeId;
	}

	public void setWageTypeId(Integer wageTypeId) {
		this.wageTypeId = wageTypeId;
	}
}
