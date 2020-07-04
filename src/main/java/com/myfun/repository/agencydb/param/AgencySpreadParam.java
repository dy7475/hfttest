package com.myfun.repository.agencydb.param;

import com.myfun.repository.support.param.PageParam;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年5月9日 下午3:44:43 
 * 推广审核
*/
public class AgencySpreadParam extends PageParam{
	private String cityId;
	private String buildName;
	private String checkStatuas;
	private String provinceId;
	
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getBuildName() {
		return buildName;
	}
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	public String getCheckStatuas() {
		return checkStatuas;
	}
	public void setCheckStatuas(String checkStatuas) {
		this.checkStatuas = checkStatuas;
	}
	
}	
