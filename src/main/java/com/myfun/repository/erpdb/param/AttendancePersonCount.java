package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

public class AttendancePersonCount extends AbstractEncryParam implements DaoBaseParam{
	private String attDateStr;

	public String getAttDate() {
		return attDateStr;
	}

	public void setAttDate(String attDateStr) {
		this.attDateStr = attDateStr;
	}

}
