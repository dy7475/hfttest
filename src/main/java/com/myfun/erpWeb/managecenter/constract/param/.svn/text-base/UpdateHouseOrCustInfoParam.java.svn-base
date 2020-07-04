package com.myfun.erpWeb.managecenter.constract.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UpdateHouseOrCustInfoParam implements EncryParamIfc {
	@ApiModelProperty(value = "合同ID")
	private Integer dealId;
	@ApiModelProperty(value = "加密，不加密")
	private Integer updateFlag;
	@ApiModelProperty(value = "房源ID")
	private Integer dealHouseId;
	@ApiModelProperty(value = "客源ID")
	private Integer dealCustomerId;
	@ApiModelProperty(value = "合同类型 101=出售 102=出租")
	private byte dealType;


	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Integer getUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(Integer updateFlag) {
		this.updateFlag = updateFlag;
	}

	public Integer getDealHouseId() {
		return dealHouseId;
	}

	public void setDealHouseId(Integer dealHouseId) {
		this.dealHouseId = dealHouseId;
	}

	public Integer getDealCustomerId() {
		return dealCustomerId;
	}

	public void setDealCustomerId(Integer dealCustomerId) {
		this.dealCustomerId = dealCustomerId;
	}

	public byte getDealType() {
		return dealType;
	}

	public void setDealType(byte dealType) {
		this.dealType = dealType;
	}
}
