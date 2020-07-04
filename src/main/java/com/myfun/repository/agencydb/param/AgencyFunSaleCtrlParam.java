package com.myfun.repository.agencydb.param;

import java.io.Serializable;

import com.myfun.repository.support.param.PageParam;

public class AgencyFunSaleCtrlParam extends PageParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 销控状态
	 * **/
	private Integer saleStatus;
	
	/**
	 * 房源编号
	 * **/
	private String funNo;

	private Integer buildId;
	
	private Integer cityId;
	
	//旧编号
	private String oldHoustNo;
	
	
	public String getOldHoustNo() {
		return oldHoustNo;
	}

	public void setOldHoustNo(String oldHoustNo) {
		this.oldHoustNo = oldHoustNo;
	}

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

	public Integer getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(Integer saleStatus) {
		this.saleStatus = saleStatus;
	}

	public String getFunNo() {
		return funNo;
	}

	public void setFunNo(String funNo) {
		this.funNo = funNo;
	}
	
	
   
}