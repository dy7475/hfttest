package com.myfun.erpWeb.managecenter.profit.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SalarySchemeListByTypeParam   extends AbstractEncryParam {
	@ApiModelProperty(value = "方案ID")
	private Integer wageTypeId;
	@ApiModelProperty(value = "提成类型")
	private Integer managePlan;
	@ApiModelProperty(value = "业绩类别，0=总业绩 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融")
	private Integer performanceType;
	@ApiModelProperty(value = "方案名称")
	private String wageTypeName;

	public Integer getWageTypeId() {
		return wageTypeId;
	}

	public void setWageTypeId(Integer wageTypeId) {
		this.wageTypeId = wageTypeId;
	}

	public Integer getManagePlan() {
		return managePlan;
	}

	public void setManagePlan(Integer managePlan) {
		this.managePlan = managePlan;
	}

	public Integer getPerformanceType() {
		return performanceType;
	}

	public void setPerformanceType(Integer performanceType) {
		this.performanceType = performanceType;
	}

	public String getWageTypeName() {
		return wageTypeName;
	}

	public void setWageTypeName(String wageTypeName) {
		this.wageTypeName = wageTypeName;
	}
}
