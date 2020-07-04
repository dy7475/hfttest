package com.myfun.repository.agencydb.param;

import java.io.Serializable;

import com.myfun.repository.support.param.PageParam;

public class AgencyBuildLayoutParam extends PageParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer buildId;
	
	private Integer cityId;
	
	private Integer layoutId;

	public Integer getBuildId() {
		return buildId;
	}

	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(Integer layoutId) {
		this.layoutId = layoutId;
	}
	
	

	
   
}