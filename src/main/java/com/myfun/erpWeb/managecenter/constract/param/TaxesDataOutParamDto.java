package com.myfun.erpWeb.managecenter.constract.param;

import com.myfun.repository.erpdb.po.ErpFunDealTaxesSub;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class TaxesDataOutParamDto {
	@ApiModelProperty(value = "修改时传ID")
	private Integer id;
	@ApiModelProperty("父类名")
	private String name;
	@ApiModelProperty("支付类型")
	private Integer payType;
	@ApiModelProperty("字类信息")
	private List<ErpFunDealTaxesSub> valList;

	public List<ErpFunDealTaxesSub> getValList() {
		return valList;
	}

	public void setValList(List<ErpFunDealTaxesSub> valList) {
		this.valList = valList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}
}
