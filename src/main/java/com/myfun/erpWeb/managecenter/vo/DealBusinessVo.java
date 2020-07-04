package com.myfun.erpWeb.managecenter.vo;

import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.erpdb.po.ErpProcessFinanc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "合同模块VO")
public class DealBusinessVo implements Serializable {
	@ApiModelProperty("合同列表")
	private List<ErpFunDeal> dealList;
	@ApiModelProperty("财务信息列表")
	private List<ErpProcessFinanc> processFinancList;

	public List<ErpFunDeal> getDealList() {
		return dealList;
	}

	public void setDealList(List<ErpFunDeal> dealList) {
		this.dealList = dealList;
	}

	public List<ErpProcessFinanc> getProcessFinancList() {
		return processFinancList;
	}

	public void setProcessFinancList(List<ErpProcessFinanc> processFinancList) {
		this.processFinancList = processFinancList;
	}
}
