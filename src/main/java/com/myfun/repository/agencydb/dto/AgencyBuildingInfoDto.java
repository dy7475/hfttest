package com.myfun.repository.agencydb.dto;

import com.myfun.repository.agencydb.po.AgencyBuildingInfo;

public class AgencyBuildingInfoDto extends AgencyBuildingInfo{
	private static final long serialVersionUID = 1L;
	
	private String cityName;
	private String provinceName;
	private String compCname;
	private Integer Id;
	private String contractNo;
	private Integer repeatDay;
	private Integer bandRewardNum;
	private Integer draw;
	private String bandSaw;
	private Long loginUid;
	private String buildingAdminName;
	private Integer deptId;
	
	private String compName;
	private String sectionName;
	private String userName;
	
	private Integer participatingBroker;
	private String  settledCommission;
	
	private String  report;
	private String see;
	private String subScription;
	private String commissionJunction;
	private String photoAddr;
	private Integer customerNum;
	private Integer archiveNum;
	private String actContent;
	private Integer bCityId;
	private String groupSpecial;
	private String soleSpecial;
	private String commission;
	private Integer bandReward;
	private Integer dealReward;
	private String cooperateStart;
	private String cooperateEnd;
	
	private String priceUnit;
	private String totalPriceLow;
	private String totalPriceHigh;
	private String buildType;
	private String devloperName;
	private String sellTele;
	private String priceText;
	private String buildName;
	private String buildAddr;
	private String projectSpec;

	public String getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}

	public String getTotalPriceLow() {
		return totalPriceLow;
	}

	public void setTotalPriceLow(String totalPriceLow) {
		this.totalPriceLow = totalPriceLow;
	}

	public String getTotalPriceHigh() {
		return totalPriceHigh;
	}

	public void setTotalPriceHigh(String totalPriceHigh) {
		this.totalPriceHigh = totalPriceHigh;
	}

	public String getBuildType() {
		return buildType;
	}

	public void setBuildType(String buildType) {
		this.buildType = buildType;
	}

	public String getDevloperName() {
		return devloperName;
	}

	public void setDevloperName(String devloperName) {
		this.devloperName = devloperName;
	}

	public String getSellTele() {
		return sellTele;
	}

	public void setSellTele(String sellTele) {
		this.sellTele = sellTele;
	}

	public String getPriceText() {
		return priceText;
	}

	public void setPriceText(String priceText) {
		this.priceText = priceText;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public String getBuildAddr() {
		return buildAddr;
	}

	public void setBuildAddr(String buildAddr) {
		this.buildAddr = buildAddr;
	}

	public String getProjectSpec() {
		return projectSpec;
	}

	public void setProjectSpec(String projectSpec) {
		this.projectSpec = projectSpec;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getGroupSpecial() {
		return groupSpecial;
	}

	public void setGroupSpecial(String groupSpecial) {
		this.groupSpecial = groupSpecial;
	}

	public Integer getbCityId() {
		return bCityId;
	}

	public void setbCityId(Integer bCityId) {
		this.bCityId = bCityId;
	}

	public Integer getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(Integer customerNum) {
		this.customerNum = customerNum;
	}

	public Integer getArchiveNum() {
		return archiveNum;
	}

	public void setArchiveNum(Integer archiveNum) {
		this.archiveNum = archiveNum;
	}

	public String getActContent() {
		return actContent;
	}

	public void setActContent(String actContent) {
		this.actContent = actContent;
	}

	public String getPhotoAddr() {
		return photoAddr;
	}

	public void setPhotoAddr(String photoAddr) {
		this.photoAddr = photoAddr;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public String getSee() {
		return see;
	}

	public void setSee(String see) {
		this.see = see;
	}

	public String getSubScription() {
		return subScription;
	}

	public void setSubScription(String subScription) {
		this.subScription = subScription;
	}

	public String getCommissionJunction() {
		return commissionJunction;
	}

	public void setCommissionJunction(String commissionJunction) {
		this.commissionJunction = commissionJunction;
	}

	public Integer getParticipatingBroker() {
		return participatingBroker;
	}

	public void setParticipatingBroker(Integer participatingBroker) {
		this.participatingBroker = participatingBroker;
	}

	public String getSettledCommission() {
		return settledCommission;
	}

	public void setSettledCommission(String settledCommission) {
		this.settledCommission = settledCommission;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getBuildingAdminName() {
		return buildingAdminName;
	}

	public void setBuildingAdminName(String buildingAdminName) {
		this.buildingAdminName = buildingAdminName;
	}

	public String getCompCname() {
		return compCname;
	}

	public void setCompCname(String compCname) {
		this.compCname = compCname;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public Integer getRepeatDay() {
		return repeatDay;
	}

	public void setRepeatDay(Integer repeatDay) {
		this.repeatDay = repeatDay;
	}

	public Integer getBandRewardNum() {
		return bandRewardNum;
	}

	public void setBandRewardNum(Integer bandRewardNum) {
		this.bandRewardNum = bandRewardNum;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public String getBandSaw() {
		return bandSaw;
	}

	public void setBandSaw(String bandSaw) {
		this.bandSaw = bandSaw;
	}

	public String getSoleSpecial() {
		return soleSpecial;
	}

	public void setSoleSpecial(String soleSpecial) {
		this.soleSpecial = soleSpecial;
	}

	public Integer getBandReward() {
		return bandReward;
	}

	public void setBandReward(Integer bandReward) {
		this.bandReward = bandReward;
	}

	public Integer getDealReward() {
		return dealReward;
	}

	public void setDealReward(Integer dealReward) {
		this.dealReward = dealReward;
	}

	public String getCooperateStart() {
		return cooperateStart;
	}

	public void setCooperateStart(String cooperateStart) {
		this.cooperateStart = cooperateStart;
	}

	public String getCooperateEnd() {
		return cooperateEnd;
	}

	public void setCooperateEnd(String cooperateEnd) {
		this.cooperateEnd = cooperateEnd;
	}

	public Long getLoginUid() {
		return loginUid;
	}

	public void setLoginUid(Long loginUid) {
		this.loginUid = loginUid;
	}

	public String getCommission() {
		return commission;
	}

	public void setCommission(String commission) {
		this.commission = commission;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
}
