package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class FinaDataOfReceivableParam implements EncryParamIfc {
	@ApiModelProperty(value = "合同id")
	private Integer dealId;
	@ApiModelProperty(value = "款项json列表")
	private String financJson;
	@ApiModelProperty(value = "删除时传财务款项ID，逗号分隔")
	private String delFinancIds;
	@ApiModelProperty(hidden = true)
	private Integer pfActual;

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public String getFinancJson() {
		return financJson;
	}

	public void setFinancJson(String financJson) {
		this.financJson = financJson;
	}

	public String getDelFinancIds() {
		return delFinancIds;
	}

	public void setDelFinancIds(String delFinancIds) {
		this.delFinancIds = delFinancIds;
	}

	public Integer getPfActual() {
		return pfActual;
	}

	public void setPfActual(Integer pfActual) {
		this.pfActual = pfActual;
	}
}
