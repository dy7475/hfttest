package com.myfun.erpWeb.managecenter.constract.param;

import com.myfun.repository.erpdb.po.ErpFunBrokerage;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SaveBrokerageParamAndVo implements EncryParamIfc {
	@ApiModelProperty(value = "租单收用标准")
	private ErpFunBrokerage leaseBrokerage;
	@ApiModelProperty(value = "售单收用标准")
	private ErpFunBrokerage saleBrokerage;

	public ErpFunBrokerage getLeaseBrokerage() {
		return leaseBrokerage;
	}

	public void setLeaseBrokerage(ErpFunBrokerage leaseBrokerage) {
		this.leaseBrokerage = leaseBrokerage;
	}

	public ErpFunBrokerage getSaleBrokerage() {
		return saleBrokerage;
	}

	public void setSaleBrokerage(ErpFunBrokerage saleBrokerage) {
		this.saleBrokerage = saleBrokerage;
	}
}
