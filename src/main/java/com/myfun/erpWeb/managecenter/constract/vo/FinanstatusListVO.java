package com.myfun.erpWeb.managecenter.constract.vo;

import com.myfun.repository.erpdb.po.ErpFunFinanceStatus;

import java.util.List;

/**
 * @author guohao
 * @date 2019-03-11 17:18
 */
public class FinanstatusListVO {
	private List<ErpFunFinanceStatus> financeStatuses;

	public List<ErpFunFinanceStatus> getFinanceStatuses() {
		return financeStatuses;
	}

	public void setFinanceStatuses(List<ErpFunFinanceStatus> financeStatuses) {
		this.financeStatuses = financeStatuses;
	}
}
