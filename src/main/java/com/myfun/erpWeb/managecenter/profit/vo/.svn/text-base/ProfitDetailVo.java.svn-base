package com.myfun.erpWeb.managecenter.profit.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel
public class ProfitDetailVo  {
	@ApiModelProperty(value = "业绩类别 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融")
	private Byte performanceType;
	@ApiModelProperty(value = "合同录入类型，1: 手动录入业绩生成的合同(即没有权证的合同,虚拟合同)0 or null: 权证合同")
	private Byte isbyhand;
	@ApiModelProperty(value = "合同ID，自增序列")
	private Integer dealId;
	@ApiModelProperty(value = "员工ID")
	private Integer userId;
	@ApiModelProperty(value = "实收分配比例")
	private BigDecimal profitProportion;
	@ApiModelProperty(value = "实收金额")
	private BigDecimal profitMoney;
	@ApiModelProperty(value = "成交类型，DD:CASE_TYPE")
	private Byte dealType;
	@ApiModelProperty(value = "合同号【合同创建时不论是手动输入还是自动分配的编号】")
	private String contractNo;
	@ApiModelProperty(value = "合同成交时的房源地址描述")
	private String houseaddress;
	@ApiModelProperty(value = "业绩结算时间")
	private Date dealVerifyTime;
	@ApiModelProperty(value = "发放标记（0:默认1选中 2= 已发放）")
	private Integer settleFlag;
	@ApiModelProperty(value = "发放时间")
	private String settleTime;

	public Byte getPerformanceType() {
		return performanceType;
	}

	public void setPerformanceType(Byte performanceType) {
		this.performanceType = performanceType;
	}

	public Byte getIsbyhand() {
		return isbyhand;
	}

	public void setIsbyhand(Byte isbyhand) {
		this.isbyhand = isbyhand;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Byte getDealType() {
		return dealType;
	}

	public void setDealType(Byte dealType) {
		this.dealType = dealType;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getHouseaddress() {
		return houseaddress;
	}

	public void setHouseaddress(String houseaddress) {
		this.houseaddress = houseaddress;
	}

	public Date getDealVerifyTime() {
		return dealVerifyTime;
	}

	public void setDealVerifyTime(Date dealVerifyTime) {
		this.dealVerifyTime = dealVerifyTime;
	}

	public Integer getSettleFlag() {
		return settleFlag;
	}

	public void setSettleFlag(Integer settleFlag) {
		this.settleFlag = settleFlag;
	}

	public String getSettleTime() {
		return settleTime;
	}

	public void setSettleTime(String settleTime) {
		this.settleTime = settleTime;
	}
}
