package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpAppLoginDevice;

public class ErpAppLoginDeviceDto extends ErpAppLoginDevice{

	private static final long serialVersionUID = 1L;
	private String userName;//经纪人姓名
	private String checkUserName;//审核人姓名
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCheckUserName() {
		return checkUserName;
	}
	public void setCheckUserName(String checkUserName) {
		this.checkUserName = checkUserName;
	}

}
