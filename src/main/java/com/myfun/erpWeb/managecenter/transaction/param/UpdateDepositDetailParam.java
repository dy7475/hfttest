package com.myfun.erpWeb.managecenter.transaction.param;

import java.math.BigDecimal;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UpdateDepositDetailParam implements EncryParamIfc{

	@ApiModelProperty("定金id")
	private Integer id;
	@ApiModelProperty(value = "当出票方式不等于手动录入时有值")
	private Integer billCodeId;
	@ApiModelProperty(value = "票据编号")
	private String billCodeNo;
	@ApiModelProperty(value = "出票方式  0电子票据 1纸质票薄 2手动录入")
	private Byte billWay;
	@ApiModelProperty(value = "收款金额")
	private BigDecimal receiptMoney;
	@ApiModelProperty(value = "bill_way=1或2时，票据图片")
	private String billPhoto;
	@ApiModelProperty(value = "定金备注")
	private String depositRemark;
	@ApiModelProperty(value = "客户电话")
	private String custMobile;
	@ApiModelProperty(value = "客户姓名")
	private String custName;
	@ApiModelProperty(hidden = true)
	private Integer cityId;
	@ApiModelProperty(hidden = true)
	private Integer userId;
	@ApiModelProperty(hidden = true)
	private String userName;
	@ApiModelProperty(hidden = true)
	private Integer compId;
	@ApiModelProperty(hidden = true)
	private Integer areaId;
	@ApiModelProperty(hidden = true)
	private Integer regId;
	@ApiModelProperty(hidden = true)
	private Integer deptId;
	@ApiModelProperty(hidden = true)
	private Integer grId;
	@ApiModelProperty(hidden = true)
	private String deptCName;
	
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
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
	public Integer getGrId() {
		return grId;
	}
	public void setGrId(Integer grId) {
		this.grId = grId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBillCodeId() {
		return billCodeId;
	}
	public void setBillCodeId(Integer billCodeId) {
		this.billCodeId = billCodeId;
	}
	public String getBillCodeNo() {
		return billCodeNo;
	}
	public void setBillCodeNo(String billCodeNo) {
		this.billCodeNo = billCodeNo;
	}
	public Byte getBillWay() {
		return billWay;
	}
	public void setBillWay(Byte billWay) {
		this.billWay = billWay;
	}
	public BigDecimal getReceiptMoney() {
		return receiptMoney;
	}
	public void setReceiptMoney(BigDecimal receiptMoney) {
		this.receiptMoney = receiptMoney;
	}
	public String getBillPhoto() {
		return billPhoto;
	}
	public void setBillPhoto(String billPhoto) {
		this.billPhoto = billPhoto;
	}
	public String getDepositRemark() {
		return depositRemark;
	}
	public void setDepositRemark(String depositRemark) {
		this.depositRemark = depositRemark;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptCName() {
		return deptCName;
	}
	public void setDeptCName(String deptCName) {
		this.deptCName = deptCName;
	}
}
