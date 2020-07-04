package com.myfun.repository.erpdb.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author czq
 * @since 2019/3/19
 */
public class ErpFunDealDtoVo extends ErpFunDealVo {

    private Integer adminCompId;
    private Integer adminDeptId;
    private Byte areaFlag;
    private String compName;
    private Integer customerphoneCanUpgrade;
    private Integer ownerphoneCanUpgrade;
    private String hftdealQraddr;
    private String youDockingUid;
    private String youDockingMobile;
    private String signUserPhone;
    private Integer jrFinanceId;
    private String contractIds;

    private BigDecimal incomeAmount;
    private BigDecimal performanceAmount;
    private Date incomeTime;
    private BigDecimal dividedAmount;
    private BigDecimal distributionPercent;
    private Integer performanceId;
    private String performanceName;
    private String signMonth;
    private String incomeMonth;
    private String settlementMonth;
    private BigDecimal payAmount;
    private BigDecimal plannedDistribution;
    private Byte collentStatus;
    private Integer userId;
    private String auditUser;

    private BigDecimal profitProportion;
    private BigDecimal profitMoney;
    private BigDecimal receivableMoney;
    private String perfrmanceName;
    private Byte performanceType;

    private BigDecimal counts;
    private BigDecimal priceUnit;
    private Integer areaTotle;
    private String showText;

    //业绩龙虎榜统计参数
    private BigDecimal transferDealProfit;
    private BigDecimal transferTotalProfit;
    private BigDecimal secondhandDealProfit;
    private BigDecimal secondhandTotalProfit;
    private BigDecimal newhouseDealProfit;
    private BigDecimal newhouseTotalProfit;
    private BigDecimal leaseDealProfitl;
    private BigDecimal leaseTotalProfit;
    private BigDecimal financeDealProfit;
    private BigDecimal financeTotalProfit;
    private BigDecimal totalProfit;
    private BigDecimal dealTotalProfit;
    private BigDecimal secondhandDealCount;
    private BigDecimal newhouseDealCount;
    private BigDecimal leaseDealCount;
    private BigDecimal totalDealCount;
    private BigDecimal transferCount;
    private BigDecimal financeCount;
    private BigDecimal totaltfCount;
    private BigDecimal targetProfit;
    private String range;
    private String bbsPhoto;
    private Integer grId;
    private Integer archiveId;

    private Integer houseArchiveId; //房源所属经纪人档案ID IM用
    private Integer custArchiveId; //客源所属经纪人档案ID IM用
    private Integer signArchiveId; //签约人档案ID   IM用
    private Integer dealArchiveId; //主办人档案ID   IM用
    private Integer signManagerArchiveId; //签约主管档案ID IM用

    @ApiModelProperty(value = "负责人头像")
    private String dealUserPhoto; //负责人头像
    //已办结
    private Integer attr;
    private Integer repeatDealId;
    private Integer stepNum;

    private Byte housePriceUnit;

    private Boolean profitPerson = false;

    @ApiModelProperty(value = "是否相关人")
    private Boolean isRelated;

    @ApiModelProperty(value = "初审时间")
    private String firstTrialCompleteDate;

    @ApiModelProperty(value = "复审时间")
    private String recheckCompleteDate;

    @ApiModelProperty(value = "作废时间")
    private String invalidCompleteDate;
    @ApiModelProperty(value = "合同详情web地址")
    private String contractUrl;
    @ApiModelProperty(value = "丙方公司全称")
    private String thirdcompName;
    @ApiModelProperty(value = "丙方联系地址")
    private String thirdaddress;
    @ApiModelProperty(value = "丙方公司电话")
    private String thirdcompPhoneNum;
    @ApiModelProperty(value = "小程序二维码地址")
    private String appletQrcode;

    @ApiModelProperty(value = "合同作废前的状态")
    private Byte dealAuditStatusBefore;
    @ApiModelProperty(value = "签约类型 0=线下 1=线上 2=均可")
    private Byte signType;
    @ApiModelProperty(value = "是否完成上上签 0= 未完成 1=已完成")
    private Integer contractStatus ;

    @ApiModelProperty(value = "已经作废的上上签合同文案列表, 本合同签订之日起，之前签署的上上签合同编号为xxx的合同自动作废。")
    private List<String> invalidContracts;
    @ApiModelProperty(value = "付款方式文本值")
    private String rentPayMethodText="";
    @ApiModelProperty(value = "权属文本值")
    private String ownerStyleText="";
    @ApiModelProperty(value = "面积文本值")
    private String areaText="";
    @ApiModelProperty(value = "成交租金/成交价格")
    private String dealMoney;
    @ApiModelProperty(value = "几室/厅")
    private Byte houseRoom;
    @ApiModelProperty(value = "是否开通在线签约")
    private Byte showOnlineSign;
    
    @ApiModelProperty(value = "介绍姓名")
    private String introducerName; 
    @ApiModelProperty(value = "介绍人电话")
    private String introducerPhone;
    @ApiModelProperty(value = "促成人姓名")
    private String adultPromotionName; 
    @ApiModelProperty(value = "促成人电话")
    private String adultPromotionPhone; 
	@ApiModelProperty(value = "签约地点门店ID")
	private Integer signSiteDept;
	@ApiModelProperty(value = "签约地点分组ID")
	private Integer signSiteGr;
	@ApiModelProperty(value = "签约地点-门店名称")
    private String signSiteDeptName; 
    @ApiModelProperty(value = "签约地点-分组名称")
    private String signSiteGrName;
    @ApiModelProperty(value = "流程负责人组织ID")
    private Integer dealUserOrgId;

	@ApiModelProperty(value = "介绍人id")
	private Integer introducerId;
	@ApiModelProperty(value = "促成人id	")
	private Integer adultPromotionId;

    @ApiModelProperty("是否可以查看合同附件 0=不可以 1=可以")
    private Integer canSee;
    
    @ApiModelProperty(value = "楼盘推广名 美联用")
    private String promotionName;
    
    @ApiModelProperty(hidden = true)
    private boolean hasAuth;

    public boolean isHasAuth() {
        return hasAuth;
    }

    public void setHasAuth(boolean hasAuth) {
        this.hasAuth = hasAuth;
    }
    
    
    public String getPromotionName() {
        return promotionName;
    }
    
    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }
    
    public Boolean getIsRelated() {
		return isRelated;
	}

	public void setIsRelated(Boolean isRelated) {
		this.isRelated = isRelated;
	}

	public String getIntroducerName() {
		return introducerName;
	}

	public void setIntroducerName(String introducerName) {
		this.introducerName = introducerName;
	}

	public String getIntroducerPhone() {
		return introducerPhone;
	}

	public void setIntroducerPhone(String introducerPhone) {
		this.introducerPhone = introducerPhone;
	}

	public String getAdultPromotionName() {
		return adultPromotionName;
	}

	public void setAdultPromotionName(String adultPromotionName) {
		this.adultPromotionName = adultPromotionName;
	}

	public String getAdultPromotionPhone() {
		return adultPromotionPhone;
	}

	public void setAdultPromotionPhone(String adultPromotionPhone) {
		this.adultPromotionPhone = adultPromotionPhone;
	}

	public String getSignSiteGrName() {
		return signSiteGrName;
	}

	public void setSignSiteGrName(String signSiteGrName) {
		this.signSiteGrName = signSiteGrName;
	}

	public Integer getIntroducerId() {
		return introducerId;
	}

	public void setIntroducerId(Integer introducerId) {
		this.introducerId = introducerId;
	}

	public Integer getAdultPromotionId() {
		return adultPromotionId;
	}

	public void setAdultPromotionId(Integer adultPromotionId) {
		this.adultPromotionId = adultPromotionId;
	}

	public Integer getCanSee() {
		return canSee;
	}

	public void setCanSee(Integer canSee) {
		this.canSee = canSee;
	}

	public Integer getSignSiteDept() {
		return signSiteDept;
	}

	public void setSignSiteDept(Integer signSiteDept) {
		this.signSiteDept = signSiteDept;
	}

	public Integer getSignSiteGr() {
		return signSiteGr;
	}

	public void setSignSiteGr(Integer signSiteGr) {
		this.signSiteGr = signSiteGr;
	}

	public String getSignSiteDeptName() {
		return signSiteDeptName;
	}

	public void setSignSiteDeptName(String signSiteDeptName) {
		this.signSiteDeptName = signSiteDeptName;
	}

    public Boolean getRelated() {
        return isRelated;
    }

    public void setRelated(Boolean related) {
        isRelated = related;
    }

    public Byte getHouseRoom() {
        return houseRoom;
    }

    public void setHouseRoom(Byte houseRoom) {
        this.houseRoom = houseRoom;
    }

    public String getDealMoney() {
        return dealMoney;
    }

    public void setDealMoney(String dealMoney) {
        this.dealMoney = dealMoney;
    }

    public Integer getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(Integer contractStatus) {
        this.contractStatus = contractStatus;
    }

    public String getAreaText() {
        return areaText;
    }

    public void setAreaText(String areaText) {
        this.areaText = areaText;
    }

    public String getOwnerStyleText() {
        return ownerStyleText;
    }

    public void setOwnerStyleText(String ownerStyleText) {
        this.ownerStyleText = ownerStyleText;
    }

    public String getRentPayMethodText() {
        return rentPayMethodText;
    }

    public void setRentPayMethodText(String rentPayMethodText) {
        this.rentPayMethodText = rentPayMethodText;
    }

    public Byte getDealAuditStatusBefore() {
        return dealAuditStatusBefore;
    }

    public void setDealAuditStatusBefore(Byte dealAuditStatusBefore) {
        this.dealAuditStatusBefore = dealAuditStatusBefore;
    }

    public String getFirstTrialCompleteDate() {
        return firstTrialCompleteDate;
    }

    public void setFirstTrialCompleteDate(String firstTrialCompleteDate) {
        this.firstTrialCompleteDate = firstTrialCompleteDate;
    }

    public String getRecheckCompleteDate() {
        return recheckCompleteDate;
    }

    public void setRecheckCompleteDate(String recheckCompleteDate) {
        this.recheckCompleteDate = recheckCompleteDate;
    }

    public String getInvalidCompleteDate() {
        return invalidCompleteDate;
    }

    public void setInvalidCompleteDate(String invalidCompleteDate) {
        this.invalidCompleteDate = invalidCompleteDate;
    }

    public Boolean getProfitPerson() {
        return profitPerson;
    }

    public void setProfitPerson(Boolean profitPerson) {
        this.profitPerson = profitPerson;
    }

    public Integer getAdminCompId() {
        return adminCompId;
    }

    public void setAdminCompId(Integer adminCompId) {
        this.adminCompId = adminCompId;
    }

    public Integer getAdminDeptId() {
        return adminDeptId;
    }

    public void setAdminDeptId(Integer adminDeptId) {
        this.adminDeptId = adminDeptId;
    }

    public Byte getAreaFlag() {
        return areaFlag;
    }

    public void setAreaFlag(Byte areaFlag) {
        this.areaFlag = areaFlag;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public Integer getCustomerphoneCanUpgrade() {
        return customerphoneCanUpgrade;
    }

    public void setCustomerphoneCanUpgrade(Integer customerphoneCanUpgrade) {
        this.customerphoneCanUpgrade = customerphoneCanUpgrade;
    }

    public Integer getOwnerphoneCanUpgrade() {
        return ownerphoneCanUpgrade;
    }

    public void setOwnerphoneCanUpgrade(Integer ownerphoneCanUpgrade) {
        this.ownerphoneCanUpgrade = ownerphoneCanUpgrade;
    }

    public String getHftdealQraddr() {
        return hftdealQraddr;
    }

    public void setHftdealQraddr(String hftdealQraddr) {
        this.hftdealQraddr = hftdealQraddr;
    }

    public String getYouDockingUid() {
        return youDockingUid;
    }

    public void setYouDockingUid(String youDockingUid) {
        this.youDockingUid = youDockingUid;
    }

    public String getYouDockingMobile() {
        return youDockingMobile;
    }

    public void setYouDockingMobile(String youDockingMobile) {
        this.youDockingMobile = youDockingMobile;
    }

    public String getSignUserPhone() {
        return signUserPhone;
    }

    public void setSignUserPhone(String signUserPhone) {
        this.signUserPhone = signUserPhone;
    }

    public Integer getJrFinanceId() {
        return jrFinanceId;
    }

    public void setJrFinanceId(Integer jrFinanceId) {
        this.jrFinanceId = jrFinanceId;
    }

    public String getContractIds() {
        return contractIds;
    }

    public void setContractIds(String contractIds) {
        this.contractIds = contractIds;
    }

    public BigDecimal getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(BigDecimal incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public BigDecimal getPerformanceAmount() {
        return performanceAmount;
    }

    public void setPerformanceAmount(BigDecimal performanceAmount) {
        this.performanceAmount = performanceAmount;
    }

    public Date getIncomeTime() {
        return incomeTime;
    }

    public void setIncomeTime(Date incomeTime) {
        this.incomeTime = incomeTime;
    }

    public BigDecimal getDividedAmount() {
        return dividedAmount;
    }

    public void setDividedAmount(BigDecimal dividedAmount) {
        this.dividedAmount = dividedAmount;
    }

    public BigDecimal getDistributionPercent() {
        return distributionPercent;
    }

    public void setDistributionPercent(BigDecimal distributionPercent) {
        this.distributionPercent = distributionPercent;
    }

    public Integer getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Integer performanceId) {
        this.performanceId = performanceId;
    }

    public String getPerformanceName() {
        return performanceName;
    }

    public void setPerformanceName(String performanceName) {
        this.performanceName = performanceName;
    }

    public String getSignMonth() {
        return signMonth;
    }

    public void setSignMonth(String signMonth) {
        this.signMonth = signMonth;
    }

    public String getIncomeMonth() {
        return incomeMonth;
    }

    public void setIncomeMonth(String incomeMonth) {
        this.incomeMonth = incomeMonth;
    }

    public String getSettlementMonth() {
        return settlementMonth;
    }

    public void setSettlementMonth(String settlementMonth) {
        this.settlementMonth = settlementMonth;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getPlannedDistribution() {
        return plannedDistribution;
    }

    public void setPlannedDistribution(BigDecimal plannedDistribution) {
        this.plannedDistribution = plannedDistribution;
    }

    public Byte getCollentStatus() {
        return collentStatus;
    }

    public void setCollentStatus(Byte collentStatus) {
        this.collentStatus = collentStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAuditUser() {
        return auditUser;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser;
    }

    public BigDecimal getProfitProportion() {
        return profitProportion;
    }

    public void setProfitProportion(BigDecimal profitProportion) {
        this.profitProportion = profitProportion;
    }

    public BigDecimal getProfitMoney() {
        return profitMoney;
    }

    public void setProfitMoney(BigDecimal profitMoney) {
        this.profitMoney = profitMoney;
    }

    public BigDecimal getReceivableMoney() {
        return receivableMoney;
    }

    public void setReceivableMoney(BigDecimal receivableMoney) {
        this.receivableMoney = receivableMoney;
    }

    public String getPerfrmanceName() {
        return perfrmanceName;
    }

    public void setPerfrmanceName(String perfrmanceName) {
        this.perfrmanceName = perfrmanceName;
    }

    public Byte getPerformanceType() {
        return performanceType;
    }

    public void setPerformanceType(Byte performanceType) {
        this.performanceType = performanceType;
    }

    public BigDecimal getCounts() {
        return counts;
    }

    public void setCounts(BigDecimal counts) {
        this.counts = counts;
    }

    public BigDecimal getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(BigDecimal priceUnit) {
        this.priceUnit = priceUnit;
    }

    public Integer getAreaTotle() {
        return areaTotle;
    }

    public void setAreaTotle(Integer areaTotle) {
        this.areaTotle = areaTotle;
    }

    public String getShowText() {
        return showText;
    }

    public void setShowText(String showText) {
        this.showText = showText;
    }

    public BigDecimal getTransferDealProfit() {
        return transferDealProfit;
    }

    public void setTransferDealProfit(BigDecimal transferDealProfit) {
        this.transferDealProfit = transferDealProfit;
    }

    public BigDecimal getTransferTotalProfit() {
        return transferTotalProfit;
    }

    public void setTransferTotalProfit(BigDecimal transferTotalProfit) {
        this.transferTotalProfit = transferTotalProfit;
    }

    public BigDecimal getSecondhandDealProfit() {
        return secondhandDealProfit;
    }

    public void setSecondhandDealProfit(BigDecimal secondhandDealProfit) {
        this.secondhandDealProfit = secondhandDealProfit;
    }

    public BigDecimal getSecondhandTotalProfit() {
        return secondhandTotalProfit;
    }

    public void setSecondhandTotalProfit(BigDecimal secondhandTotalProfit) {
        this.secondhandTotalProfit = secondhandTotalProfit;
    }

    public BigDecimal getNewhouseDealProfit() {
        return newhouseDealProfit;
    }

    public void setNewhouseDealProfit(BigDecimal newhouseDealProfit) {
        this.newhouseDealProfit = newhouseDealProfit;
    }

    public BigDecimal getNewhouseTotalProfit() {
        return newhouseTotalProfit;
    }

    public void setNewhouseTotalProfit(BigDecimal newhouseTotalProfit) {
        this.newhouseTotalProfit = newhouseTotalProfit;
    }

    public BigDecimal getLeaseDealProfitl() {
        return leaseDealProfitl;
    }

    public void setLeaseDealProfitl(BigDecimal leaseDealProfitl) {
        this.leaseDealProfitl = leaseDealProfitl;
    }

    public BigDecimal getLeaseTotalProfit() {
        return leaseTotalProfit;
    }

    public void setLeaseTotalProfit(BigDecimal leaseTotalProfit) {
        this.leaseTotalProfit = leaseTotalProfit;
    }

    public BigDecimal getFinanceDealProfit() {
        return financeDealProfit;
    }

    public void setFinanceDealProfit(BigDecimal financeDealProfit) {
        this.financeDealProfit = financeDealProfit;
    }

    public BigDecimal getFinanceTotalProfit() {
        return financeTotalProfit;
    }

    public void setFinanceTotalProfit(BigDecimal financeTotalProfit) {
        this.financeTotalProfit = financeTotalProfit;
    }

    public BigDecimal getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(BigDecimal totalProfit) {
        this.totalProfit = totalProfit;
    }

    public BigDecimal getDealTotalProfit() {
        return dealTotalProfit;
    }

    public void setDealTotalProfit(BigDecimal dealTotalProfit) {
        this.dealTotalProfit = dealTotalProfit;
    }

    public BigDecimal getSecondhandDealCount() {
        return secondhandDealCount;
    }

    public void setSecondhandDealCount(BigDecimal secondhandDealCount) {
        this.secondhandDealCount = secondhandDealCount;
    }

    public BigDecimal getNewhouseDealCount() {
        return newhouseDealCount;
    }

    public void setNewhouseDealCount(BigDecimal newhouseDealCount) {
        this.newhouseDealCount = newhouseDealCount;
    }

    public BigDecimal getLeaseDealCount() {
        return leaseDealCount;
    }

    public void setLeaseDealCount(BigDecimal leaseDealCount) {
        this.leaseDealCount = leaseDealCount;
    }

    public BigDecimal getTotalDealCount() {
        return totalDealCount;
    }

    public void setTotalDealCount(BigDecimal totalDealCount) {
        this.totalDealCount = totalDealCount;
    }

    public BigDecimal getTransferCount() {
        return transferCount;
    }

    public void setTransferCount(BigDecimal transferCount) {
        this.transferCount = transferCount;
    }

    public BigDecimal getFinanceCount() {
        return financeCount;
    }

    public void setFinanceCount(BigDecimal financeCount) {
        this.financeCount = financeCount;
    }

    public BigDecimal getTotaltfCount() {
        return totaltfCount;
    }

    public void setTotaltfCount(BigDecimal totaltfCount) {
        this.totaltfCount = totaltfCount;
    }

    public BigDecimal getTargetProfit() {
        return targetProfit;
    }

    public void setTargetProfit(BigDecimal targetProfit) {
        this.targetProfit = targetProfit;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getBbsPhoto() {
        return bbsPhoto;
    }

    public void setBbsPhoto(String bbsPhoto) {
        this.bbsPhoto = bbsPhoto;
    }

    public Integer getGrId() {
        return grId;
    }

    public void setGrId(Integer grId) {
        this.grId = grId;
    }

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    public Integer getHouseArchiveId() {
        return houseArchiveId;
    }

    public void setHouseArchiveId(Integer houseArchiveId) {
        this.houseArchiveId = houseArchiveId;
    }

    public Integer getCustArchiveId() {
        return custArchiveId;
    }

    public void setCustArchiveId(Integer custArchiveId) {
        this.custArchiveId = custArchiveId;
    }

    public Integer getSignArchiveId() {
        return signArchiveId;
    }

    public void setSignArchiveId(Integer signArchiveId) {
        this.signArchiveId = signArchiveId;
    }

    public Integer getDealArchiveId() {
        return dealArchiveId;
    }

    public void setDealArchiveId(Integer dealArchiveId) {
        this.dealArchiveId = dealArchiveId;
    }

    public Integer getSignManagerArchiveId() {
        return signManagerArchiveId;
    }

    public void setSignManagerArchiveId(Integer signManagerArchiveId) {
        this.signManagerArchiveId = signManagerArchiveId;
    }

    public String getDealUserPhoto() {
        return dealUserPhoto;
    }

    public void setDealUserPhoto(String dealUserPhoto) {
        this.dealUserPhoto = dealUserPhoto;
    }

    public Integer getAttr() {
        return attr;
    }

    public void setAttr(Integer attr) {
        this.attr = attr;
    }

    public Integer getRepeatDealId() {
        return repeatDealId;
    }

    public void setRepeatDealId(Integer repeatDealId) {
        this.repeatDealId = repeatDealId;
    }

    public Integer getStepNum() {
        return stepNum;
    }

    public void setStepNum(Integer stepNum) {
        this.stepNum = stepNum;
    }

    public Byte getHousePriceUnit() {
        return housePriceUnit;
    }

    public void setHousePriceUnit(Byte housePriceUnit) {
        this.housePriceUnit = housePriceUnit;
    }


    public String getContractUrl() {
        return contractUrl;
    }

    public void setContractUrl(String contractUrl) {
        this.contractUrl = contractUrl;
    }

    public String getThirdcompName() {
        return thirdcompName;
    }

    public void setThirdcompName(String thirdcompName) {
        this.thirdcompName = thirdcompName;
    }

    public String getThirdaddress() {
        return thirdaddress;
    }

    public void setThirdaddress(String thirdaddress) {
        this.thirdaddress = thirdaddress;
    }

    public String getThirdcompPhoneNum() {
        return thirdcompPhoneNum;
    }

    public void setThirdcompPhoneNum(String thirdcompPhoneNum) {
        this.thirdcompPhoneNum = thirdcompPhoneNum;
    }

    public String getAppletQrcode() {
        return appletQrcode;
    }

    public void setAppletQrcode(String appletQrcode) {
        this.appletQrcode = appletQrcode;
    }

    public Byte getSignType() {
        return signType;
    }

    public void setSignType(Byte signType) {
        this.signType = signType;
    }

    public List<String> getInvalidContracts() {
        return invalidContracts;
    }

    public void setInvalidContracts(List<String> invalidContracts) {
        this.invalidContracts = invalidContracts;
    }

	public Byte getShowOnlineSign() {
		return showOnlineSign;
	}

	public void setShowOnlineSign(Byte showOnlineSign) {
		this.showOnlineSign = showOnlineSign;
	}

    public Integer getDealUserOrgId() {
        return dealUserOrgId;
    }

    public void setDealUserOrgId(Integer dealUserOrgId) {
        this.dealUserOrgId = dealUserOrgId;
    }
}