package com.myfun.service.business.erpdb.bean.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

/**
 * @author 方李骥
 * @since 2016年8月30日
 */
public class QueryBuildingListParam extends AbstractEncryParam implements DaoBaseParam {
	private Integer cityId;
	private String buildName;
	private String buildCode;
	private String orderBy;
	private Integer buildingFlag;
	private Integer compId;
	private String buildIds; 
	private String sectionIds;
	private String regionId;
	private String[] buildIdList;
	private String[] sectionIdList;
	
	
	public String[] getBuildIdList() {
		return buildIdList;
	}
	public void setBuildIdList(String[] buildIdList) {
		this.buildIdList = buildIdList;
	}
	public String[] getSectionIdList() {
		return sectionIdList;
	}
	public void setSectionIdList(String[] sectionIdList) {
		this.sectionIdList = sectionIdList;
	}
	public String getSectionIds() {
		return sectionIds;
	}
	public void setSectionIds(String sectionIds) {
		this.sectionIds = sectionIds;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getBuildIds() {
		return buildIds;
	}
	public void setBuildIds(String buildIds) {
		this.buildIds = buildIds;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public String getBuildCode() {
		return buildCode;
	}
	public void setBuildCode(String buildCode) {
		this.buildCode = buildCode;
	}
	/**
	 * @return the buildingFlag
	 */
	public Integer getBuildingFlag() {
		return buildingFlag;
	}
	/**
	 * @param buildingFlag the buildingFlag to set
	 */
	public void setBuildingFlag(Integer buildingFlag) {
		this.buildingFlag = buildingFlag;
	}
	/**
	 * @return the cityId
	 */
	public Integer getCityId() {
		return cityId;
	}
	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	/**
	 * @return the buildName
	 */
	public String getBuildName() {
		return buildName;
	}
	/**
	 * @param buildName the buildName to set
	 */
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	/**
	 * @return the orderBy
	 */
	public String getOrderBy() {
		return orderBy;
	}
	/**
	 * @param orderBy the orderBy to set
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
}
