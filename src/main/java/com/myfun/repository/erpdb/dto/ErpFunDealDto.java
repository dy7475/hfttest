package com.myfun.repository.erpdb.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.myfun.erpWeb.managecenter.transaction.vo.HouseBriefInfoVO;
import com.myfun.erpWeb.managecenter.transaction.vo.RuntimeStepVO;
import com.myfun.repository.erpdb.po.ErpFunDeal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpFunDealDto extends ErpFunDeal{
	private static final long serialVersionUID = 1L;
	
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
	
	@ApiModelProperty(value = "签约人头像")
    private String signUserPhoto;
	
	@ApiModelProperty(value = "业主实收")
	private BigDecimal ownerActualReceiptCapital;
	
	@ApiModelProperty(value = "业主应收")
	private BigDecimal ownerReceivable;
	
	@ApiModelProperty(value = "客户实收")
	private BigDecimal custActualReceiptCapital;
	
	@ApiModelProperty(value = "客户应收")
	private BigDecimal custReceivable;
	
	@ApiModelProperty(value = "房源信息")
	private HouseBriefInfoVO houseInfo;
	
	@ApiModelProperty(value = "宽列表权证流程列表")
	private List<RuntimeStepVO> runtimeStepVOList;
	
	
	 
    @ApiModelProperty(value = "介绍姓名")
    private String introducerName; 
    @ApiModelProperty(value = "介绍人电话")
    private String introducerPhone;
    @ApiModelProperty(value = "促成人姓名")
    private String adultPromotionName; 
    @ApiModelProperty(value = "促成人电话")
    private String adultPromotionPhone; 
   
    @ApiModelProperty(value = "签约地点-门店名称")
    private String signSiteDeptName; 
    @ApiModelProperty(value = "签约地点-分组名称")
    private String signSiteGrName;
	
	@ApiModelProperty(value = "楼盘推广名 美联用")
	private String promotionName;

	
	public String getPromotionName() {
		return promotionName;
	}
	
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	
	public String getSignSiteDeptName() {
		return signSiteDeptName;
	}

	public void setSignSiteDeptName(String signSiteDeptName) {
		this.signSiteDeptName = signSiteDeptName;
	}

	public String getSignSiteGrName() {
		return signSiteGrName;
	}

	public void setSignSiteGrName(String signSiteGrName) {
		this.signSiteGrName = signSiteGrName;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Byte getHousePriceUnit() {
		return housePriceUnit;
	}

	public void setHousePriceUnit(Byte housePriceUnit) {
		this.housePriceUnit = housePriceUnit;
	}

	public Integer getSignManagerArchiveId() {
		return signManagerArchiveId;
	}

	public void setSignManagerArchiveId(Integer signManagerArchiveId) {
		this.signManagerArchiveId = signManagerArchiveId;
	}

	public Integer getHouseArchiveId() {
		return houseArchiveId;
	}

	public Integer getDealArchiveId() {
		return dealArchiveId;
	}

	public void setDealArchiveId(Integer dealArchiveId) {
		this.dealArchiveId = dealArchiveId;
	}

	public void setHouseArchiveId(Integer houseArchiveId) {
		this.houseArchiveId = houseArchiveId;
	}

	public Integer getSignArchiveId() {
		return signArchiveId;
	}

	public void setSignArchiveId(Integer signArchiveId) {
		this.signArchiveId = signArchiveId;
	}

	public Integer getCustArchiveId() {
		return custArchiveId;
	}

	public void setCustArchiveId(Integer custArchiveId) {
		this.custArchiveId = custArchiveId;
	}

	public Integer getStepNum() {
		return stepNum;
	}

	public void setStepNum(Integer stepNum) {
		this.stepNum = stepNum;
	}

	public Integer getRepeatDealId() {
		return repeatDealId;
	}

	public void setRepeatDealId(Integer repeatDealId) {
		this.repeatDealId = repeatDealId;
	}

	public Integer getAttr() {
		return attr;
	}

	public void setAttr(Integer attr) {
		this.attr = attr;
	}

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Byte getCollentStatus() {
		return collentStatus;
	}

	public void setCollentStatus(Byte collentStatus) {
		this.collentStatus = collentStatus;
	}

	public BigDecimal getPlannedDistribution() {
		return plannedDistribution;
	}

	public void setPlannedDistribution(BigDecimal plannedDistribution) {
		this.plannedDistribution = plannedDistribution;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public BigDecimal getDistributionPercent() {
		return distributionPercent;
	}

	public void setDistributionPercent(BigDecimal distributionPercent) {
		this.distributionPercent = distributionPercent;
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


	public String getPerformanceName() {
		return performanceName;
	}

	public void setPerformanceName(String performanceName) {
		this.performanceName = performanceName;
	}


	public Integer getPerformanceId() {
		return performanceId;
	}

	public void setPerformanceId(Integer performanceId) {
		this.performanceId = performanceId;
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

	public String getContractIds() {
        return contractIds;
    }

    public void setContractIds(String contractIds) {
        this.contractIds = contractIds;
    }

    public Integer getJrFinanceId() {
        return jrFinanceId;
    }

    public void setJrFinanceId(Integer jrFinanceId) {
        this.jrFinanceId = jrFinanceId;
    }

    public String getSignUserPhone() {
        return signUserPhone;
    }

    public void setSignUserPhone(String signUserPhone) {
        this.signUserPhone = signUserPhone;
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

    public String getHftdealQraddr() {
        return hftdealQraddr;
    }

    public void setHftdealQraddr(String hftdealQraddr) {
        this.hftdealQraddr = hftdealQraddr;
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

	public String getDealUserPhoto() {
		return dealUserPhoto;
	}

	public void setDealUserPhoto(String dealUserPhoto) {
		this.dealUserPhoto = dealUserPhoto;
	}

	public String getSignUserPhoto() {
		return signUserPhoto;
	}

	public void setSignUserPhoto(String signUserPhoto) {
		this.signUserPhoto = signUserPhoto;
	}

	public BigDecimal getOwnerActualReceiptCapital() {
		return ownerActualReceiptCapital;
	}

	public void setOwnerActualReceiptCapital(BigDecimal ownerActualReceiptCapital) {
		this.ownerActualReceiptCapital = ownerActualReceiptCapital;
	}

	public BigDecimal getOwnerReceivable() {
		return ownerReceivable;
	}

	public void setOwnerReceivable(BigDecimal ownerReceivable) {
		this.ownerReceivable = ownerReceivable;
	}

	public BigDecimal getCustActualReceiptCapital() {
		return custActualReceiptCapital;
	}

	public void setCustActualReceiptCapital(BigDecimal custActualReceiptCapital) {
		this.custActualReceiptCapital = custActualReceiptCapital;
	}

	public BigDecimal getCustReceivable() {
		return custReceivable;
	}

	public void setCustReceivable(BigDecimal custReceivable) {
		this.custReceivable = custReceivable;
	}

	public HouseBriefInfoVO getHouseInfo() {
		return houseInfo;
	}

	public void setHouseInfo(HouseBriefInfoVO houseInfo) {
		this.houseInfo = houseInfo;
	}

	public List<RuntimeStepVO> getRuntimeStepVOList() {
		return runtimeStepVOList;
	}

	public void setRuntimeStepVOList(List<RuntimeStepVO> runtimeStepVOList) {
		this.runtimeStepVOList = runtimeStepVOList;
	}
}
