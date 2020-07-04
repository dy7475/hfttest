package com.myfun.erpWeb.usercenter.vo;

import com.myfun.repository.admindb.po.AdminFunPaid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AdminFunPaidVo extends AdminFunPaid {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("值的中文描述")
	private String paidTypeMsg; // 值的中文描述
	@ApiModelProperty("交易账户 1=个人 2=公司")
	private Integer accountType; // 交易账户 1=个人 2=公司
	@ApiModelProperty("交易账户 1=增加 2=减少")
	private Integer incomeType; // 交易账户 1=增加 2=减少
	@ApiModelProperty("交易账户 1=增加 2=减少")
	private Byte isFreeUser; // 交易账户 1=增加 2=减少
	@ApiModelProperty("赠送的")
	private double perAmountPrice; // 赠送的

	public String getPaidTypeMsg() {
		return paidTypeMsg;
	}
	public void setPaidTypeMsg(String paidTypeMsg) {
		this.paidTypeMsg = paidTypeMsg;
	}
	public Integer getAccountType() {
		return accountType;
	}
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	public Integer getIncomeType() {
		return incomeType;
	}
	public void setIncomeType(Integer incomeType) {
		this.incomeType = incomeType;
	}
	public Byte getIsFreeUser() {
		return isFreeUser;
	}
	public void setIsFreeUser(Byte isFreeUser) {
		this.isFreeUser = isFreeUser;
	}
	public double getPerAmountPrice() {
		return perAmountPrice;
	}
	public void setPerAmountPrice(double perAmountPrice) {
		this.perAmountPrice = perAmountPrice;
	}
	
}
