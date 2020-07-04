package com.myfun.erpWeb.managecenter.constract.param;

import com.myfun.repository.erpdb.po.ErpFunFinanceStatus;
import com.myfun.repository.param.EncryParamIfc;

import java.util.List;

/**
 * @author guohao
 * @date 2019-03-11 17:20
 */
public class FinanceStatusListParam implements EncryParamIfc {
	private List<ErpFunFinanceStatus> financeStatusList;

	public List<ErpFunFinanceStatus> getFinanceStatusList() {
		return financeStatusList;
	}

	public void setFinanceStatusList(List<ErpFunFinanceStatus> financeStatusList) {
		this.financeStatusList = financeStatusList;
	}
}
