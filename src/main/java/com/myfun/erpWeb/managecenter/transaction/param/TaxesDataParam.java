package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.erpWeb.managecenter.constract.param.TaxesDataOutParamDto;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class TaxesDataParam implements EncryParamIfc {
	@ApiModelProperty(value = "新增或修改参数列表")
	private List<TaxesDataOutParamDto> taxesSubList;

	public List<TaxesDataOutParamDto> getTaxesSubList() {
		return taxesSubList;
	}

	public void setTaxesSubList(List<TaxesDataOutParamDto> taxesSubList) {
		this.taxesSubList = taxesSubList;
	}
}
