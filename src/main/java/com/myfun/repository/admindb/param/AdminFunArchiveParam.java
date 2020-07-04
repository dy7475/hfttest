package com.myfun.repository.admindb.param;

import java.math.BigDecimal;
import java.util.Date;

import com.myfun.repository.admindb.po.AdminFunArchive;

public class AdminFunArchiveParam extends AdminFunArchive {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String newPhoneNum;
	private Integer compId;
	private Integer provinceId;
	private Integer userType;
	private BigDecimal amountMin;
	private BigDecimal amountMax;
	private BigDecimal haofangAmountMin;
	private BigDecimal haofangAmountMax;
	private Integer banType;
	private Integer houseBidding;
	private Integer userBidding;
	private Integer webstoreStatus;
	private Integer rqsActualStatus;
	private Integer rqsAptitudeStatus;
	private Integer crmCompId;
	private String rqsTime;
	private Integer custom;
	private String status;
	private String userAmount;
	private String userHaoFangAmount;
	private Integer houseSouseTotal;
	private Integer userNote;
	private Date rqsTimeMin;
	private Date rqsTimeMax;
	private Boolean userWriteoff;
	private String userNo;
	private String userPosition;
	private BigDecimal amount;

	public Date getRqsTimeMin() {
		return rqsTimeMin;
	}

	public void setRqsTimeMin(Date rqsTimeMin) {
		this.rqsTimeMin = rqsTimeMin;
	}

	public Date getRqsTimeMax() {
		return rqsTimeMax;
	}

	public void setRqsTimeMax(Date rqsTimeMax) {
		this.rqsTimeMax = rqsTimeMax;
	}

	public Integer getUserNote() {
		return userNote;
	}

	public void setUserNote(Integer userNote) {
		this.userNote = userNote;
	}

	public Integer getHouseSouseTotal() {
		return houseSouseTotal;
	}

	public void setHouseSouseTotal(Integer houseSouseTotal) {
		this.houseSouseTotal = houseSouseTotal;
	}

	public String getUserAmount() {
		return userAmount;
	}

	public void setUserAmount(String userAmount) {
		this.userAmount = userAmount;
	}

	public String getUserHaoFangAmount() {
		return userHaoFangAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUserHaoFangAmount(String userHaoFangAmount) {
		this.userHaoFangAmount = userHaoFangAmount;
	}

	public Integer getCustom() {
		return custom;
	}

	public void setCustom(Integer custom) {
		this.custom = custom;
	}

	public String getRqsTime() {
		return rqsTime;
	}

	public void setRqsTime(String rqsTime) {
		this.rqsTime = rqsTime;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public BigDecimal getAmountMin() {
		return amountMin;
	}

	public void setAmountMin(BigDecimal amountMin) {
		this.amountMin = amountMin;
	}

	public BigDecimal getAmountMax() {
		return amountMax;
	}

	public void setAmountMax(BigDecimal amountMax) {
		this.amountMax = amountMax;
	}

	public BigDecimal getHaofangAmountMin() {
		return haofangAmountMin;
	}

	public void setHaofangAmountMin(BigDecimal haofangAmountMin) {
		this.haofangAmountMin = haofangAmountMin;
	}

	public BigDecimal getHaofangAmountMax() {
		return haofangAmountMax;
	}

	public void setHaofangAmountMax(BigDecimal haofangAmountMax) {
		this.haofangAmountMax = haofangAmountMax;
	}

	public Integer getBanType() {
		return banType;
	}

	public void setBanType(Integer banType) {
		this.banType = banType;
	}

	public Integer getHouseBidding() {
		return houseBidding;
	}

	public void setHouseBidding(Integer houseBidding) {
		this.houseBidding = houseBidding;
	}

	public Integer getUserBidding() {
		return userBidding;
	}

	public void setUserBidding(Integer userBidding) {
		this.userBidding = userBidding;
	}

	public Integer getWebstoreStatus() {
		return webstoreStatus;
	}

	public void setWebstoreStatus(Integer webstoreStatus) {
		this.webstoreStatus = webstoreStatus;
	}

	public Integer getRqsActualStatus() {
		return rqsActualStatus;
	}

	public void setRqsActualStatus(Integer rqsActualStatus) {
		this.rqsActualStatus = rqsActualStatus;
	}

	public Integer getRqsAptitudeStatus() {
		return rqsAptitudeStatus;
	}

	public void setRqsAptitudeStatus(Integer rqsAptitudeStatus) {
		this.rqsAptitudeStatus = rqsAptitudeStatus;
	}

	public Integer getCrmCompId() {
		return crmCompId;
	}

	public void setCrmCompId(Integer crmCompId) {
		this.crmCompId = crmCompId;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getNewPhoneNum() {
		return newPhoneNum;
	}

	public void setNewPhoneNum(String newPhoneNum) {
		this.newPhoneNum = newPhoneNum;
	}

	public Boolean getUserWriteoff() {
		return userWriteoff;
	}

	public void setUserWriteoff(Boolean userWriteoff) {
		this.userWriteoff = userWriteoff;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
