package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpCountDone;

public class ErpCountDoneDto extends ErpCountDone {

	private static final long serialVersionUID = 1L;
	
	private Integer siteId;

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}
}
