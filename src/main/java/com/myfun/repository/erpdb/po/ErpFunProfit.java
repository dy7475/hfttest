package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunProfit extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="主键ID，自增") private Integer profitId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="公司ID") private Integer compId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="合同ID") private Integer dealId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="门店ID") private Integer deptId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="员工ID") private Integer userId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="实收分配比例") private BigDecimal profitProportion;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="实收金额") private BigDecimal profitMoney;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="发放时间") private String settleTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="发放标记（0:默认1选中 2= 已发放）") private Integer settleFlag;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="备注") private String remark;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="合同编号") private String agreementNo;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="创建时间") private Date createDate;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="业绩结算时间") private Date dealVerifyTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="合同类型（101出售102出租）") private Byte dealType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="大区ID") private Integer areaId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="片区ID") private Integer regId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="业绩结算类型（0上月结算1本月结算）") private Byte profitDealType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="业绩类别ID") private Integer performanceId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="业绩类别名称") private String performanceName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="分组ID") private Integer grId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="业绩类型 0=个人业绩、1=公司业绩、2=没有业绩所属人的个人业绩、3=已删除的个人业绩") private Byte profitType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="员工档案iD") private Integer archiveId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="角色ID") private String roleId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="角色名称") private String roleName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="职级ID") private Integer levelsId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="职级名称") private String levelsName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="应收金额") private BigDecimal receivableMoney;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="业绩类别 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融 ") private Byte performanceType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="折扣比例，生成业绩的时候，读取财务上的配置") private BigDecimal discount;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="考核月（自然月）") private String assessmentMonth;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="异常状态 0 =正常 1=异常") private Integer validFlag;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="组织综合查询字段 :12001:12002:12003:") private String organizationPath;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="组织ID1") private Integer org1;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="组织ID2") private Integer org2;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="组织ID3") private Integer org3;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="组织ID4") private Integer org4;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="组织ID5") private Integer org5;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="组织ID6") private Integer org6;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="组织ID7") private Integer org7;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="组织ID8") private Integer org8;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="组织ID9") private Integer org9;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="组织ID10") private Integer org10;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="组织ID11") private Integer org11;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="组织ID12") private Integer org12;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="组织ID13") private Integer org13;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="组织ID14") private Integer org14;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键ID，自增
	 */
	public Integer getProfitId() {
		return profitId;
	}

	/**
	 * @mbggenerated 主键ID，自增
	 */
	public void setProfitId(Integer profitId) {
		this.profitId = profitId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 合同ID
	 */
	public Integer getDealId() {
		return dealId;
	}

	/**
	 * @mbggenerated 合同ID
	 */
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	/**
	 * @mbggenerated 门店ID
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 门店ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 员工ID
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 员工ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated 实收分配比例
	 */
	public BigDecimal getProfitProportion() {
		return profitProportion;
	}

	/**
	 * @mbggenerated 实收分配比例
	 */
	public void setProfitProportion(BigDecimal profitProportion) {
		this.profitProportion = profitProportion;
	}

	/**
	 * @mbggenerated 实收金额
	 */
	public BigDecimal getProfitMoney() {
		return profitMoney;
	}

	/**
	 * @mbggenerated 实收金额
	 */
	public void setProfitMoney(BigDecimal profitMoney) {
		this.profitMoney = profitMoney;
	}

	/**
	 * @mbggenerated 发放时间
	 */
	public String getSettleTime() {
		return settleTime;
	}

	/**
	 * @mbggenerated 发放时间
	 */
	public void setSettleTime(String settleTime) {
		this.settleTime = settleTime;
	}

	/**
	 * @mbggenerated 发放标记（0:默认1选中 2= 已发放）
	 */
	public Integer getSettleFlag() {
		return settleFlag;
	}

	/**
	 * @mbggenerated 发放标记（0:默认1选中 2= 已发放）
	 */
	public void setSettleFlag(Integer settleFlag) {
		this.settleFlag = settleFlag;
	}

	/**
	 * @mbggenerated 备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @mbggenerated 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @mbggenerated 合同编号
	 */
	public String getAgreementNo() {
		return agreementNo;
	}

	/**
	 * @mbggenerated 合同编号
	 */
	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @mbggenerated 业绩结算时间
	 */
	public Date getDealVerifyTime() {
		return dealVerifyTime;
	}

	/**
	 * @mbggenerated 业绩结算时间
	 */
	public void setDealVerifyTime(Date dealVerifyTime) {
		this.dealVerifyTime = dealVerifyTime;
	}

	/**
	 * @mbggenerated 合同类型（101出售102出租）
	 */
	public Byte getDealType() {
		return dealType;
	}

	/**
	 * @mbggenerated 合同类型（101出售102出租）
	 */
	public void setDealType(Byte dealType) {
		this.dealType = dealType;
	}

	/**
	 * @mbggenerated 大区ID
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated 大区ID
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @mbggenerated 片区ID
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated 片区ID
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @mbggenerated 业绩结算类型（0上月结算1本月结算）
	 */
	public Byte getProfitDealType() {
		return profitDealType;
	}

	/**
	 * @mbggenerated 业绩结算类型（0上月结算1本月结算）
	 */
	public void setProfitDealType(Byte profitDealType) {
		this.profitDealType = profitDealType;
	}

	/**
	 * @mbggenerated 业绩类别ID
	 */
	public Integer getPerformanceId() {
		return performanceId;
	}

	/**
	 * @mbggenerated 业绩类别ID
	 */
	public void setPerformanceId(Integer performanceId) {
		this.performanceId = performanceId;
	}

	/**
	 * @mbggenerated 业绩类别名称
	 */
	public String getPerformanceName() {
		return performanceName;
	}

	/**
	 * @mbggenerated 业绩类别名称
	 */
	public void setPerformanceName(String performanceName) {
		this.performanceName = performanceName;
	}

	/**
	 * @mbggenerated 分组ID
	 */
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated 分组ID
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	/**
	 * @mbggenerated 业绩类型 0=个人业绩、1=公司业绩、2=没有业绩所属人的个人业绩、3=已删除的个人业绩
	 */
	public Byte getProfitType() {
		return profitType;
	}

	/**
	 * @mbggenerated 业绩类型 0=个人业绩、1=公司业绩、2=没有业绩所属人的个人业绩、3=已删除的个人业绩
	 */
	public void setProfitType(Byte profitType) {
		this.profitType = profitType;
	}

	/**
	 * @mbggenerated 员工档案iD
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated 员工档案iD
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated 角色ID
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @mbggenerated 角色ID
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @mbggenerated 角色名称
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @mbggenerated 角色名称
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @mbggenerated 职级ID
	 */
	public Integer getLevelsId() {
		return levelsId;
	}

	/**
	 * @mbggenerated 职级ID
	 */
	public void setLevelsId(Integer levelsId) {
		this.levelsId = levelsId;
	}

	/**
	 * @mbggenerated 职级名称
	 */
	public String getLevelsName() {
		return levelsName;
	}

	/**
	 * @mbggenerated 职级名称
	 */
	public void setLevelsName(String levelsName) {
		this.levelsName = levelsName;
	}

	/**
	 * @mbggenerated 应收金额
	 */
	public BigDecimal getReceivableMoney() {
		return receivableMoney;
	}

	/**
	 * @mbggenerated 应收金额
	 */
	public void setReceivableMoney(BigDecimal receivableMoney) {
		this.receivableMoney = receivableMoney;
	}

	/**
	 * @mbggenerated 业绩类别 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融 
	 */
	public Byte getPerformanceType() {
		return performanceType;
	}

	/**
	 * @mbggenerated 业绩类别 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融 
	 */
	public void setPerformanceType(Byte performanceType) {
		this.performanceType = performanceType;
	}

	/**
	 * @mbggenerated 折扣比例，生成业绩的时候，读取财务上的配置
	 */
	public BigDecimal getDiscount() {
		return discount;
	}

	/**
	 * @mbggenerated 折扣比例，生成业绩的时候，读取财务上的配置
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	/**
	 * @mbggenerated 考核月（自然月）
	 */
	public String getAssessmentMonth() {
		return assessmentMonth;
	}

	/**
	 * @mbggenerated 考核月（自然月）
	 */
	public void setAssessmentMonth(String assessmentMonth) {
		this.assessmentMonth = assessmentMonth;
	}

	/**
	 * @mbggenerated 异常状态 0 =正常 1=异常
	 */
	public Integer getValidFlag() {
		return validFlag;
	}

	/**
	 * @mbggenerated 异常状态 0 =正常 1=异常
	 */
	public void setValidFlag(Integer validFlag) {
		this.validFlag = validFlag;
	}

	/**
	 * @mbggenerated 组织综合查询字段 :12001:12002:12003:
	 */
	public String getOrganizationPath() {
		return organizationPath;
	}

	/**
	 * @mbggenerated 组织综合查询字段 :12001:12002:12003:
	 */
	public void setOrganizationPath(String organizationPath) {
		this.organizationPath = organizationPath;
	}

	/**
	 * @mbggenerated 组织ID1
	 */
	public Integer getOrg1() {
		return org1;
	}

	/**
	 * @mbggenerated 组织ID1
	 */
	public void setOrg1(Integer org1) {
		this.org1 = org1;
	}

	/**
	 * @mbggenerated 组织ID2
	 */
	public Integer getOrg2() {
		return org2;
	}

	/**
	 * @mbggenerated 组织ID2
	 */
	public void setOrg2(Integer org2) {
		this.org2 = org2;
	}

	/**
	 * @mbggenerated 组织ID3
	 */
	public Integer getOrg3() {
		return org3;
	}

	/**
	 * @mbggenerated 组织ID3
	 */
	public void setOrg3(Integer org3) {
		this.org3 = org3;
	}

	/**
	 * @mbggenerated 组织ID4
	 */
	public Integer getOrg4() {
		return org4;
	}

	/**
	 * @mbggenerated 组织ID4
	 */
	public void setOrg4(Integer org4) {
		this.org4 = org4;
	}

	/**
	 * @mbggenerated 组织ID5
	 */
	public Integer getOrg5() {
		return org5;
	}

	/**
	 * @mbggenerated 组织ID5
	 */
	public void setOrg5(Integer org5) {
		this.org5 = org5;
	}

	/**
	 * @mbggenerated 组织ID6
	 */
	public Integer getOrg6() {
		return org6;
	}

	/**
	 * @mbggenerated 组织ID6
	 */
	public void setOrg6(Integer org6) {
		this.org6 = org6;
	}

	/**
	 * @mbggenerated 组织ID7
	 */
	public Integer getOrg7() {
		return org7;
	}

	/**
	 * @mbggenerated 组织ID7
	 */
	public void setOrg7(Integer org7) {
		this.org7 = org7;
	}

	/**
	 * @mbggenerated 组织ID8
	 */
	public Integer getOrg8() {
		return org8;
	}

	/**
	 * @mbggenerated 组织ID8
	 */
	public void setOrg8(Integer org8) {
		this.org8 = org8;
	}

	/**
	 * @mbggenerated 组织ID9
	 */
	public Integer getOrg9() {
		return org9;
	}

	/**
	 * @mbggenerated 组织ID9
	 */
	public void setOrg9(Integer org9) {
		this.org9 = org9;
	}

	/**
	 * @mbggenerated 组织ID10
	 */
	public Integer getOrg10() {
		return org10;
	}

	/**
	 * @mbggenerated 组织ID10
	 */
	public void setOrg10(Integer org10) {
		this.org10 = org10;
	}

	/**
	 * @mbggenerated 组织ID11
	 */
	public Integer getOrg11() {
		return org11;
	}

	/**
	 * @mbggenerated 组织ID11
	 */
	public void setOrg11(Integer org11) {
		this.org11 = org11;
	}

	/**
	 * @mbggenerated 组织ID12
	 */
	public Integer getOrg12() {
		return org12;
	}

	/**
	 * @mbggenerated 组织ID12
	 */
	public void setOrg12(Integer org12) {
		this.org12 = org12;
	}

	/**
	 * @mbggenerated 组织ID13
	 */
	public Integer getOrg13() {
		return org13;
	}

	/**
	 * @mbggenerated 组织ID13
	 */
	public void setOrg13(Integer org13) {
		this.org13 = org13;
	}

	/**
	 * @mbggenerated 组织ID14
	 */
	public Integer getOrg14() {
		return org14;
	}

	/**
	 * @mbggenerated 组织ID14
	 */
	public void setOrg14(Integer org14) {
		this.org14 = org14;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunProfit() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunProfit(Integer shardCityId, Integer profitId) {
		super(shardCityId);
		this.profitId = profitId;
	}
}