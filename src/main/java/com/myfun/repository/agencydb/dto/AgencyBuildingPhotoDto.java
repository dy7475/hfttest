package com.myfun.repository.agencydb.dto;

import com.myfun.repository.agencydb.po.AgencyBuildingPhoto;

public class AgencyBuildingPhotoDto extends AgencyBuildingPhoto{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String layoutNo;

	public String getLayoutNo() {
		return layoutNo;
	}

	public void setLayoutNo(String layoutNo) {
		this.layoutNo = layoutNo;
	}
	
	
}
