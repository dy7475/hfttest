package com.myfun.repository.admindb.dto;

import com.myfun.repository.admindb.po.AdminFunBrand;

public class AdminFunBrandDto extends AdminFunBrand {

	/**
	 * 序列
	 */
	private static final long serialVersionUID = 1L;

	private String seqNo;
	
	private Integer cityId;
	
	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	
}