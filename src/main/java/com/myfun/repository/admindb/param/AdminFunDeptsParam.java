package com.myfun.repository.admindb.param;

import java.util.Date;

import com.myfun.repository.support.param.PageParam;

public class AdminFunDeptsParam extends PageParam {

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	private Integer deptId;
	private String deptName;
	private String deptCname;
	private Integer provinceId;
	private Integer cityId;
	private Integer regionId;
	private Integer compId;
	private Integer deptType;
	private String deptStatus;
	private String type;
	private Integer deptFlag;
	private String deptLevel;
	private String deptSource;
	private String deptDesc;
	private Date trackTime;
	private Integer sellId;
	private Integer crmDeptId;
	private Date creationTime1;
	private Date creationTime2;
	private String compNo;
	private String deptNo;
	private Date tryEnd;
	private Date tryTime1;
	private Date tryTime2;
	private Integer installLicense;
	private Integer installCount;
	private Date recTime;
	private Date visitedTime;
	private Integer trainCount;
	private Integer trainClose;
	private Integer crmCompId;
	private String trainSubject;
	private Integer srvStatus;
	private Integer plateType;
	private Integer redFlag;
	private Date redFlagTime;
	private Date orangeFlagTime;
	private Integer orangeFlag;
	private Integer serviceId;
	private Date otoEnd;
	private Date formTime1;
	private Date formTime2;
	private Date spaceEnd1;
	private Date spaceEnd2;
	private Integer lendonPerson;
	private Integer wxallowanceFlag;
	private Integer compWeixinStatus;
	private Integer youjiaDeptFlag;
	private Integer cionGift;
	private Integer giftResult;
	private Integer cionAmount;
	private Integer quanAmount;
	private Integer vipFlag;
	private Integer vipCount;
	private Integer payType;
	private Integer superFlag;
	private Integer custLevel;
	private Date advanceTryend;
	private Integer specialFlag;
	private Integer specialCrmdeptId;
	private String keyWords;
	private String contactPhone;
	private Integer lastLoginType;
	private Date lastLoginTime;

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

	public String getDeptCname() {
		return deptCname;
	}

	public void setDeptCname(String deptCname) {
		this.deptCname = deptCname;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
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

	public Integer getDeptType() {
		return deptType;
	}

	public void setDeptType(Integer deptType) {
		this.deptType = deptType;
	}

	public String getDeptStatus() {
		return deptStatus;
	}

	public void setDeptStatus(String deptStatus) {
		this.deptStatus = deptStatus;
	}

	public String getDeptLevel() {
		return deptLevel;
	}

	public void setDeptLevel(String deptLevel) {
		this.deptLevel = deptLevel;
	}

	public String getDeptSource() {
		return deptSource;
	}

	public void setDeptSource(String deptSource) {
		this.deptSource = deptSource;
	}

	public String getDeptDesc() {
		return deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	public Date getTrackTime() {
		return trackTime;
	}

	public void setTrackTime(Date trackTime) {
		this.trackTime = trackTime;
	}

	public Integer getSellId() {
		return sellId;
	}

	public void setSellId(Integer sellId) {
		this.sellId = sellId;
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

	public Date getTryEnd() {
		return tryEnd;
	}

	public void setTryEnd(Date tryEnd) {
		this.tryEnd = tryEnd;
	}

	public Integer getInstallLicense() {
		return installLicense;
	}

	public void setInstallLicense(Integer installLicense) {
		this.installLicense = installLicense;
	}

	public Integer getInstallCount() {
		return installCount;
	}

	public void setInstallCount(Integer installCount) {
		this.installCount = installCount;
	}

	public Date getRecTime() {
		return recTime;
	}

	public void setRecTime(Date recTime) {
		this.recTime = recTime;
	}

	public Date getVisitedTime() {
		return visitedTime;
	}

	public void setVisitedTime(Date visitedTime) {
		this.visitedTime = visitedTime;
	}

	public Integer getTrainCount() {
		return trainCount;
	}

	public void setTrainCount(Integer trainCount) {
		this.trainCount = trainCount;
	}

	public Integer getTrainClose() {
		return trainClose;
	}

	public void setTrainClose(Integer trainClose) {
		this.trainClose = trainClose;
	}

	public Integer getCrmCompId() {
		return crmCompId;
	}

	public void setCrmCompId(Integer crmCompId) {
		this.crmCompId = crmCompId;
	}

	public String getTrainSubject() {
		return trainSubject;
	}

	public void setTrainSubject(String trainSubject) {
		this.trainSubject = trainSubject;
	}

	public Integer getSrvStatus() {
		return srvStatus;
	}

	public void setSrvStatus(Integer srvStatus) {
		this.srvStatus = srvStatus;
	}

	public Integer getPlateType() {
		return plateType;
	}

	public void setPlateType(Integer plateType) {
		this.plateType = plateType;
	}

	public Integer getRedFlag() {
		return redFlag;
	}

	public void setRedFlag(Integer redFlag) {
		this.redFlag = redFlag;
	}

	public Date getRedFlagTime() {
		return redFlagTime;
	}

	public void setRedFlagTime(Date redFlagTime) {
		this.redFlagTime = redFlagTime;
	}

	public Integer getOrangeFlag() {
		return orangeFlag;
	}

	public void setOrangeFlag(Integer orangeFlag) {
		this.orangeFlag = orangeFlag;
	}

	public Date getOrangeFlagTime() {
		return orangeFlagTime;
	}

	public void setOrangeFlagTime(Date orangeFlagTime) {
		this.orangeFlagTime = orangeFlagTime;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Date getOtoEnd() {
		return otoEnd;
	}

	public void setOtoEnd(Date otoEnd) {
		this.otoEnd = otoEnd;
	}

	public Integer getLendonPerson() {
		return lendonPerson;
	}

	public void setLendonPerson(Integer lendonPerson) {
		this.lendonPerson = lendonPerson;
	}

	public Integer getWxallowanceFlag() {
		return wxallowanceFlag;
	}

	public void setWxallowanceFlag(Integer wxallowanceFlag) {
		this.wxallowanceFlag = wxallowanceFlag;
	}

	public Integer getCompWeixinStatus() {
		return compWeixinStatus;
	}

	public void setCompWeixinStatus(Integer compWeixinStatus) {
		this.compWeixinStatus = compWeixinStatus;
	}

	public Integer getYoujiaDeptFlag() {
		return youjiaDeptFlag;
	}

	public void setYoujiaDeptFlag(Integer youjiaDeptFlag) {
		this.youjiaDeptFlag = youjiaDeptFlag;
	}

	public Integer getCionGift() {
		return cionGift;
	}

	public void setCionGift(Integer cionGift) {
		this.cionGift = cionGift;
	}

	public Integer getGiftResult() {
		return giftResult;
	}

	public void setGiftResult(Integer giftResult) {
		this.giftResult = giftResult;
	}

	public Integer getCionAmount() {
		return cionAmount;
	}

	public void setCionAmount(Integer cionAmount) {
		this.cionAmount = cionAmount;
	}

	public Integer getQuanAmount() {
		return quanAmount;
	}

	public void setQuanAmount(Integer quanAmount) {
		this.quanAmount = quanAmount;
	}

	public Integer getVipFlag() {
		return vipFlag;
	}

	public void setVipFlag(Integer vipFlag) {
		this.vipFlag = vipFlag;
	}

	public Integer getVipCount() {
		return vipCount;
	}

	public void setVipCount(Integer vipCount) {
		this.vipCount = vipCount;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Integer getSuperFlag() {
		return superFlag;
	}

	public void setSuperFlag(Integer superFlag) {
		this.superFlag = superFlag;
	}

	public Integer getCustLevel() {
		return custLevel;
	}

	public void setCustLevel(Integer custLevel) {
		this.custLevel = custLevel;
	}

	public Date getAdvanceTryend() {
		return advanceTryend;
	}

	public void setAdvanceTryend(Date advanceTryend) {
		this.advanceTryend = advanceTryend;
	}

	public Integer getDeptFlag() {
		return deptFlag;
	}

	public void setDeptFlag(Integer deptFlag) {
		this.deptFlag = deptFlag;
	}

	public Integer getSpecialFlag() {
		return specialFlag;
	}

	public void setSpecialFlag(Integer specialFlag) {
		this.specialFlag = specialFlag;
	}

	public Integer getSpecialCrmdeptId() {
		return specialCrmdeptId;
	}

	public void setSpecialCrmdeptId(Integer specialCrmdeptId) {
		this.specialCrmdeptId = specialCrmdeptId;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public Integer getCrmDeptId() {
		return crmDeptId;
	}

	public void setCrmDeptId(Integer crmDeptId) {
		this.crmDeptId = crmDeptId;
	}

	public Date getCreationTime1() {
		return creationTime1;
	}

	public void setCreationTime1(Date creationTime1) {
		this.creationTime1 = creationTime1;
	}

	public Date getCreationTime2() {
		return creationTime2;
	}

	public void setCreationTime2(Date creationTime2) {
		this.creationTime2 = creationTime2;
	}

	public Date getFormTime1() {
		return formTime1;
	}

	public void setFormTime1(Date formTime1) {
		this.formTime1 = formTime1;
	}

	public Date getFormTime2() {
		return formTime2;
	}

	public void setFormTime2(Date formTime2) {
		this.formTime2 = formTime2;
	}

	public Integer getLastLoginType() {
		return lastLoginType;
	}

	public void setLastLoginType(Integer lastLoginType) {
		this.lastLoginType = lastLoginType;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getTryTime1() {
		return tryTime1;
	}

	public void setTryTime1(Date tryTime1) {
		this.tryTime1 = tryTime1;
	}

	public Date getTryTime2() {
		return tryTime2;
	}

	public void setTryTime2(Date tryTime2) {
		this.tryTime2 = tryTime2;
	}

	public Date getSpaceEnd1() {
		return spaceEnd1;
	}

	public void setSpaceEnd1(Date spaceEnd1) {
		this.spaceEnd1 = spaceEnd1;
	}

	public Date getSpaceEnd2() {
		return spaceEnd2;
	}

	public void setSpaceEnd2(Date spaceEnd2) {
		this.spaceEnd2 = spaceEnd2;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
