package com.myfun.repository.agencydb.dto;

import com.myfun.repository.agencydb.po.AgencyAmountHistory;


public class AgencyAmountHistoryDto extends AgencyAmountHistory{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String spreadContent;
	private String spreadTitle;
	public String getSpreadContent() {
		return spreadContent;
	}
	public void setSpreadContent(String spreadContent) {
		this.spreadContent = spreadContent;
	}
	public String getSpreadTitle() {
		return spreadTitle;
	}
	public void setSpreadTitle(String spreadTitle) {
		this.spreadTitle = spreadTitle;
	}
	
}
