package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;

public class ErpFunReceiptTypeParam extends AbstractEncryParam{

	private Integer seqNo;
	
	private String receiptType;

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public String getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(String receiptType) {
		this.receiptType = receiptType;
	}
	
}
