package com.myfun.repository.agencydb.dto;

import java.util.Date;

import com.myfun.repository.agencydb.po.AgencyMessageFav;


public class AgencyMessageFavDto extends AgencyMessageFav{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date creationTime;
	private String spreadContent;
	private String buildName;
	private String isRead;
	private Integer spreadId;
	private String spreadTitle;
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public String getSpreadContent() {
		return spreadContent;
	}
	public void setSpreadContent(String spreadContent) {
		this.spreadContent = spreadContent;
	}
	public String getBuildName() {
		return buildName;
	}
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	public String getIsRead() {
		return isRead;
	}
	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}
	public Integer getSpreadId() {
		return spreadId;
	}
	public void setSpreadId(Integer spreadId) {
		this.spreadId = spreadId;
	}
	public String getSpreadTitle() {
		return spreadTitle;
	}
	public void setSpreadTitle(String spreadTitle) {
		this.spreadTitle = spreadTitle;
	}
	
}
