package com.myfun.repository.agencydb.po;

import java.io.Serializable;

public class AgencyWfServiceSetting implements Serializable {

	/**
	 * @mbggenerated 经纪人ID
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated 上下班状态开关(0-下班,1-上班)
	 */
	private Byte isWork;
	/**
	 * @mbggenerated 新需求提醒开关(0-关,1-开)
	 */
	private Byte requirementNotify;
	/**
	 * @mbggenerated 求购需求提醒开关(0-关,1-开
	 */
	private Byte buyRequirementNotify;
	/**
	 * @mbggenerated 求租需求提醒开关(0-关,1-开)
	 */
	private Byte rentRequirementNotify;
	/**
	 * @mbggenerated 租房佣金(0-零佣金,1-半月,2-一月) 例:0|2
	 */
	private String rentBrokerage;
	/**
	 * @mbggenerated 购房佣金比例(0.01=1%) 例:0.01|0.005
	 */
	private String saleBrokerageRatio;
	/**
	 * @mbggenerated
	 */
	private Byte smsNotify;
	/**
	 * @mbggenerated 设置求购委托红包
	 */
	private Integer buyMoney;
	/**
	 * @mbggenerated 设置求租委托红包
	 */
	private Integer rentMoney;
	/**
	 * @mbggenerated 微店红包是否开启0.未开启1.开启
	 */
	private Integer wdHbSwitch;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIsWork() {
		return isWork;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsWork(Byte isWork) {
		this.isWork = isWork;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getRequirementNotify() {
		return requirementNotify;
	}

	/**
	 * @mbggenerated
	 */
	public void setRequirementNotify(Byte requirementNotify) {
		this.requirementNotify = requirementNotify;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getBuyRequirementNotify() {
		return buyRequirementNotify;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuyRequirementNotify(Byte buyRequirementNotify) {
		this.buyRequirementNotify = buyRequirementNotify;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getRentRequirementNotify() {
		return rentRequirementNotify;
	}

	/**
	 * @mbggenerated
	 */
	public void setRentRequirementNotify(Byte rentRequirementNotify) {
		this.rentRequirementNotify = rentRequirementNotify;
	}

	/**
	 * @mbggenerated
	 */
	public String getRentBrokerage() {
		return rentBrokerage;
	}

	/**
	 * @mbggenerated
	 */
	public void setRentBrokerage(String rentBrokerage) {
		this.rentBrokerage = rentBrokerage == null ? null : rentBrokerage.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSaleBrokerageRatio() {
		return saleBrokerageRatio;
	}

	/**
	 * @mbggenerated
	 */
	public void setSaleBrokerageRatio(String saleBrokerageRatio) {
		this.saleBrokerageRatio = saleBrokerageRatio == null ? null : saleBrokerageRatio.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getSmsNotify() {
		return smsNotify;
	}

	/**
	 * @mbggenerated
	 */
	public void setSmsNotify(Byte smsNotify) {
		this.smsNotify = smsNotify;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getBuyMoney() {
		return buyMoney;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuyMoney(Integer buyMoney) {
		this.buyMoney = buyMoney;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getRentMoney() {
		return rentMoney;
	}

	/**
	 * @mbggenerated
	 */
	public void setRentMoney(Integer rentMoney) {
		this.rentMoney = rentMoney;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getWdHbSwitch() {
		return wdHbSwitch;
	}

	/**
	 * @mbggenerated
	 */
	public void setWdHbSwitch(Integer wdHbSwitch) {
		this.wdHbSwitch = wdHbSwitch;
	}
}