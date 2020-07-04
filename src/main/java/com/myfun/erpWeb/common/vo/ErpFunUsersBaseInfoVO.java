package com.myfun.erpWeb.common.vo;

import io.swagger.annotations.ApiModel;

import java.util.Date;

@ApiModel("")
public class ErpFunUsersBaseInfoVO {
	/**
	 *
	 * @mbggenerated
	 */
	private Integer loanrateId;

	/**
	 *
	 * @mbggenerated
	 */
	private String loanrateDate;

	/**
	 *
	 * @mbggenerated
	 */
	private Double basePublicRate;

	/**
	 *
	 * @mbggenerated
	 */
	private Double baseBusiRate;

	/**
	 *
	 * @mbggenerated
	 */
	private Date createTime;

	/**
	 *
	 * @mbggenerated
	 */
	private Date updateTime;

	/**
	 *
	 * @mbggenerated
	 */
	private Integer seqNo;

	public Integer getLoanrateId() {
		return loanrateId;
	}

	public void setLoanrateId(Integer loanrateId) {
		this.loanrateId = loanrateId;
	}

	public String getLoanrateDate() {
		return loanrateDate;
	}

	public void setLoanrateDate(String loanrateDate) {
		this.loanrateDate = loanrateDate;
	}

	public Double getBasePublicRate() {
		return basePublicRate;
	}

	public void setBasePublicRate(Double basePublicRate) {
		this.basePublicRate = basePublicRate;
	}

	public Double getBaseBusiRate() {
		return baseBusiRate;
	}

	public void setBaseBusiRate(Double baseBusiRate) {
		this.baseBusiRate = baseBusiRate;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
}
