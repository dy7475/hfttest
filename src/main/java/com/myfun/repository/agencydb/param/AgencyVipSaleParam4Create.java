package com.myfun.repository.agencydb.param;

import com.myfun.repository.agencydb.po.AgencyVipSale;

public class AgencyVipSaleParam4Create extends AgencyVipSale{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String phone;
	private String cellphone;
	private String userName;
	private Integer clientId;
	private String sex;

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getUserName() {
		return userName;
	}

	

	
	
	

}
