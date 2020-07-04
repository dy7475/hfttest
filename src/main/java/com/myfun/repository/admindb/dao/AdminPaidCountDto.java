package com.myfun.repository.admindb.dao;
/** 
 * @author 作者张卓 
 * @version 创建时间：2016年4月14日 上午10:16:57 
 * 类说明 
*/
public class AdminPaidCountDto {
	private String paidCatigory;
	private String paidType;
	private String sumAmount;
	private String sumhfAmount;
	private String sumhfBuy;
	
	public String getSumhfAmount() {
		return sumhfAmount;
	}
	public void setSumhfAmount(String sumhfAmount) {
		this.sumhfAmount = sumhfAmount;
	}
	public String getSumhfBuy() {
		return sumhfBuy;
	}
	public void setSumhfBuy(String sumhfBuy) {
		this.sumhfBuy = sumhfBuy;
	}
	public String getPaidCatigory() {
		return paidCatigory;
	}
	public void setPaidCatigory(String paidCatigory) {
		this.paidCatigory = paidCatigory;
	}
	public String getPaidType() {
		return paidType;
	}
	public void setPaidType(String paidType) {
		this.paidType = paidType;
	}
	public String getSumAmount() {
		return sumAmount;
	}
	public void setSumAmount(String sumAmount) {
		this.sumAmount = sumAmount;
	}
	
}
