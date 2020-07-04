package com.myfun.repository.admindb.dto;

import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminJrFinanceInfo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * title ：金融贷款信息
 * auhor：lcb
 * date  : 2017/10/13
 */
public class AdminJrFinanceInfoDto extends AdminJrFinanceInfo{

	private String transferUserName;
	private String transferUserDeptName;
	private String transferUserMobile;

	public String getTransferUserMobile() {
		return transferUserMobile;
	}

	public void setTransferUserMobile(String transferUserMobile) {
		this.transferUserMobile = transferUserMobile;
	}

	public String getTransferUserName() {
		return transferUserName;
	}

	public void setTransferUserName(String transferUserName) {
		this.transferUserName = transferUserName;
	}

	public String getTransferUserDeptName() {
		return transferUserDeptName;
	}

	public void setTransferUserDeptName(String transferUserDeptName) {
		this.transferUserDeptName = transferUserDeptName;
	}
}
