package com.myfun.erpWeb.managecenter.axn.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class PhoneBillVO implements Serializable {
	
	@ApiModelProperty(value = "隐号")
	private String xPhone;
	
	@ApiModelProperty(value = "绑定时间")
	private String bindATime;
	
	@ApiModelProperty(value = "使用组织")
	private Integer orgId;
	
	@ApiModelProperty(value = "组织编号")
	private String orgNo;
	
	@ApiModelProperty(value = "使用人")
	private Integer userId;
	
	@ApiModelProperty(value = "隐号")
	private String bindX;
	
	@ApiModelProperty(value = "通话费用")
	private BigDecimal telePhoneBill;
	
	@ApiModelProperty(value = "月租费用")
	private BigDecimal monthlyrent;
	
	@ApiModelProperty(value = "录音费用")
	private BigDecimal recording;
	
	@ApiModelProperty(value = "其他费用")
	private BigDecimal otherBill;

	@ApiModelProperty(value = "总费用")
	private BigDecimal allMoney;
	
	@ApiModelProperty(value = "总时长")
	private Integer toallTime;
	
	@ApiModelProperty(value = "总通数")
	private Integer toallCount;
	
	@ApiModelProperty(value = "id")
	private Integer id;
	
	@ApiModelProperty(value = "组织名称")
	private String orgName;
	
	public String getxPhone() {
		return xPhone;
	}
	
	public void setxPhone(String xPhone) {
		this.xPhone = xPhone;
	}
	
	public String getBindATime() {
		return bindATime;
	}
	
	public void setBindATime(String bindATime) {
		this.bindATime = bindATime;
	}
	
	public Integer getOrgId() {
		return orgId;
	}
	
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	
	public String getOrgNo() {
		return orgNo;
	}
	
	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getBindX() {
		return bindX;
	}
	
	public void setBindX(String bindX) {
		this.bindX = bindX;
	}
	
	public BigDecimal getTelePhoneBill() {
		return telePhoneBill;
	}
	
	public void setTelePhoneBill(BigDecimal telePhoneBill) {
		this.telePhoneBill = telePhoneBill;
	}
	
	public BigDecimal getMonthlyrent() {
		return monthlyrent;
	}
	
	public void setMonthlyrent(BigDecimal monthlyrent) {
		this.monthlyrent = monthlyrent;
	}
	
	public BigDecimal getRecording() {
		return recording;
	}
	
	public void setRecording(BigDecimal recording) {
		this.recording = recording;
	}
	
	public BigDecimal getOtherBill() {
		return otherBill;
	}
	
	public void setOtherBill(BigDecimal otherBill) {
		this.otherBill = otherBill;
	}
	
	public BigDecimal getAllMoney() {
		return allMoney;
	}
	
	public void setAllMoney(BigDecimal allMoney) {
		this.allMoney = allMoney;
	}
	
	public Integer getToallTime() {
		return toallTime;
	}
	
	public void setToallTime(Integer toallTime) {
		this.toallTime = toallTime;
	}
	
	public Integer getToallCount() {
		return toallCount;
	}
	
	public void setToallCount(Integer toallCount) {
		this.toallCount = toallCount;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getOrgName() {
		return orgName;
	}
	
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
}
