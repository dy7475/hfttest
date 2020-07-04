package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DealCodeListParam extends AbstractEncryParam {
	@ApiModelProperty(value = "合同类别101出售102出租")
	private Integer dealType;
	@ApiModelProperty(value = "合同编号")
	private String contractNo;
	@ApiModelProperty(value = "门店ID")
	private Integer deptId;

	public Integer getDealType() {
		return dealType;
	}

	public void setDealType(Integer dealType) {
		this.dealType = dealType;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
}
