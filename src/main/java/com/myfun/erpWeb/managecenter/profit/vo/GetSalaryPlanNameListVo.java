package com.myfun.erpWeb.managecenter.profit.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(description = "获取薪资提成方案名称列表VO")
public class GetSalaryPlanNameListVo  implements Serializable {
    /**
     * @mbggenerated 主键ID
     */
    @ApiModelProperty("主键ID")
    private Integer id;
    /**
     * @mbggenerated 原有的提成方案id
     */
    @ApiModelProperty("原有的提成方案id")
    private Integer wagetypeId;
    /**
     * @mbggenerated 公司ID
     */
    @ApiModelProperty("公司ID")
    private Integer compId;
    /**
     * @mbggenerated 门店Id
     */
    @ApiModelProperty("门店Id")
    private Integer deptId;
    /**
     * @mbggenerated 新增方案名称
     */
    @ApiModelProperty("新增方案名称")
    private String wageTypeName;
    /**
     * @mbggenerated 编号
     */
    @ApiModelProperty("编号")
    private Byte seq;
    /**
     * @mbggenerated 创建时间
     */
    @ApiModelProperty("创建时间")
    private String createDate;
    /**
     * @mbggenerated 薪资的计算方式 1.阶梯计算 2.通提计算
     */
    @ApiModelProperty("薪资的计算方式 1.阶梯计算 2.通提计算")
    private Byte wageCountType;
    /**
     * @mbggenerated 业绩类别，0=总业绩 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融
     */
    @ApiModelProperty("业绩类别，0=总业绩 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融")
    private Byte performanceType;
    /**
     * @mbggenerated 提成范围，0=个人 1=分组 2=门店 3=片区 4=大区 5=公司
     */
    @ApiModelProperty("提成范围，0=个人 1=分组 2=门店 3=片区 4=大区 5=公司")
    private Byte royaltyRange;
    /**
     * @mbggenerated 业绩范围，0=人均 1店均 2总业绩
     */
    @ApiModelProperty("业绩范围，0=人均 1店均 2总业绩")
    private Byte profitRange;
    /**
     * @mbggenerated 保底比例，当前提成方式等于通提的时候
     */
    @ApiModelProperty("保底比例，当前提成方式等于通提的时候")
    private BigDecimal baseProportion;
    /**
     * @mbggenerated 提成方案说明
     */
    @ApiModelProperty("提成方案说明")
    private String wageTypeDesc;
    /**
     * @mbggenerated 提成类型 0=业务1=管理
     */
    @ApiModelProperty("提成类型 0=业务1=管理")
    private Byte managePlan;
    /**
     * @mbggenerated 结算月  用于自然月
     */
    @ApiModelProperty("结算月  用于自然月")
    private String assessmentMonth;
    /**
     * @mbggenerated 是否在用 1：再用 0 表示往月的配置
     */
    @ApiModelProperty("是否在用 1：再用 0 表示往月的配置")
    private Byte isCheck;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWagetypeId() {
        return wagetypeId;
    }

    public void setWagetypeId(Integer wagetypeId) {
        this.wagetypeId = wagetypeId;
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

    public String getWageTypeName() {
        return wageTypeName;
    }

    public void setWageTypeName(String wageTypeName) {
        this.wageTypeName = wageTypeName;
    }

    public Byte getSeq() {
        return seq;
    }

    public void setSeq(Byte seq) {
        this.seq = seq;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Byte getWageCountType() {
        return wageCountType;
    }

    public void setWageCountType(Byte wageCountType) {
        this.wageCountType = wageCountType;
    }

    public Byte getPerformanceType() {
        return performanceType;
    }

    public void setPerformanceType(Byte performanceType) {
        this.performanceType = performanceType;
    }

    public Byte getRoyaltyRange() {
        return royaltyRange;
    }

    public void setRoyaltyRange(Byte royaltyRange) {
        this.royaltyRange = royaltyRange;
    }

    public Byte getProfitRange() {
        return profitRange;
    }

    public void setProfitRange(Byte profitRange) {
        this.profitRange = profitRange;
    }

    public BigDecimal getBaseProportion() {
        return baseProportion;
    }

    public void setBaseProportion(BigDecimal baseProportion) {
        this.baseProportion = baseProportion;
    }

    public String getWageTypeDesc() {
        return wageTypeDesc;
    }

    public void setWageTypeDesc(String wageTypeDesc) {
        this.wageTypeDesc = wageTypeDesc;
    }

    public Byte getManagePlan() {
        return managePlan;
    }

    public void setManagePlan(Byte managePlan) {
        this.managePlan = managePlan;
    }

    public String getAssessmentMonth() {
        return assessmentMonth;
    }

    public void setAssessmentMonth(String assessmentMonth) {
        this.assessmentMonth = assessmentMonth;
    }

    public Byte getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Byte isCheck) {
        this.isCheck = isCheck;
    }
}
