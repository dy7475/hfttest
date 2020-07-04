package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.EncryParamIfc;

public class QueryPrintBuillInfoParam implements EncryParamIfc{
	private Integer cityId;//城市id
	private Integer compId;//公司id
	private Integer areaId;//大区id
	private Integer regId;//片区id
	private Integer deptId;//门店id
	private Integer grId; //分组id
	private Integer userId;//员工id
	private String userName;
	private Byte billWay;//出票方式
	private String earBestMoneyIds;//要一起打的诚意金id是
	private String depositIds;//要一起打的定金Id
	private String financIds;//财务id是
	private Integer dealId;//合同id
	private Byte printType;//0没有打印过 1是打印过的
	private Byte billPrintWay;//票据的打印方式
	private Integer billCodeId;//票据编号id
	private String billNo;//票据编号
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getBillCodeId() {
		return billCodeId;
	}
	public void setBillCodeId(Integer billCodeId) {
		this.billCodeId = billCodeId;
	}
	
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public Byte getBillPrintWay() {
		return billPrintWay;
	}
	public void setBillPrintWay(Byte billPrintWay) {
		this.billPrintWay = billPrintWay;
	}
	public Integer getDealId() {
		return dealId;
	}
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}
	public Byte getPrintType() {
		return printType;
	}
	public void setPrintType(Byte printType) {
		this.printType = printType;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getRegId() {
		return regId;
	}
	public void setRegId(Integer regId) {
		this.regId = regId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getGrId() {
		return grId;
	}
	public void setGrId(Integer grId) {
		this.grId = grId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Byte getBillWay() {
		return billWay;
	}
	public void setBillWay(Byte billWay) {
		this.billWay = billWay;
	}
	public String getEarBestMoneyIds() {
		return earBestMoneyIds;
	}
	public void setEarBestMoneyIds(String earBestMoneyIds) {
		this.earBestMoneyIds = earBestMoneyIds;
	}

	public String getDepositIds() {
		return depositIds;
	}

	public void setDepositIds(String depositIds) {
		this.depositIds = depositIds;
	}

	public String getFinancIds() {
		return financIds;
	}
	public void setFinancIds(String financIds) {
		this.financIds = financIds;
	}
	
}
