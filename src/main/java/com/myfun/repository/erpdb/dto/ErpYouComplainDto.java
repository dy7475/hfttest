package com.myfun.repository.erpdb.dto;

import java.util.Date;

import com.myfun.repository.erpdb.po.ErpYouShareHouseStatus;

public class ErpYouComplainDto extends ErpYouShareHouseStatus {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date houseUpdateTime;
	private String userName;
	private String deptName;
	private Integer compalinNumber;
	private Integer houseCompalinNumber;
	private Integer purchasePersonNumber;

	public Integer getPurchasePersonNumber() {
		return purchasePersonNumber;
	}

	public void setPurchasePersonNumber(Integer purchasePersonNumber) {
		this.purchasePersonNumber = purchasePersonNumber;
	}

	public Integer getCompalinNumber() {
		return compalinNumber;
	}

	public void setCompalinNumber(Integer compalinNumber) {
		this.compalinNumber = compalinNumber;
	}

	public Integer getHouseCompalinNumber() {
		return houseCompalinNumber;
	}

	public void setHouseCompalinNumber(Integer houseCompalinNumber) {
		this.houseCompalinNumber = houseCompalinNumber;
	}

	public Date getHouseUpdateTime() {
		return houseUpdateTime;
	}

	public void setHouseUpdateTime(Date houseUpdateTime) {
		this.houseUpdateTime = houseUpdateTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
