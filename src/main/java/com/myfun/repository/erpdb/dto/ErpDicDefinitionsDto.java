package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpDicDefinitions;

public class ErpDicDefinitionsDto extends ErpDicDefinitions{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer menualCount;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getMenualCount() {
		return menualCount;
	}

	public void setMenualCount(Integer menualCount) {
		this.menualCount = menualCount;
	}
}
