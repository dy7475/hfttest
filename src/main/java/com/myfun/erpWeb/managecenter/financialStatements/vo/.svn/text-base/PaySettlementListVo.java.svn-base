package com.myfun.erpWeb.managecenter.financialStatements.vo;

import com.myfun.repository.erpdb.dto.ErpProcessFinancDto;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.erpdb.po.ErpFunProfit;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "业绩核算表或收款结算表数据Vo")
public class PaySettlementListVo implements Serializable {
	@ApiModelProperty("合同列表")
	private List<ErpFunDeal> dealList;
	@ApiModelProperty("财务列表")
	private List<ErpProcessFinancDto> processfinancList;
	@ApiModelProperty("业绩列表")
	private List<ErpFunProfit> profitList;
	@ApiModelProperty("条数")
	private Integer total;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<ErpFunDeal> getDealList() {
		return dealList;
	}

	public void setDealList(List<ErpFunDeal> dealList) {
		this.dealList = dealList;
	}

	public List<ErpProcessFinancDto> getProcessfinancList() {
		return processfinancList;
	}

	public void setProcessfinancList(List<ErpProcessFinancDto> processfinancList) {
		this.processfinancList = processfinancList;
	}

	public List<ErpFunProfit> getProfitList() {
		return profitList;
	}

	public void setProfitList(List<ErpFunProfit> profitList) {
		this.profitList = profitList;
	}
}
