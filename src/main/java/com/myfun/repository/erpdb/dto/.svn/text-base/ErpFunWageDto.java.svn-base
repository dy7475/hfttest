package com.myfun.repository.erpdb.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpFunWageDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @ApiModelProperty("门店名称")
	private String deptName;
	@ApiModelProperty("用户角色ID")
	private String userPostion;
	@ApiModelProperty("职级ID")
	private Integer roleLevelId;
	@ApiModelProperty("职级名称")
	private String roleLevelName;
	@ApiModelProperty("奖金")
	private BigDecimal rewardAmount;
	@ApiModelProperty("罚款")
	private BigDecimal punishmentAmount;
	@ApiModelProperty("代缴代扣")
	private BigDecimal generationAmount;
	@ApiModelProperty(hidden = true)
	private Integer abormalFlag = 0;
	@ApiModelProperty("薪资人姓名")
	private String userName;
	@ApiModelProperty(value = "本月完成业绩数",hidden = true)
	private BigDecimal profitCount = new BigDecimal("0.00");//本月完成业绩数
	@ApiModelProperty(value = "本月发放业绩数",hidden = true)
	private Integer setProfitCount = 0;//本月发放业绩数
	@ApiModelProperty(value = "本月发放业绩金额",hidden = true)
	private Integer setProfitWage = 0;//本月发放业绩金额
	@ApiModelProperty(value = "本月以前完成但是未发放业绩数",hidden = true)
	private Integer hisProfitCount = 0;//本月以前完成但是未发放业绩数
	@ApiModelProperty(value = "本月以前完成但是未发放业金额",hidden = true)
	private Integer hisProfitWage = 0;//本月以前完成但是未发放业金额
	@ApiModelProperty(value = "业绩目标",hidden = true)
	private BigDecimal profitTarget = new BigDecimal("0.00");
	@ApiModelProperty("是否有日志 0=无 1=有")
	private Integer isHaveWageLog = 0;
	@ApiModelProperty("增加金额")
	private BigDecimal addWage;
	@ApiModelProperty("减少金额")
	private BigDecimal reduceWage;

	@ApiModelProperty(value = "工资ID")
	private Integer wageId;

	@ApiModelProperty(value = "公司ID")
	private Integer compId;

	@ApiModelProperty(value = "分店ID")
	private Integer deptId;

	@ApiModelProperty(value = "业绩收入    01-24修改为个人的业绩收入")
	private BigDecimal profitWage;

	@ApiModelProperty(value = "工资  基本工资")
	private BigDecimal wageMoney;

	@ApiModelProperty(value = "提成")
	private BigDecimal otherWage;

	@ApiModelProperty(value = "扣发(有权限的人才能操作)")
	private BigDecimal delWage;

	@ApiModelProperty(value = "实际收入,最终的没有调整的就是计算出来的，如果有调整就是调整后的")
	private BigDecimal realWage;

	@ApiModelProperty(value = "工资的审核状态 0未审核 1：已审核")
	private Byte checkStatus;

	@ApiModelProperty(value = "审核人")
	private Integer checkUser;

	@ApiModelProperty(value = "经纪人")
	private Integer userId;

	@ApiModelProperty(value = "创建时间")
	private String createDate;

	@ApiModelProperty(value = "审核时间")
	private Date checkTime;

	@ApiModelProperty(value = "月份")
	private String assessmentMonth;

	@ApiModelProperty(value = "基本薪资发放状态 0=未发 1=已发")
	private Byte baseWageGrantStatus;

	@ApiModelProperty(value = "业绩提成发放状态0未发 1：已发")
	private Byte commissionGrantStatus;
	
	@ApiModelProperty(value = "个人工作量 金额")
	private BigDecimal personWorkcountAmount;

	@ApiModelProperty(value = "管理工作量金额")
	private BigDecimal manageWorkcountAmount;
	
	@ApiModelProperty(value = "管理的业绩考核金额")
	private BigDecimal manageProfitWage;

	@ApiModelProperty(value = "个人的绩效考核")
	private BigDecimal personProfitWage;

	@ApiModelProperty(value = "已发薪资")
	private BigDecimal paidWageAmount;

	@ApiModelProperty(value = "个人提成")
	private BigDecimal personCommsionAmount;

	@ApiModelProperty(value = "管理提成")
	private BigDecimal manageCommsionAmount;

	@ApiModelProperty(value = "应发参考值，这个是后台任务计算出来的值")
	private BigDecimal realWageCk;

	@ApiModelProperty(value = "说明")
	private String explain;

	@ApiModelProperty(value = "调整工资(其它工资)")
	private BigDecimal adjustWage;
	@ApiModelProperty(value = "方案名称")
	private BigDecimal salaryTypeName;
	@ApiModelProperty(value = "薪资类型名称")
	private BigDecimal salaryProfit;
	@ApiModelProperty(value = "房源新增")
	private Integer houseAssessmentCount;
	@ApiModelProperty(value = "客源新增")
	private Integer custAssessmentCount;
	@ApiModelProperty(value = "带看统计")
	private Integer daikanAssessmentCount;
	@ApiModelProperty(value = "房堪统计")
	private Integer fankanAssessmentCount;
	@ApiModelProperty(value = "业绩金额")
	private BigDecimal profitMoney;
	@ApiModelProperty(value = "考核薪资，基本工资")
	private BigDecimal salaryMoney;
	@ApiModelProperty(value = "任务考核金额，完成可领取")
	private BigDecimal taskMoney;
	@ApiModelProperty(value = "每条房源新增价格")
	private BigDecimal perHouseMoney;
	@ApiModelProperty(value = "每条客源新增价格")
	private BigDecimal perCustMoney;
	@ApiModelProperty(value = "每条带看价格")
	private BigDecimal perDaikanMoney;
	@ApiModelProperty(value = "每条房堪价格")
	private BigDecimal perFankanMoney;
	@ApiModelProperty(value = "房源新增数量")
	private Integer houseAddCount;
	@ApiModelProperty(value = "客源新增数量")
	private Integer custAddCount;
	@ApiModelProperty(value = "房堪数量")
	private Integer fankanCount;
	@ApiModelProperty(value = "带看数量")
	private Integer daikanCount;
	@ApiModelProperty(value = "直接提成")
	private BigDecimal directCommission;
	@ApiModelProperty(value = "间接提成")
	private BigDecimal inDirectCommission;

	
	public BigDecimal getDirectCommission() {
		return directCommission;
	}

	public void setDirectCommission(BigDecimal directCommission) {
		this.directCommission = directCommission;
	}

	public BigDecimal getInDirectCommission() {
		return inDirectCommission;
	}

	public void setInDirectCommission(BigDecimal inDirectCommission) {
		this.inDirectCommission = inDirectCommission;
	}

	public BigDecimal getSalaryMoney() {
		return salaryMoney;
	}

	public void setSalaryMoney(BigDecimal salaryMoney) {
		this.salaryMoney = salaryMoney;
	}

	public BigDecimal getTaskMoney() {
		return taskMoney;
	}

	public void setTaskMoney(BigDecimal taskMoney) {
		this.taskMoney = taskMoney;
	}

	public BigDecimal getPerHouseMoney() {
		return perHouseMoney;
	}

	public void setPerHouseMoney(BigDecimal perHouseMoney) {
		this.perHouseMoney = perHouseMoney;
	}

	public BigDecimal getPerCustMoney() {
		return perCustMoney;
	}

	public void setPerCustMoney(BigDecimal perCustMoney) {
		this.perCustMoney = perCustMoney;
	}

	public BigDecimal getPerDaikanMoney() {
		return perDaikanMoney;
	}

	public void setPerDaikanMoney(BigDecimal perDaikanMoney) {
		this.perDaikanMoney = perDaikanMoney;
	}

	public BigDecimal getPerFankanMoney() {
		return perFankanMoney;
	}

	public void setPerFankanMoney(BigDecimal perFankanMoney) {
		this.perFankanMoney = perFankanMoney;
	}

	public Integer getHouseAddCount() {
		return houseAddCount;
	}

	public void setHouseAddCount(Integer houseAddCount) {
		this.houseAddCount = houseAddCount;
	}

	public Integer getCustAddCount() {
		return custAddCount;
	}

	public void setCustAddCount(Integer custAddCount) {
		this.custAddCount = custAddCount;
	}

	public Integer getFankanCount() {
		return fankanCount;
	}

	public void setFankanCount(Integer fankanCount) {
		this.fankanCount = fankanCount;
	}

	public Integer getDaikanCount() {
		return daikanCount;
	}

	public void setDaikanCount(Integer daikanCount) {
		this.daikanCount = daikanCount;
	}

	public Integer getWageId() {
		return wageId;
	}
	
	public void setWageId(Integer wageId) {
		this.wageId = wageId;
	}
	
	public Integer getCompId() {
		return compId;
	}
	
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	
	public Integer getDeptId() {
		return deptId;
	}
	
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public BigDecimal getProfitWage() {
		return profitWage;
	}
	
	public void setProfitWage(BigDecimal profitWage) {
		this.profitWage = profitWage;
	}
	
	public BigDecimal getWageMoney() {
		return wageMoney;
	}
	
	public void setWageMoney(BigDecimal wageMoney) {
		this.wageMoney = wageMoney;
	}
	
	public BigDecimal getOtherWage() {
		return otherWage;
	}
	
	public void setOtherWage(BigDecimal otherWage) {
		this.otherWage = otherWage;
	}
	
	public BigDecimal getDelWage() {
		return delWage;
	}
	
	public void setDelWage(BigDecimal delWage) {
		this.delWage = delWage;
	}

	public BigDecimal getRealWage() {
		return realWage;
	}
	
	public void setRealWage(BigDecimal realWage) {
		this.realWage = realWage;
	}
	
	public Byte getCheckStatus() {
		return checkStatus;
	}
	
	public void setCheckStatus(Byte checkStatus) {
		this.checkStatus = checkStatus;
	}
	
	public Integer getCheckUser() {
		return checkUser;
	}

	public void setCheckUser(Integer checkUser) {
		this.checkUser = checkUser;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(String createDate) {
		this.createDate = createDate == null ? null : createDate.trim();
	}
	
	public Date getCheckTime() {
		return checkTime;
	}
	
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	

	public String getAssessmentMonth() {
		return assessmentMonth;
	}
	
	public void setAssessmentMonth(String assessmentMonth) {
		this.assessmentMonth = assessmentMonth == null ? null : assessmentMonth.trim();
	}

	
	public Byte getBaseWageGrantStatus() {
		return baseWageGrantStatus;
	}
	
	public void setBaseWageGrantStatus(Byte baseWageGrantStatus) {
		this.baseWageGrantStatus = baseWageGrantStatus;
	}
	
	public Byte getCommissionGrantStatus() {
		return commissionGrantStatus;
	}
	
	public void setCommissionGrantStatus(Byte commissionGrantStatus) {
		this.commissionGrantStatus = commissionGrantStatus;
	}
	
	public BigDecimal getPersonWorkcountAmount() {
		return personWorkcountAmount;
	}
	
	public void setPersonWorkcountAmount(BigDecimal personWorkcountAmount) {
		this.personWorkcountAmount = personWorkcountAmount;
	}
	
	public BigDecimal getManageWorkcountAmount() {
		return manageWorkcountAmount;
	}
	
	public void setManageWorkcountAmount(BigDecimal manageWorkcountAmount) {
		this.manageWorkcountAmount = manageWorkcountAmount;
	}
	
	public BigDecimal getManageProfitWage() {
		return manageProfitWage;
	}
	
	public void setManageProfitWage(BigDecimal manageProfitWage) {
		this.manageProfitWage = manageProfitWage;
	}
	
	public BigDecimal getPersonProfitWage() {
		return personProfitWage;
	}
	
	public void setPersonProfitWage(BigDecimal personProfitWage) {
		this.personProfitWage = personProfitWage;
	}
	
	public BigDecimal getPaidWageAmount() {
		return paidWageAmount;
	}
	
	public void setPaidWageAmount(BigDecimal paidWageAmount) {
		this.paidWageAmount = paidWageAmount;
	}
	
	public BigDecimal getPersonCommsionAmount() {
		return personCommsionAmount;
	}
	
	public void setPersonCommsionAmount(BigDecimal personCommsionAmount) {
		this.personCommsionAmount = personCommsionAmount;
	}
	
	public BigDecimal getManageCommsionAmount() {
		return manageCommsionAmount;
	}
	
	public void setManageCommsionAmount(BigDecimal manageCommsionAmount) {
		this.manageCommsionAmount = manageCommsionAmount;
	}
	
	public BigDecimal getRealWageCk() {
		return realWageCk;
	}
	
	public void setRealWageCk(BigDecimal realWageCk) {
		this.realWageCk = realWageCk;
	}
	
	public String getExplain() {
		return explain;
	}
	
	public void setExplain(String explain) {
		this.explain = explain == null ? null : explain.trim();
	}
	

	public BigDecimal getAdjustWage() {
		return adjustWage;
	}

	public void setAdjustWage(BigDecimal adjustWage) {
		this.adjustWage = adjustWage;
	}


	public Integer getIsHaveWageLog() {
		return isHaveWageLog;
	}

	public void setIsHaveWageLog(Integer isHaveWageLog) {
		this.isHaveWageLog = isHaveWageLog;
	}

	public BigDecimal getAddWage() {
		return addWage;
	}

	public void setAddWage(BigDecimal addWage) {
		this.addWage = addWage;
	}

	public BigDecimal getReduceWage() {
		return reduceWage;
	}

	public void setReduceWage(BigDecimal reduceWage) {
		this.reduceWage = reduceWage;
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BigDecimal getProfitCount() {
		return profitCount;
	}

	public void setProfitCount(BigDecimal profitCount) {
		this.profitCount = profitCount;
	}

	public Integer getSetProfitCount() {
		return setProfitCount;
	}

	public void setSetProfitCount(Integer setProfitCount) {
		this.setProfitCount = setProfitCount;
	}

	public Integer getSetProfitWage() {
		return setProfitWage;
	}

	public void setSetProfitWage(Integer setProfitWage) {
		this.setProfitWage = setProfitWage;
	}

	public Integer getHisProfitCount() {
		return hisProfitCount;
	}

	public void setHisProfitCount(Integer hisProfitCount) {
		this.hisProfitCount = hisProfitCount;
	}

	public Integer getHisProfitWage() {
		return hisProfitWage;
	}

	public void setHisProfitWage(Integer hisProfitWage) {
		this.hisProfitWage = hisProfitWage;
	}

	public BigDecimal getProfitTarget() {
		return profitTarget;
	}

	public void setProfitTarget(BigDecimal profitTarget) {
		this.profitTarget = profitTarget;
	}

	public Integer getAbormalFlag() {
		return abormalFlag;
	}

	public void setAbormalFlag(Integer abormalFlag) {
		this.abormalFlag = abormalFlag;
	}

	public BigDecimal getGenerationAmount() {
		return generationAmount;
	}

	public void setGenerationAmount(BigDecimal generationAmount) {
		this.generationAmount = generationAmount;
	}

	public BigDecimal getRewardAmount() {
		return rewardAmount;
	}

	public void setRewardAmount(BigDecimal rewardAmount) {
		this.rewardAmount = rewardAmount;
	}

	public BigDecimal getPunishmentAmount() {
		return punishmentAmount;
	}

	public void setPunishmentAmount(BigDecimal punishmentAmount) {
		this.punishmentAmount = punishmentAmount;
	}

	public String getUserPostion() {
		return userPostion;
	}

	public void setUserPostion(String userPostion) {
		this.userPostion = userPostion;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public BigDecimal getSalaryTypeName() {
		return salaryTypeName;
	}

	public void setSalaryTypeName(BigDecimal salaryTypeName) {
		this.salaryTypeName = salaryTypeName;
	}

	public BigDecimal getSalaryProfit() {
		return salaryProfit;
	}

	public void setSalaryProfit(BigDecimal salaryProfit) {
		this.salaryProfit = salaryProfit;
	}

	public Integer getHouseAssessmentCount() {
		return houseAssessmentCount;
	}

	public void setHouseAssessmentCount(Integer houseAssessmentCount) {
		this.houseAssessmentCount = houseAssessmentCount;
	}

	public Integer getCustAssessmentCount() {
		return custAssessmentCount;
	}

	public void setCustAssessmentCount(Integer custAssessmentCount) {
		this.custAssessmentCount = custAssessmentCount;
	}

	public Integer getDaikanAssessmentCount() {
		return daikanAssessmentCount;
	}

	public void setDaikanAssessmentCount(Integer daikanAssessmentCount) {
		this.daikanAssessmentCount = daikanAssessmentCount;
	}

	public Integer getFankanAssessmentCount() {
		return fankanAssessmentCount;
	}

	public void setFankanAssessmentCount(Integer fankanAssessmentCount) {
		this.fankanAssessmentCount = fankanAssessmentCount;
	}

	public BigDecimal getProfitMoney() {
		return profitMoney;
	}

	public void setProfitMoney(BigDecimal profitMoney) {
		this.profitMoney = profitMoney;
	}

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

	public Integer getRoleLevelId() {
		return roleLevelId;
	}

	public void setRoleLevelId(Integer roleLevelId) {
		this.roleLevelId = roleLevelId;
	}

	public String getRoleLevelName() {
		return roleLevelName;
	}

	public void setRoleLevelName(String roleLevelName) {
		this.roleLevelName = roleLevelName;
	}
}
