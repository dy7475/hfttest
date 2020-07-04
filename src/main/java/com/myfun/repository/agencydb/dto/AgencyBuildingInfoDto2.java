package com.myfun.repository.agencydb.dto;

import java.util.Date;

import com.myfun.repository.agencydb.po.AgencyBuildingInfo;

public class AgencyBuildingInfoDto2 extends AgencyBuildingInfo {

	/**
	 * 专门为编辑回显使用
	 */
	private static final long serialVersionUID = 1L;
	/**
    *
    * 
    */
	private Integer id;

	/**
    *
    * 
    */
	private Integer cityId;

	/**
    *
    * 
    */
	private Integer deptId;

	/**
    *
    * 
    */
	private Integer devloperId;

	/**
    *
    * 
    */
	private Integer buildId;

	/**
    *
    * 
    */
	private String soleSpecial;

	/**
    *
    * 
    */
	private String groupSpecial;

	/**
    *
    * 
    */
	private String commission;

	/**
    *
    * 
    */
	private String bandSaw;

	/**
    *
    * 
    */
	private Integer dealReward;

	/**
    *
    * 
    */
	private String cooperateStart;

	/**
    *
    * 
    */
	private String cooperateEnd;

	/**
    *
    * 
    */
	private String balance;

	/**
    *
    * 
    */
	private String contractNo;

	/**
    *
    * 
    */
	private Integer createUid;

	/**
    *
    * 
    */
	private Date creationTime;

	/**
    *
    * 
    */
	private Integer cashDay;

	/**
    *
    * 
    */
	private Integer repeatDay;

	/**
    *
    * 
    */
	private Integer dealRewardsNum;

	/**
    *
    * 
    */
	private Integer draw;

	/**
    *
    * 
    */
	private Integer commissioncycleType;

	/**
    *
    * 
    */
	private Integer defineCommissioncycle;

	/**
    *
    * 
    */
	private Integer commissionDay;

	/**
    *
    * 
    */
	private Integer dealPayment;

	/**
    *
    * 
    */
	private Integer dealcycleType;

	/**
    *
    * 
    */
	private Integer defineDealcycle;

	/**
    *
    * 
    */
	private Integer dealDay;

	/**
    *
    * 
    */
	private Integer bandReward;

	/**
    *
    * 
    */
	private Integer bandRewardNum;

	/**
    *
    * 
    */
	private Integer bandPayment;

	/**
    *
    * 
    */
	private Integer bandcycleType;

	/**
    *
    * 
    */
	private Integer defineBandcycle;

	/**
    *
    * 
    */
	private Integer bandDay;

	/**
    *
    * 
    */
	private Integer paidEndDay;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getDevloperId() {
		return devloperId;
	}

	public void setDevloperId(Integer devloperId) {
		this.devloperId = devloperId;
	}

	public Integer getBuildId() {
		return buildId;
	}

	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	public String getSoleSpecial() {
		return soleSpecial;
	}

	public void setSoleSpecial(String soleSpecial) {
		this.soleSpecial = soleSpecial;
	}

	public String getGroupSpecial() {
		return groupSpecial;
	}

	public void setGroupSpecial(String groupSpecial) {
		this.groupSpecial = groupSpecial;
	}

	public String getCommission() {
		return commission;
	}

	public void setCommission(String commission) {
		this.commission = commission;
	}

	public String getBandSaw() {
		return bandSaw;
	}

	public void setBandSaw(String bandSaw) {
		this.bandSaw = bandSaw;
	}

	public Integer getDealReward() {
		return dealReward;
	}

	public void setDealReward(Integer dealReward) {
		this.dealReward = dealReward;
	}

	public String getCooperateStart() {
		return cooperateStart;
	}

	public void setCooperateStart(String cooperateStart) {
		this.cooperateStart = cooperateStart;
	}

	public String getCooperateEnd() {
		return cooperateEnd;
	}

	public void setCooperateEnd(String cooperateEnd) {
		this.cooperateEnd = cooperateEnd;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public Integer getCreateUid() {
		return createUid;
	}

	public void setCreateUid(Integer createUid) {
		this.createUid = createUid;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Integer getCashDay() {
		return cashDay;
	}

	public void setCashDay(Integer cashDay) {
		this.cashDay = cashDay;
	}

	public Integer getRepeatDay() {
		return repeatDay;
	}

	public void setRepeatDay(Integer repeatDay) {
		this.repeatDay = repeatDay;
	}

	public Integer getDealRewardsNum() {
		return dealRewardsNum;
	}

	public void setDealRewardsNum(Integer dealRewardsNum) {
		this.dealRewardsNum = dealRewardsNum;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getCommissioncycleType() {
		return commissioncycleType;
	}

	public void setCommissioncycleType(Integer commissioncycleType) {
		this.commissioncycleType = commissioncycleType;
	}

	public Integer getDefineCommissioncycle() {
		return defineCommissioncycle;
	}

	public void setDefineCommissioncycle(Integer defineCommissioncycle) {
		this.defineCommissioncycle = defineCommissioncycle;
	}

	public Integer getCommissionDay() {
		return commissionDay;
	}

	public void setCommissionDay(Integer commissionDay) {
		this.commissionDay = commissionDay;
	}

	public Integer getDealPayment() {
		return dealPayment;
	}

	public void setDealPayment(Integer dealPayment) {
		this.dealPayment = dealPayment;
	}

	public Integer getDealcycleType() {
		return dealcycleType;
	}

	public void setDealcycleType(Integer dealcycleType) {
		this.dealcycleType = dealcycleType;
	}

	public Integer getDefineDealcycle() {
		return defineDealcycle;
	}

	public void setDefineDealcycle(Integer defineDealcycle) {
		this.defineDealcycle = defineDealcycle;
	}

	public Integer getDealDay() {
		return dealDay;
	}

	public void setDealDay(Integer dealDay) {
		this.dealDay = dealDay;
	}

	public Integer getBandReward() {
		return bandReward;
	}

	public void setBandReward(Integer bandReward) {
		this.bandReward = bandReward;
	}

	public Integer getBandRewardNum() {
		return bandRewardNum;
	}

	public void setBandRewardNum(Integer bandRewardNum) {
		this.bandRewardNum = bandRewardNum;
	}

	public Integer getBandPayment() {
		return bandPayment;
	}

	public void setBandPayment(Integer bandPayment) {
		this.bandPayment = bandPayment;
	}

	public Integer getBandcycleType() {
		return bandcycleType;
	}

	public void setBandcycleType(Integer bandcycleType) {
		this.bandcycleType = bandcycleType;
	}

	public Integer getDefineBandcycle() {
		return defineBandcycle;
	}

	public void setDefineBandcycle(Integer defineBandcycle) {
		this.defineBandcycle = defineBandcycle;
	}

	public Integer getBandDay() {
		return bandDay;
	}

	public void setBandDay(Integer bandDay) {
		this.bandDay = bandDay;
	}

	public Integer getPaidEndDay() {
		return paidEndDay;
	}

	public void setPaidEndDay(Integer paidEndDay) {
		this.paidEndDay = paidEndDay;
	}

}
