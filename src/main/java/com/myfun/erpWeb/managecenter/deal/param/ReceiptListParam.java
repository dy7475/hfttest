package com.myfun.erpWeb.managecenter.deal.param;

import com.myfun.repository.erpdb.po.ErpFunReceiptType;
import com.myfun.repository.param.EncryParamIfc;

import java.util.List;

/**
 * @author guohao
 * @date 2019-03-12 16:06
 */
public class ReceiptListParam implements EncryParamIfc {
	private List<ErpFunReceiptType> receiptTypeList;

	public List<ErpFunReceiptType> getReceiptTypeList() {
		return receiptTypeList;
	}

	public void setReceiptTypeList(List<ErpFunReceiptType> receiptTypeList) {
		this.receiptTypeList = receiptTypeList;
	}
}
