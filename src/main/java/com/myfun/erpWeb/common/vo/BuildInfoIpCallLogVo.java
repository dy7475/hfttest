package com.myfun.erpWeb.common.vo;

import com.myfun.repository.admindb.po.AdminIpCallLog;

import java.util.List;

public class BuildInfoIpCallLogVo {
	private List<AdminIpCallLog> ipCallLogList;

	public List<AdminIpCallLog> getIpCallLogList() {
		return ipCallLogList;
	}

	public void setIpCallLogList(List<AdminIpCallLog> ipCallLogList) {
		this.ipCallLogList = ipCallLogList;
	}
}
