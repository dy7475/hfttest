package com.myfun.repository.admindb.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.myfun.repository.admindb.po.AdminFunArchive;

public class AdminFunArchiveDto extends AdminFunArchive{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String USER_NO;
	private String COMP_ID;
	private String USER_JOB_DATE;
	private String code;
	private String msg;
	private Date appLoginTime;
	private String reUserName;
	private String reUserMobile;
	private Integer deptId;
	private String deptName;
	private BigDecimal amount;
	private BigDecimal haofangAmount;
	private String citySuperUser;
	private String superTime;
	/***************/
	private String userPosition;
	private BigDecimal haofangBuy;
	private Integer pubCount;	//经纪人积分，出租+出售
	private Integer rqsActualStatus;	//用户认证请求状态
	private Integer rqsAptitudeStatus;	//资质认证状态
	private Date rqsActualTime;	//实名认证时间
	private Date rqsAptitudeTime;	//资质认证时间
	private String cityName;
	private Boolean city_SuperUser;
	private String icCode;
	private Integer userNote;
	private String processBy;	
	private Date banEndTime;	//禁言结束时间
	private Integer banType;	//禁言、房源下架类型
	private String isVip;
	private Integer hasOtherAgent; //是否有代理商
	private BigDecimal discountAmount; //优惠券
	/*************/
	private Date citySuperTime;
	private Date lastFreeUserTime;
	
	private String rqsActualDesc;
	private String rqsAptitudeDesc;
	private String compName;
	private String name;
	private String compNo;
	private String deptNo;
	private String processByName;
	private String erpCompName;
	private String userNo;
	private Integer coinRanking;
	/*************/
	private String salaryTotal;//当月业绩
	private String baseMoney;//基本薪资
	private String targetProfit;//目标业绩
	private String houseDjCountTotal;//个人房源新增总数
	private String custDjCountTotal;//个人客源新增总数
	private String fkCountTotal;//个人房勘
	private String dkCountTotal;//个人带看
	private String salaryTypeId;//考核id

	private String serviceRegNames;
	
	public String getTargetProfit() {
		return targetProfit;
	}
	public void setTargetProfit(String targetProfit) {
		this.targetProfit = targetProfit;
	}
	public String getSalaryTypeId() {
		return salaryTypeId;
	}
	public void setSalaryTypeId(String salaryTypeId) {
		this.salaryTypeId = salaryTypeId;
	}
	public String getHouseDjCountTotal() {
		return houseDjCountTotal;
	}
	public void setHouseDjCountTotal(String houseDjCountTotal) {
		this.houseDjCountTotal = houseDjCountTotal;
	}
	public String getCustDjCountTotal() {
		return custDjCountTotal;
	}
	public void setCustDjCountTotal(String custDjCountTotal) {
		this.custDjCountTotal = custDjCountTotal;
	}
	public String getFkCountTotal() {
		return fkCountTotal;
	}
	public void setFkCountTotal(String fkCountTotal) {
		this.fkCountTotal = fkCountTotal;
	}
	public String getDkCountTotal() {
		return dkCountTotal;
	}
	public void setDkCountTotal(String dkCountTotal) {
		this.dkCountTotal = dkCountTotal;
	}
	public String getSalaryTotal() {
		return salaryTotal;
	}
	public void setSalaryTotal(String salaryTotal) {
		this.salaryTotal = salaryTotal;
	}
	public String getBaseMoney() {
		return baseMoney;
	}
	public void setBaseMoney(String baseMoney) {
		this.baseMoney = baseMoney;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getCompNo() {
		return compNo;
	}
	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public String getProcessByName() {
		return processByName;
	}
	public void setProcessByName(String processByName) {
		this.processByName = processByName;
	}
	public String getErpCompName() {
		return erpCompName;
	}
	public void setErpCompName(String erpCompName) {
		this.erpCompName = erpCompName;
	}
	public String getRqsActualDesc() {
		return rqsActualDesc;
	}
	public void setRqsActualDesc(String rqsActualDesc) {
		this.rqsActualDesc = rqsActualDesc;
	}
	public String getRqsAptitudeDesc() {
		return rqsAptitudeDesc;
	}
	public void setRqsAptitudeDesc(String rqsAptitudeDesc) {
		this.rqsAptitudeDesc = rqsAptitudeDesc;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCitySuperTime() {
		return citySuperTime;
	}
	public void setCitySuperTime(Date citySuperTime) {
		this.citySuperTime = citySuperTime;
	}
	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}
	public Integer getHasOtherAgent() {
		return hasOtherAgent;
	}
	public void setHasOtherAgent(Integer hasOtherAgent) {
		this.hasOtherAgent = hasOtherAgent;
	}
	public String getIsVip() {
		return isVip;
	}
	public void setIsVip(String isVip) {
		this.isVip = isVip;
	}
	public String getUserPosition() {
		return userPosition;
	}
	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}
	public BigDecimal getHaofangBuy() {
		return haofangBuy;
	}
	public void setHaofangBuy(BigDecimal haofangBuy) {
		this.haofangBuy = haofangBuy;
	}
	public Integer getPubCount() {
		return pubCount;
	}
	public void setPubCount(Integer pubCount) {
		this.pubCount = pubCount;
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
	public Date getRqsActualTime() {
		return rqsActualTime;
	}
	public void setRqsActualTime(Date rqsActualTime) {
		this.rqsActualTime = rqsActualTime;
	}
	public Date getRqsAptitudeTime() {
		return rqsAptitudeTime;
	}
	public void setRqsAptitudeTime(Date rqsAptitudeTime) {
		this.rqsAptitudeTime = rqsAptitudeTime;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Boolean getCity_SuperUser() {
		return city_SuperUser;
	}
	public void setCity_SuperUser(Boolean city_SuperUser) {
		this.city_SuperUser = city_SuperUser;
	}
	public String getIcCode() {
		return icCode;
	}
	public void setIcCode(String icCode) {
		this.icCode = icCode;
	}
	public Integer getUserNote() {
		return userNote;
	}
	public void setUserNote(Integer userNote) {
		this.userNote = userNote;
	}
	public String getProcessBy() {
		return processBy;
	}
	public void setProcessBy(String processBy) {
		this.processBy = processBy;
	}
	public Date getBanEndTime() {
		return banEndTime;
	}
	public void setBanEndTime(Date banEndTime) {
		this.banEndTime = banEndTime;
	}
	public Integer getBanType() {
		return banType;
	}
	public void setBanType(Integer banType) {
		this.banType = banType;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getHaofangAmount() {
		return haofangAmount;
	}
	public void setHaofangAmount(BigDecimal haofangAmount) {
		this.haofangAmount = haofangAmount;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getUSER_NO() {
		return USER_NO;
	}
	public void setUSER_NO(String uSER_NO) {
		USER_NO = uSER_NO;
	}
	public String getCOMP_ID() {
		return COMP_ID;
	}
	public void setCOMP_ID(String cOMP_ID) {
		COMP_ID = cOMP_ID;
	}
	public String getUSER_JOB_DATE() {
		return USER_JOB_DATE;
	}
	public void setUSER_JOB_DATE(String uSER_JOB_DATE) {
		USER_JOB_DATE = uSER_JOB_DATE;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getReUserName() {
		return reUserName;
	}
	public void setReUserName(String reUserName) {
		this.reUserName = reUserName;
	}
	public String getReUserMobile() {
		return reUserMobile;
	}
	public void setReUserMobile(String reUserMobile) {
		this.reUserMobile = reUserMobile;
	}
	public Date getAppLoginTime() {
		return appLoginTime;
	}
	public void setAppLoginTime(Date appLoginTime) {
		this.appLoginTime = appLoginTime;
	}
	public String getCitySuperUser() {
		return citySuperUser;
	}
	public void setCitySuperUser(String citySuperUser) {
		this.citySuperUser = citySuperUser;
	}
	public String getSuperTime() {
		return superTime;
	}
	public void setSuperTime(String superTime) {
		this.superTime = superTime;
	}
	public Integer getCoinRanking() {
		return coinRanking;
	}
	public void setCoinRanking(Integer coinRanking) {
		this.coinRanking = coinRanking;
	}
	public Date getLastFreeUserTime() {
		return lastFreeUserTime;
	}
	public void setLastFreeUserTime(Date lastFreeUserTime) {
		this.lastFreeUserTime = lastFreeUserTime;
	}
	public String getServiceRegNames() {
		return serviceRegNames;
	}
	public void setServiceRegNames(String serviceRegNames) {
		this.serviceRegNames = serviceRegNames;
	}
	
}
