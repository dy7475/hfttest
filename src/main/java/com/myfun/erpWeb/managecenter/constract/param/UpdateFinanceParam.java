package com.myfun.erpWeb.managecenter.constract.param;

import com.myfun.repository.erpdb.po.ErpFunFinancPayment;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author guohao
 * @date 2019-03-11 16:58
 */
public class UpdateFinanceParam implements EncryParamIfc {
	@ApiModelProperty("编辑添加财务款项列表")
	private List<ErpFunFinancPayment> FinanceList;

	public List<ErpFunFinancPayment> getFinanceList() {
		return FinanceList;
	}

	public void setFinanceList(List<ErpFunFinancPayment> financeList) {
		FinanceList = financeList;
	}
}

