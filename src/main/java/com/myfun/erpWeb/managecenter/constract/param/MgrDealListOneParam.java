package com.myfun.erpWeb.managecenter.constract.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class MgrDealListOneParam implements EncryParamIfc {
	@ApiModelProperty(value = "合同ID")
	private  Integer dealId;
	
	@ApiModelProperty(value = "合同类别 DD:CASE_TYPE")
	private  Integer dealType;
	
	@ApiModelProperty(value = "是否是宽列表1=是")
	private Byte isWideList;

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Integer getDealType() {
		return dealType;
	}

	public void setDealType(Integer dealType) {
		this.dealType = dealType;
	}

	public Byte getIsWideList() {
		return isWideList;
	}

	public void setIsWideList(Byte isWideList) {
		this.isWideList = isWideList;
	}
}
