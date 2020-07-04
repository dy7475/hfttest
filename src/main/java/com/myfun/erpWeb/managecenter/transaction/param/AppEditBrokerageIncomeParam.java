package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.erpdb.po.ErpFunBrokerageIncome;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author guohao
 * @date 2019-03-14 10:54
 */
public class AppEditBrokerageIncomeParam implements EncryParamIfc {
	@ApiModelProperty(value = "分佣比列表")
	private List<ErpFunBrokerageIncome> brokerageIncomeList;
	@ApiModelProperty(value = "分佣比展示规则")
	private String profitPercentRule;

	public List<ErpFunBrokerageIncome> getBrokerageIncomeList() {
		return brokerageIncomeList;
	}

	public void setBrokerageIncomeList(List<ErpFunBrokerageIncome> brokerageIncomeList) {
		this.brokerageIncomeList = brokerageIncomeList;
	}

	public String getProfitPercentRule() {
		return profitPercentRule;
	}

	public void setProfitPercentRule(String profitPercentRule) {
		this.profitPercentRule = profitPercentRule;
	}
}


