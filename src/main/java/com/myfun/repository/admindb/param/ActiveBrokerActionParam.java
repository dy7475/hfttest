package com.myfun.repository.admindb.param;

import java.math.BigDecimal;
import java.util.Date;

import com.myfun.repository.support.param.PageParam;

public class ActiveBrokerActionParam extends PageParam{

	private Integer provinceId;
	private String qryType;
	private String activeTimeDay;
	private String activeTimeMonth;
	private String salesName;
	private String deptName;
	private String sofa;
	private String userAmount;
	private String userHaoFangAmount;
	private Integer custom;
	private BigDecimal amountMin;
	private BigDecimal amountMax;
	private BigDecimal haofangAmountMin;
	private BigDecimal haofangAmountMax;
	private Integer userEdition;
	private Integer timeType;
	private Date minTime;
	private Date maxTime;
	private Date loginMinTime;
	private Date loginmaxTime;
	private Date trackMinTime;
	private Date trackMaxTime;
	private Date regMinTime;
	private Date regMaxTime;
	private Date writeOffMinTime;
	private Date writeOffMaxTime;
	private Integer myDeptId;
	
	private String userName;
	private String userMobile;
	private Date superEnd;
	private String serviceZone;
	private Integer cityId;
	private String serviceReg;
	private Integer sellId;
	
	public String getUserName() {
		return userName;
	}
	public String getServiceReg() {
		return serviceReg;
	}
	public void setServiceReg(String serviceReg) {
		this.serviceReg = serviceReg;
	}
	public Integer getSellId() {
		return sellId;
	}
	public void setSellId(Integer sellId) {
		this.sellId = sellId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public Date getSuperEnd() {
		return superEnd;
	}
	public void setSuperEnd(Date superEnd) {
		this.superEnd = superEnd;
	}
	public String getServiceZone() {
		return serviceZone;
	}
	public void setServiceZone(String serviceZone) {
		this.serviceZone = serviceZone;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getMyDeptId() {
		return myDeptId;
	}
	public void setMyDeptId(Integer myDeptId) {
		this.myDeptId = myDeptId;
	}
	public Date getLoginMinTime() {
		return loginMinTime;
	}
	public void setLoginMinTime(Date loginMinTime) {
		this.loginMinTime = loginMinTime;
	}
	public Date getLoginmaxTime() {
		return loginmaxTime;
	}
	public void setLoginmaxTime(Date loginmaxTime) {
		this.loginmaxTime = loginmaxTime;
	}
	public Date getTrackMinTime() {
		return trackMinTime;
	}
	public void setTrackMinTime(Date trackMinTime) {
		this.trackMinTime = trackMinTime;
	}
	public Date getTrackMaxTime() {
		return trackMaxTime;
	}
	public void setTrackMaxTime(Date trackMaxTime) {
		this.trackMaxTime = trackMaxTime;
	}
	public Date getRegMinTime() {
		return regMinTime;
	}
	public void setRegMinTime(Date regMinTime) {
		this.regMinTime = regMinTime;
	}
	public Date getRegMaxTime() {
		return regMaxTime;
	}
	public void setRegMaxTime(Date regMaxTime) {
		this.regMaxTime = regMaxTime;
	}
	public Date getWriteOffMinTime() {
		return writeOffMinTime;
	}
	public void setWriteOffMinTime(Date writeOffMinTime) {
		this.writeOffMinTime = writeOffMinTime;
	}
	public Date getWriteOffMaxTime() {
		return writeOffMaxTime;
	}
	public void setWriteOffMaxTime(Date writeOffMaxTime) {
		this.writeOffMaxTime = writeOffMaxTime;
	}
	public Date getMinTime() {
		return minTime;
	}
	public void setMinTime(Date minTime) {
		this.minTime = minTime;
	}
	public Date getMaxTime() {
		return maxTime;
	}
	public void setMaxTime(Date maxTime) {
		this.maxTime = maxTime;
	}
	
	public Integer getTimeType() {
		return timeType;
	}
	public void setTimeType(Integer timeType) {
		this.timeType = timeType;
	}
	public Integer getUserEdition() {
		return userEdition;
	}
	public void setUserEdition(Integer userEdition) {
		this.userEdition = userEdition;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public String getQryType() {
		return qryType;
	}
	public void setQryType(String qryType) {
		this.qryType = qryType;
	}
	public String getActiveTimeDay() {
		return activeTimeDay;
	}
	public void setActiveTimeDay(String activeTimeDay) {
		this.activeTimeDay = activeTimeDay;
	}
	public String getActiveTimeMonth() {
		return activeTimeMonth;
	}
	public void setActiveTimeMonth(String activeTimeMonth) {
		this.activeTimeMonth = activeTimeMonth;
	}
	public String getSalesName() {
		return salesName;
	}
	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getSofa() {
		return sofa;
	}
	public void setSofa(String sofa) {
		this.sofa = sofa;
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
	public void setUserHaoFangAmount(String userHaoFangAmount) {
		this.userHaoFangAmount = userHaoFangAmount;
	}
	public Integer getCustom() {
		return custom;
	}
	public void setCustom(Integer custom) {
		this.custom = custom;
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
	
}
