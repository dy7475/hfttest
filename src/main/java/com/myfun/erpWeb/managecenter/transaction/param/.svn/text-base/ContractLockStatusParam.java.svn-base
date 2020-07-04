package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import scala.util.control.Exception;

@ApiModel
public class ContractLockStatusParam implements EncryParamIfc {
	@ApiModelProperty(value = "合同ID")
	private Integer dealId;
	@ApiModelProperty(value = "锁定状态 1=锁定 0=解锁")
	private Byte lockFlag;

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Byte getLockFlag() {
		return lockFlag;
	}

	public void setLockFlag(Byte lockFlag) {
		this.lockFlag = lockFlag;
	}
}
