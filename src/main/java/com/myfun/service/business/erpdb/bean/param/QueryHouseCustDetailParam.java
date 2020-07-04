package com.myfun.service.business.erpdb.bean.param;

import com.myfun.repository.param.AbstractEncryParam;


public class QueryHouseCustDetailParam extends AbstractEncryParam {
	private Integer CASE_ID;
	private Integer CASE_TYPE;
	
	public Integer getCASE_ID() {
		return CASE_ID;
	}
	public void setCASE_ID(Integer cASE_ID) {
		CASE_ID = cASE_ID;
	}
	public Integer getCASE_TYPE() {
		return CASE_TYPE;
	}
	public void setCASE_TYPE(Integer cASE_TYPE) {
		CASE_TYPE = cASE_TYPE;
	}
}
