package com.myfun.erpWeb.managecenter.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ContractParam implements EncryParamIfc {
	@ApiModelProperty(value = "买卖、租赁合同编号分开判重")
	private String saleRentDealRepeat;
	@ApiModelProperty(value = "允许手动录入未使用的自动分配的合同编号")
	private String allowUnuseDealnoIsbyhand;
	@ApiModelProperty(value = "作废的合同编号可以重新使用")
	private String invalidDealnoCanUseAgain;

	public String getSaleRentDealRepeat() {
		return saleRentDealRepeat;
	}

	public void setSaleRentDealRepeat(String saleRentDealRepeat) {
		this.saleRentDealRepeat = saleRentDealRepeat;
	}

	public String getAllowUnuseDealnoIsbyhand() {
		return allowUnuseDealnoIsbyhand;
	}

	public void setAllowUnuseDealnoIsbyhand(String allowUnuseDealnoIsbyhand) {
		this.allowUnuseDealnoIsbyhand = allowUnuseDealnoIsbyhand;
	}

	public String getInvalidDealnoCanUseAgain() {
		return invalidDealnoCanUseAgain;
	}

	public void setInvalidDealnoCanUseAgain(String invalidDealnoCanUseAgain) {
		this.invalidDealnoCanUseAgain = invalidDealnoCanUseAgain;
	}
}
