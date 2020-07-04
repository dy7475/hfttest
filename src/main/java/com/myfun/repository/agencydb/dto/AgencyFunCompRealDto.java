package com.myfun.repository.agencydb.dto;

import com.myfun.repository.agencydb.po.AgencyFunCompReal;

/**
 * 开发商管理
 * @author Administrator
 *
 */
public class AgencyFunCompRealDto extends AgencyFunCompReal{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cityName;
	
	private String provinceName;
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
	

}
