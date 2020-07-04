package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SettlementDealParam implements EncryParamIfc {
	@ApiModelProperty(value = "合同ID")
	private Integer dealId;
	@ApiModelProperty(value = "结算时间")
	private String dealVerifyTime;

	@ApiModelProperty("如果有共享中心审核配置, 选择的具体共享中心审核流程的ID")
	private Integer classId;

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public String getDealVerifyTime() {
		return dealVerifyTime;
	}

	public void setDealVerifyTime(String dealVerifyTime) {
		this.dealVerifyTime = dealVerifyTime;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}
}
