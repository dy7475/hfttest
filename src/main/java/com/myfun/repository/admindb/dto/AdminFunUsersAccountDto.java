package com.myfun.repository.admindb.dto;

import com.myfun.repository.admindb.po.AdminFunUserAccount;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年4月14日 下午8:25:28 
 * 类说明 
*/
public class AdminFunUsersAccountDto extends AdminFunUserAccount{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String cityName;
	private String userMobile;
	private Double priceRs;
	private Integer avaDateFlag;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public Double getPriceRs() {
		return priceRs;
	}
	public void setPriceRs(Double priceRs) {
		this.priceRs = priceRs;
	}
	public Integer getAvaDateFlag() {
		return avaDateFlag;
	}
	public void setAvaDateFlag(Integer avaDateFlag) {
		this.avaDateFlag = avaDateFlag;
	}
	
}
