package com.myfun.erpWeb.managecenter.profit.vo;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class PersonShareProfitDetailVO {
		@ApiModelProperty("合同编号")
	    private String contractNo;
		
	    @ApiModelProperty("是否是手动录入业绩 1=是")
	    private String isbyhand;
	    
	    @ApiModelProperty("合同类型")
	    private Byte dealType;
	    
	    @ApiModelProperty("出售地址")
	    private String sellAddress;
	    
	    @ApiModelProperty("合同结算时间")
	    private Date dealVerifyTime;
	    
	    @ApiModelProperty("主键")
	    private Integer id;
	    
	    @ApiModelProperty("合同ID")
	    private Integer dealId;
	    
	    @ApiModelProperty("公司ID")
	    private Integer compId;
	  
	    @ApiModelProperty("大区ID")
	    private Integer areaId;
	    @ApiModelProperty("片区")
	    private Integer regId;
	    @ApiModelProperty("门店")
	    private Integer deptId;
	    @ApiModelProperty("分组")
	    private Integer grId;
	    @ApiModelProperty("签约月(根据结算日来的自然月)")
	    private String signMonth;
	    @ApiModelProperty("签约日期")
	    private String signDate;
	    @ApiModelProperty("实收月")
	    private String incomeMonth;
	    @ApiModelProperty("结算月")
	    private String settlementMonth;
	    @ApiModelProperty("计划分配金额")
	    private BigDecimal plannedDistribution;
	    @ApiModelProperty("计划分配比例")
	    private BigDecimal distributionPercent;
	    @ApiModelProperty("本次实收金额")
	    private BigDecimal incomeAmount;
	    @ApiModelProperty("实收业绩")
	    private BigDecimal performanceAmount;
	    @ApiModelProperty("提成金额")
	    private BigDecimal dividedAmount;
	    @ApiModelProperty("是否发放 0=未发薪资  1=已发薪资 ")
	    private Byte grantFlag;
	    @ApiModelProperty("业绩所属人")
	    private Integer userId;
	    @ApiModelProperty("业绩类别ID")
	    private Integer performanceId;
	    @ApiModelProperty("业绩类型名字")
	    private String performanceName;
	    @ApiModelProperty("实收时间")
	    private Date incomeTime;
	    @ApiModelProperty("创建时间")
	    private Date createTime;
	    @ApiModelProperty("财务款项ID")
	    private Integer pfId;
	    @ApiModelProperty("应收金额")
	    private BigDecimal needIncomeAmount;
	    @ApiModelProperty("0=正常 1=删除 ")
	    private Byte delFlag;
	    @ApiModelProperty("0=未计入薪资 1=已计入薪资")
	    private Byte isCalculate;
	    @ApiModelProperty("删除时间")
	    private Date delData;
	    @ApiModelProperty("业绩统计月份")
	    private String assessmentMonth;
	    @ApiModelProperty(value= "分成人分的业绩")
	    private BigDecimal profitShareProfit;
	    @ApiModelProperty(value= "分成人分的业绩比例")
	    private BigDecimal profitSharePercent;
	    @ApiModelProperty(value= "分成人id")
	    private Integer upLeaderUser;
	    @ApiModelProperty(value= "分成人类型 0=直接leader 1= 直接发展人 2= 间接leader")
	    private Byte upLeaderType;

		public String getContractNo() {
			return contractNo;
		}

		public void setContractNo(String contractNo) {
			this.contractNo = contractNo;
		}

		public String getIsbyhand() {
			return isbyhand;
		}

		public void setIsbyhand(String isbyhand) {
			this.isbyhand = isbyhand;
		}

		public Byte getDealType() {
			return dealType;
		}

		public void setDealType(Byte dealType) {
			this.dealType = dealType;
		}

		public String getSellAddress() {
			return sellAddress;
		}

		public void setSellAddress(String sellAddress) {
			this.sellAddress = sellAddress;
		}

		public Date getDealVerifyTime() {
			return dealVerifyTime;
		}

		public void setDealVerifyTime(Date dealVerifyTime) {
			this.dealVerifyTime = dealVerifyTime;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getDealId() {
			return dealId;
		}

		public void setDealId(Integer dealId) {
			this.dealId = dealId;
		}

		public Integer getCompId() {
			return compId;
		}

		public void setCompId(Integer compId) {
			this.compId = compId;
		}

		public Integer getAreaId() {
			return areaId;
		}

		public void setAreaId(Integer areaId) {
			this.areaId = areaId;
		}

		public Integer getRegId() {
			return regId;
		}

		public void setRegId(Integer regId) {
			this.regId = regId;
		}

		public Integer getDeptId() {
			return deptId;
		}

		public void setDeptId(Integer deptId) {
			this.deptId = deptId;
		}

		public Integer getGrId() {
			return grId;
		}

		public void setGrId(Integer grId) {
			this.grId = grId;
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

		public BigDecimal getPlannedDistribution() {
			return plannedDistribution;
		}

		public void setPlannedDistribution(BigDecimal plannedDistribution) {
			this.plannedDistribution = plannedDistribution;
		}

		public BigDecimal getDistributionPercent() {
			return distributionPercent;
		}

		public void setDistributionPercent(BigDecimal distributionPercent) {
			this.distributionPercent = distributionPercent;
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

		public BigDecimal getDividedAmount() {
			return dividedAmount;
		}

		public void setDividedAmount(BigDecimal dividedAmount) {
			this.dividedAmount = dividedAmount;
		}

		public Byte getGrantFlag() {
			return grantFlag;
		}

		public void setGrantFlag(Byte grantFlag) {
			this.grantFlag = grantFlag;
		}

		public Integer getUserId() {
			return userId;
		}

		public void setUserId(Integer userId) {
			this.userId = userId;
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

		public Date getIncomeTime() {
			return incomeTime;
		}

		public void setIncomeTime(Date incomeTime) {
			this.incomeTime = incomeTime;
		}

		public Date getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}

		public Integer getPfId() {
			return pfId;
		}

		public void setPfId(Integer pfId) {
			this.pfId = pfId;
		}

		public BigDecimal getNeedIncomeAmount() {
			return needIncomeAmount;
		}

		public void setNeedIncomeAmount(BigDecimal needIncomeAmount) {
			this.needIncomeAmount = needIncomeAmount;
		}

		public Byte getDelFlag() {
			return delFlag;
		}

		public void setDelFlag(Byte delFlag) {
			this.delFlag = delFlag;
		}

		public Byte getIsCalculate() {
			return isCalculate;
		}

		public void setIsCalculate(Byte isCalculate) {
			this.isCalculate = isCalculate;
		}

		public Date getDelData() {
			return delData;
		}

		public void setDelData(Date delData) {
			this.delData = delData;
		}

		public String getAssessmentMonth() {
			return assessmentMonth;
		}

		public void setAssessmentMonth(String assessmentMonth) {
			this.assessmentMonth = assessmentMonth;
		}

		public BigDecimal getProfitShareProfit() {
			return profitShareProfit;
		}

		public void setProfitShareProfit(BigDecimal profitShareProfit) {
			this.profitShareProfit = profitShareProfit;
		}

		public BigDecimal getProfitSharePercent() {
			return profitSharePercent;
		}

		public void setProfitSharePercent(BigDecimal profitSharePercent) {
			this.profitSharePercent = profitSharePercent;
		}

		public Integer getUpLeaderUser() {
			return upLeaderUser;
		}

		public void setUpLeaderUser(Integer upLeaderUser) {
			this.upLeaderUser = upLeaderUser;
		}

		public Byte getUpLeaderType() {
			return upLeaderType;
		}

		public void setUpLeaderType(Byte upLeaderType) {
			this.upLeaderType = upLeaderType;
		}

		public String getSignDate() {
			return signDate;
		}

		public void setSignDate(String signDate) {
			this.signDate = signDate;
		}
}
