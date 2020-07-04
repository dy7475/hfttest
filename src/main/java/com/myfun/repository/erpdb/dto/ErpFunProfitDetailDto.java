package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpFunProfitDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(description = "业绩发放")
public class ErpFunProfitDetailDto  implements Serializable {
    @ApiModelProperty("合同编号")
    private String contractNo;
    @ApiModelProperty("是否是手动录入业绩 1=是")
    private String isbyhand;
    @ApiModelProperty("合同类型")
    private Byte dealType;
    @ApiModelProperty("出售地址")
    private String sellAddress;
    @ApiModelProperty("合同核实时间")
    private Date dealVerifyTime;
    @ApiModelProperty("1=签约业绩 2=签约业绩 3=实收业绩 4=实收业绩 5=结算业绩")
    private String payrollSettlementType;


    /**
     * @mbggenerated 主键
     */
    @ApiModelProperty("主键")
    private Integer id;
    /**
     * @mbggenerated 合同ID
     */
    @ApiModelProperty("合同ID")
    private Integer dealId;
    /**
     * @mbggenerated 公司ID
     */
    @ApiModelProperty("公司ID")
    private Integer compId;
    /**
     * @mbggenerated 大区ID
     */
    @ApiModelProperty("大区ID")
    private Integer areaId;
    /**
     * @mbggenerated 片区
     */
    @ApiModelProperty("片区")
    private Integer regId;
    /**
     * @mbggenerated 门店
     */
    @ApiModelProperty("门店")
    private Integer deptId;
    /**
     * @mbggenerated 分组
     */
    @ApiModelProperty("分组")
    private Integer grId;
    /**
     * @mbggenerated 签约月（根据结算日来的自然月）
     */
    @ApiModelProperty("签约月(根据结算日来的自然月)")
    private String signMonth;
    /**
     * @mbggenerated 实收月
     */
    @ApiModelProperty("实收月")
    private String incomeMonth;
    /**
     * @mbggenerated 结算月
     */
    @ApiModelProperty("结算月")
    private String settlementMonth;
    /**
     * @mbggenerated 计划分配金额
     */
    @ApiModelProperty("计划分配金额")
    private BigDecimal plannedDistribution;
    /**
     * @mbggenerated 计划分配比例
     */
    @ApiModelProperty("计划分配比例")
    private BigDecimal distributionPercent;
    /**
     * @mbggenerated 本次实收金额
     */
    @ApiModelProperty("本次实收金额")
    private BigDecimal incomeAmount;
    /**
     * @mbggenerated 实收业绩
     */
    @ApiModelProperty("实收业绩")
    private BigDecimal performanceAmount;
    /**
     * @mbggenerated 提成金额  本笔流水产生的金额（用于直接去薪资表扣除）
     */
    @ApiModelProperty("提成金额")
    private BigDecimal dividedAmount;
    /**
     * @mbggenerated 是否发放 0：未发薪资  1：已发薪资 
     */
    @ApiModelProperty("是否发放 0=未发薪资  1=已发薪资 ")
    private Byte grantFlag;
    /**
     * @mbggenerated 业绩所属人
     */
    @ApiModelProperty("业绩所属人")
    private Integer userId;
    /**
     * @mbggenerated 业绩类别ID（二手房佣金，金融业绩，新房业绩...）
     */
    @ApiModelProperty("业绩类别ID")
    private Integer performanceId;
    /**
     * @mbggenerated 业绩类型名字
     */
    @ApiModelProperty("业绩类型名字")
    private String performanceName;
    /**
     * @mbggenerated 实收时间
     */
    @ApiModelProperty("实收时间")
    private Date incomeTime;
    /**
     * @mbggenerated 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * @mbggenerated 财务款项ID
     */
    @ApiModelProperty("财务款项ID")
    private Integer pfId;
    /**
     * @mbggenerated 应收金额
     */
    @ApiModelProperty("应收金额")
    private BigDecimal needIncomeAmount;
    /**
     * @mbggenerated 0=正常 1=删除  反审核就作废掉
     */
    @ApiModelProperty("0=正常 1=删除 ")
    private Byte delFlag;
    /**
     * @mbggenerated 是否是异常 0正常  1：异常
     */
    @ApiModelProperty("是否是异常 0=正常  1=异常")
    private Byte isAbnormal;
    /**
     * @mbggenerated 能查询异常的月份，，，理论上是当前月的下个周期月
     */
    @ApiModelProperty("能查询异常的月份")
    private String abnormalMonth;
    /**
     * @mbggenerated 0 未计入薪资 1：已计入薪资
     */
    @ApiModelProperty("0=未计入薪资 1=已计入薪资")
    private Byte isCalculate;
    /**
     * @mbggenerated 删除时间
     */
    @ApiModelProperty("删除时间")
    private Date delData;
    /**
     * @mbggenerated 业绩统计月份
     */
    @ApiModelProperty("业绩统计月份")
    private String assessmentMonth;
    /**
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @mbggenerated
     */
    public Integer getDealId() {
        return dealId;
    }

    /**
     * @mbggenerated
     */
    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    /**
     * @mbggenerated
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     * @mbggenerated
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     * @mbggenerated
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * @mbggenerated
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * @mbggenerated
     */
    public Integer getRegId() {
        return regId;
    }

    /**
     * @mbggenerated
     */
    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    /**
     * @mbggenerated
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * @mbggenerated
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * @mbggenerated
     */
    public Integer getGrId() {
        return grId;
    }

    /**
     * @mbggenerated
     */
    public void setGrId(Integer grId) {
        this.grId = grId;
    }

    /**
     * @mbggenerated
     */
    public String getSignMonth() {
        return signMonth;
    }

    /**
     * @mbggenerated
     */
    public void setSignMonth(String signMonth) {
        this.signMonth = signMonth == null ? null : signMonth.trim();
    }

    /**
     * @mbggenerated
     */
    public String getIncomeMonth() {
        return incomeMonth;
    }

    /**
     * @mbggenerated
     */
    public void setIncomeMonth(String incomeMonth) {
        this.incomeMonth = incomeMonth == null ? null : incomeMonth.trim();
    }

    /**
     * @mbggenerated
     */
    public String getSettlementMonth() {
        return settlementMonth;
    }

    /**
     * @mbggenerated
     */
    public void setSettlementMonth(String settlementMonth) {
        this.settlementMonth = settlementMonth == null ? null : settlementMonth.trim();
    }

    /**
     * @mbggenerated
     */
    public BigDecimal getPlannedDistribution() {
        return plannedDistribution;
    }

    /**
     * @mbggenerated
     */
    public void setPlannedDistribution(BigDecimal plannedDistribution) {
        this.plannedDistribution = plannedDistribution;
    }

    /**
     * @mbggenerated
     */
    public BigDecimal getDistributionPercent() {
        return distributionPercent;
    }

    /**
     * @mbggenerated
     */
    public void setDistributionPercent(BigDecimal distributionPercent) {
        this.distributionPercent = distributionPercent;
    }

    /**
     * @mbggenerated
     */
    public BigDecimal getIncomeAmount() {
        return incomeAmount;
    }

    /**
     * @mbggenerated
     */
    public void setIncomeAmount(BigDecimal incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    /**
     * @mbggenerated
     */
    public BigDecimal getPerformanceAmount() {
        return performanceAmount;
    }

    /**
     * @mbggenerated
     */
    public void setPerformanceAmount(BigDecimal performanceAmount) {
        this.performanceAmount = performanceAmount;
    }

    /**
     * @mbggenerated
     */
    public BigDecimal getDividedAmount() {
        return dividedAmount;
    }

    /**
     * @mbggenerated
     */
    public void setDividedAmount(BigDecimal dividedAmount) {
        this.dividedAmount = dividedAmount;
    }

    /**
     * @mbggenerated
     */
    public Byte getGrantFlag() {
        return grantFlag;
    }

    /**
     * @mbggenerated
     */
    public void setGrantFlag(Byte grantFlag) {
        this.grantFlag = grantFlag;
    }

    /**
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @mbggenerated
     */
    public Integer getPerformanceId() {
        return performanceId;
    }

    /**
     * @mbggenerated
     */
    public void setPerformanceId(Integer performanceId) {
        this.performanceId = performanceId;
    }

    /**
     * @mbggenerated
     */
    public String getPerformanceName() {
        return performanceName;
    }

    /**
     * @mbggenerated
     */
    public void setPerformanceName(String performanceName) {
        this.performanceName = performanceName == null ? null : performanceName.trim();
    }

    /**
     * @mbggenerated
     */
    public Date getIncomeTime() {
        return incomeTime;
    }

    /**
     * @mbggenerated
     */
    public void setIncomeTime(Date incomeTime) {
        this.incomeTime = incomeTime;
    }

    /**
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @mbggenerated
     */
    public Integer getPfId() {
        return pfId;
    }

    /**
     * @mbggenerated
     */
    public void setPfId(Integer pfId) {
        this.pfId = pfId;
    }

    /**
     * @mbggenerated
     */
    public BigDecimal getNeedIncomeAmount() {
        return needIncomeAmount;
    }

    /**
     * @mbggenerated
     */
    public void setNeedIncomeAmount(BigDecimal needIncomeAmount) {
        this.needIncomeAmount = needIncomeAmount;
    }

    /**
     * @mbggenerated
     */
    public Byte getDelFlag() {
        return delFlag;
    }

    /**
     * @mbggenerated
     */
    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * @mbggenerated
     */
    public Byte getIsAbnormal() {
        return isAbnormal;
    }

    /**
     * @mbggenerated
     */
    public void setIsAbnormal(Byte isAbnormal) {
        this.isAbnormal = isAbnormal;
    }

    /**
     * @mbggenerated
     */
    public String getAbnormalMonth() {
        return abnormalMonth;
    }

    /**
     * @mbggenerated
     */
    public void setAbnormalMonth(String abnormalMonth) {
        this.abnormalMonth = abnormalMonth == null ? null : abnormalMonth.trim();
    }

    /**
     * @mbggenerated
     */
    public Byte getIsCalculate() {
        return isCalculate;
    }

    /**
     * @mbggenerated
     */
    public void setIsCalculate(Byte isCalculate) {
        this.isCalculate = isCalculate;
    }

    /**
     * @mbggenerated
     */
    public Date getDelData() {
        return delData;
    }

    
    public void setDelData(Date delData) {
        this.delData = delData;
    }

    
    public String getAssessmentMonth() {
        return assessmentMonth;
    }

    /**
     * @mbggenerated
     */
    public void setAssessmentMonth(String assessmentMonth) {
        this.assessmentMonth = assessmentMonth == null ? null : assessmentMonth.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
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

    public String getPayrollSettlementType() {
        return payrollSettlementType;
    }

    public void setPayrollSettlementType(String payrollSettlementType) {
        this.payrollSettlementType = payrollSettlementType;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getIsbyhand() {
        return isbyhand;
    }

    public void setIsbyhand(String isbyhand) {
        this.isbyhand = isbyhand;
    }
}
