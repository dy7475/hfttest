package com.myfun.erpWeb.managecenter.deal.param;

import com.myfun.repository.erpdb.po.ErpFunReceiptAccount;
import com.myfun.repository.param.EncryParamIfc;

import java.util.List;

/**
 * @author guohao
 * @date 2019-03-12 16:15
 */
public class ReceiptAccountListParam implements EncryParamIfc {
	private List<ErpFunReceiptAccount> receiptAccountList;

	public List<ErpFunReceiptAccount> getReceiptAccountList() {
		return receiptAccountList;
	}

	public void setReceiptAccountList(List<ErpFunReceiptAccount> receiptAccountList) {
		this.receiptAccountList = receiptAccountList;
	}
}
