package com.myfun.erpWeb.managecenter.profit.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 个人业绩详细数据集合
 * @Package com.myfun.erpWeb.managecenter.profit.param 
 * @author 陈文超   
 * @date 2019年8月28日 下午8:46:42
 */
@ApiModel
public class ProfitDistributionListVo implements Serializable {
	
	@ApiModelProperty("用户头像url")
    private String userPhotoUrl;
	
	@ApiModelProperty("用户姓名")
    private String userName;
	
	@ApiModelProperty("角色名称-房基地版中叫：职级名称")
    private String roleName;
	
	@ApiModelProperty("个人业绩提成总和")
	private BigDecimal profitMoney;
	
	@ApiModelProperty("直接培育业绩提成总和")
	private BigDecimal directProfitMoney;
	
	@ApiModelProperty("间接培育业绩提成总和")
	private BigDecimal indirectProfitMoney;
	
	@ApiModelProperty("个人+直接培育+间接培育业绩提成的总和")
	private BigDecimal sumProfitMoney;
	
	@ApiModelProperty("列表中-个人分成业绩的合计")
	private BigDecimal sumDivideProfit;
	
	@ApiModelProperty("列表中-个人提成的合计")
	private BigDecimal sumIncome;
	
	@ApiModelProperty("列表中-直接培育贡献业绩的合计")
	private BigDecimal sumDirectContribution;
	
	@ApiModelProperty("列表中-直接培育贡献业绩提成金额的合计")
	private BigDecimal sumDirectIncome;
	
	@ApiModelProperty("列表中-间接培育贡献业绩的合计")
	private BigDecimal sumIndirectContribution;
	
	@ApiModelProperty("列表中-间接培育贡献业绩提成的合计")
	private BigDecimal sumIndirectIncome;
	
	@ApiModelProperty("个人业绩数据集合，统计个人战绩明细时使用")
	private List<ProfitDistributionVo> personProfit;
	
	@ApiModelProperty("直接培育人的分成业绩数据集合，统计个人战绩明细时使用")
	private List<ProfitDistributionVo> personDirectProfit;
	
	@ApiModelProperty("间接培育人的分成业绩数据集合，统计个人战绩明细时使用")
	private List<ProfitDistributionVo> personIndirectProfit;

	@ApiModelProperty("直接团队人数，掌通个人战绩详情使用")
	private Integer directUserNum;

	@ApiModelProperty("传承团队人数，掌通个人战绩详情使用")
	private Integer indirectUserNum;

	@ApiModelProperty("个人提成百分比，掌通个人战绩详情使用")
	private BigDecimal personPercent;

	@ApiModelProperty("直接提成百分比，掌通个人战绩详情使用")
	private BigDecimal personDirectPercent;

	@ApiModelProperty("间接提成百分比，掌通个人战绩详情使用")
	private BigDecimal personIndirectPercent;


	public BigDecimal getPersonPercent() {
		return personPercent;
	}

	public void setPersonPercent(BigDecimal personPercent) {
		this.personPercent = personPercent;
	}

	public BigDecimal getPersonDirectPercent() {
		return personDirectPercent;
	}

	public void setPersonDirectPercent(BigDecimal personDirectPercent) {
		this.personDirectPercent = personDirectPercent;
	}

	public BigDecimal getPersonIndirectPercent() {
		return personIndirectPercent;
	}

	public void setPersonIndirectPercent(BigDecimal personIndirectPercent) {
		this.personIndirectPercent = personIndirectPercent;
	}

	public Integer getDirectUserNum() {
		return directUserNum;
	}

	public void setDirectUserNum(Integer directUserNum) {
		this.directUserNum = directUserNum;
	}

	public Integer getIndirectUserNum() {
		return indirectUserNum;
	}

	public void setIndirectUserNum(Integer indirectUserNum) {
		this.indirectUserNum = indirectUserNum;
	}

	public List<ProfitDistributionVo> getPersonProfit() {
		return personProfit;
	}

	public void setPersonProfit(List<ProfitDistributionVo> personProfit) {
		this.personProfit = personProfit;
	}

	public List<ProfitDistributionVo> getPersonDirectProfit() {
		return personDirectProfit;
	}

	public void setPersonDirectProfit(List<ProfitDistributionVo> personDirectProfit) {
		this.personDirectProfit = personDirectProfit;
	}

	public List<ProfitDistributionVo> getPersonIndirectProfit() {
		return personIndirectProfit;
	}

	public void setPersonIndirectProfit(List<ProfitDistributionVo> personIndirectProfit) {
		this.personIndirectProfit = personIndirectProfit;
	}

	public BigDecimal getProfitMoney() {
		return profitMoney;
	}

	public void setProfitMoney(BigDecimal profitMoney) {
		this.profitMoney = profitMoney;
	}

	public BigDecimal getDirectProfitMoney() {
		return directProfitMoney;
	}

	public void setDirectProfitMoney(BigDecimal directProfitMoney) {
		this.directProfitMoney = directProfitMoney;
	}

	public BigDecimal getIndirectProfitMoney() {
		return indirectProfitMoney;
	}

	public void setIndirectProfitMoney(BigDecimal indirectProfitMoney) {
		this.indirectProfitMoney = indirectProfitMoney;
	}

	public BigDecimal getSumProfitMoney() {
		return sumProfitMoney;
	}

	public void setSumProfitMoney(BigDecimal sumProfitMoney) {
		this.sumProfitMoney = sumProfitMoney;
	}

	public BigDecimal getSumDivideProfit() {
		return sumDivideProfit;
	}

	public void setSumDivideProfit(BigDecimal sumDivideProfit) {
		this.sumDivideProfit = sumDivideProfit;
	}

	public BigDecimal getSumIncome() {
		return sumIncome;
	}

	public void setSumIncome(BigDecimal sumIncome) {
		this.sumIncome = sumIncome;
	}

	public BigDecimal getSumDirectContribution() {
		return sumDirectContribution;
	}

	public void setSumDirectContribution(BigDecimal sumDirectContribution) {
		this.sumDirectContribution = sumDirectContribution;
	}

	public BigDecimal getSumDirectIncome() {
		return sumDirectIncome;
	}

	public void setSumDirectIncome(BigDecimal sumDirectIncome) {
		this.sumDirectIncome = sumDirectIncome;
	}

	public BigDecimal getSumIndirectContribution() {
		return sumIndirectContribution;
	}

	public void setSumIndirectContribution(BigDecimal sumIndirectContribution) {
		this.sumIndirectContribution = sumIndirectContribution;
	}

	public BigDecimal getSumIndirectIncome() {
		return sumIndirectIncome;
	}

	public void setSumIndirectIncome(BigDecimal sumIndirectIncome) {
		this.sumIndirectIncome = sumIndirectIncome;
	}

	public String getUserPhotoUrl() {
		return userPhotoUrl;
	}

	public void setUserPhotoUrl(String userPhotoUrl) {
		this.userPhotoUrl = userPhotoUrl;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
