package com.myfun.erpWeb.managecenter.profit.vo;

import com.myfun.repository.erpdb.dto.ErpFunDealDtoTemp;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.erpdb.po.ErpFunProfit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class HandProfitListVo {
	@ApiModelProperty(value = "业绩列表")
	List<ErpFunProfit> profitList;
	@ApiModelProperty(value = "合同列表")
	List<ErpFunDealDtoTemp> dealInfo;

	public List<ErpFunProfit> getProfitList() {
		return profitList;
	}

	public void setProfitList(List<ErpFunProfit> profitList) {
		this.profitList = profitList;
	}

	public List<ErpFunDealDtoTemp> getDealInfo() {
		return dealInfo;
	}

	public void setDealInfo(List<ErpFunDealDtoTemp> dealInfo) {
		this.dealInfo = dealInfo;
	}
}
