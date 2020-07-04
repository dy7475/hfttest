package com.myfun.service.business.erpdb.bean.param;

import java.math.BigDecimal;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

public class AccountParam extends AbstractEncryParam implements DaoBaseParam{

	private Integer actId;
	private Integer atId;
	private Integer compId;
	private String actTime;
	private String actNo;
	private String actType;
	private String actDesc;
	private BigDecimal actAmount;
	private Boolean actFlag;
	private BigDecimal actBalance;
	private Integer creatorUid;
	private String creationTime;
	private Integer cityId;
	
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getActId() {
		return actId;
	}
	public void setActId(Integer actId) {
		this.actId = actId;
	}
	public Integer getAtId() {
		return atId;
	}
	public void setAtId(Integer atId) {
		this.atId = atId;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public String getActTime() {
		return actTime;
	}
	public void setActTime(String actTime) {
		this.actTime = actTime;
	}
	public String getActNo() {
		return actNo;
	}
	public void setActNo(String actNo) {
		this.actNo = actNo;
	}
	public String getActType() {
		return actType;
	}
	public void setActType(String actType) {
		this.actType = actType;
	}
	public String getActDesc() {
		return actDesc;
	}
	public void setActDesc(String actDesc) {
		this.actDesc = actDesc;
	}
	public BigDecimal getActAmount() {
		return actAmount;
	}
	public void setActAmount(BigDecimal actAmount) {
		this.actAmount = actAmount;
	}
	public Boolean getActFlag() {
		return actFlag;
	}
	public void setActFlag(Boolean actFlag) {
		this.actFlag = actFlag;
	}
	public BigDecimal getActBalance() {
		return actBalance;
	}
	public void setActBalance(BigDecimal actBalance) {
		this.actBalance = actBalance;
	}
	public Integer getCreatorUid() {
		return creatorUid;
	}
	public void setCreatorUid(Integer creatorUid) {
		this.creatorUid = creatorUid;
	}
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	
}
