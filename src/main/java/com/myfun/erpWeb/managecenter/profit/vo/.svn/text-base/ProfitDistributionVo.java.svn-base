package com.myfun.erpWeb.managecenter.profit.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 个人业绩详细数据
 * @Package com.myfun.erpWeb.managecenter.profit.vo 
 * @author 陈文超   
 * @date 2019年8月28日 下午9:04:32
 */
@ApiModel
public class ProfitDistributionVo implements Serializable {
	
	@ApiModelProperty(value = "统计数据ID", hidden = true)
	private Integer countDataId;
	
	@ApiModelProperty(value = "统计数据标识", hidden = true)
	private String countDataStr;
	
	@ApiModelProperty("数据类型：1个人提成、2直接培育提成、3传承培育提成")
    private Byte dataType;
	
	@ApiModelProperty("签约日期")
    private String signDate;
	
	@ApiModelProperty("合同编号")
    private String dealNo;
	
	@ApiModelProperty("物业地址")
    private String houseAddr;
	
	@ApiModelProperty("佣金金额")
    private BigDecimal commissionMoney;
	
	@ApiModelProperty("业绩来源")
    private String profitSource;
	
	@ApiModelProperty("分成业绩")
    private BigDecimal divideProfit;
	
	@ApiModelProperty("提成金额，该字段为字符串的原因是前端展示使用（个人提成计算方式不一样），运算的时候注意转换")
    private String incomeProfit;
	
	@ApiModelProperty("分成员工userId(直接和传承培育才有该数据)")
    private BigDecimal divideUserId;
	
	@ApiModelProperty("分成员工roleId(直接和传承培育才有该数据)")
    private String divideUserRoleId;
	
	@ApiModelProperty("分成员工姓名 + 角色名(直接和传承培育才有该数据)")
    private String divideUserName;
	
	@ApiModelProperty("贡献业绩(直接和传承培育才有该数据)")
    private BigDecimal contributionProfit;
	
	@ApiModelProperty("结盘日期")
    private String overDate;
	
	@ApiModelProperty("业绩类别ID（二手房佣金，金融业绩，新房业绩...）,用于查询FUN_WAGE_TYPE_NEW的提成类型数据")
	private Byte performanceType;

	@ApiModelProperty("房源名称，掌通个人战绩详情使用")
	private String buildName;

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public Byte getDataType() {
		return dataType;
	}

	public void setDataType(Byte dataType) {
		this.dataType = dataType;
	}

	public String getSignDate() {
		return signDate;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}

	public String getDealNo() {
		return dealNo;
	}

	public void setDealNo(String dealNo) {
		this.dealNo = dealNo;
	}

	public String getHouseAddr() {
		return houseAddr;
	}

	public void setHouseAddr(String houseAddr) {
		this.houseAddr = houseAddr;
	}

	public BigDecimal getCommissionMoney() {
		return commissionMoney;
	}

	public void setCommissionMoney(BigDecimal commissionMoney) {
		this.commissionMoney = commissionMoney;
	}

	public String getProfitSource() {
		return profitSource;
	}

	public void setProfitSource(String profitSource) {
		this.profitSource = profitSource;
	}

	public BigDecimal getDivideProfit() {
		return divideProfit;
	}

	public void setDivideProfit(BigDecimal divideProfit) {
		this.divideProfit = divideProfit;
	}
	
	public String getIncomeProfit() {
		return incomeProfit;
	}

	public void setIncomeProfit(String incomeProfit) {
		this.incomeProfit = incomeProfit;
	}

	public String getOverDate() {
		return overDate;
	}

	public void setOverDate(String overDate) {
		this.overDate = overDate;
	}

	public BigDecimal getDivideUserId() {
		return divideUserId;
	}

	public void setDivideUserId(BigDecimal divideUserId) {
		this.divideUserId = divideUserId;
	}

	public String getDivideUserRoleId() {
		return divideUserRoleId;
	}

	public void setDivideUserRoleId(String divideUserRoleId) {
		this.divideUserRoleId = divideUserRoleId;
	}

	public String getDivideUserName() {
		return divideUserName;
	}

	public void setDivideUserName(String divideUserName) {
		this.divideUserName = divideUserName;
	}

	public BigDecimal getContributionProfit() {
		return contributionProfit;
	}

	public void setContributionProfit(BigDecimal contributionProfit) {
		this.contributionProfit = contributionProfit;
	}

	public Integer getCountDataId() {
		return countDataId;
	}

	public void setCountDataId(Integer countDataId) {
		this.countDataId = countDataId;
	}

	public String getCountDataStr() {
		return countDataStr;
	}

	public void setCountDataStr(String countDataStr) {
		this.countDataStr = countDataStr;
	}

	public Byte getPerformanceType() {
		return performanceType;
	}

	public void setPerformanceType(Byte performanceType) {
		this.performanceType = performanceType;
	}
}
