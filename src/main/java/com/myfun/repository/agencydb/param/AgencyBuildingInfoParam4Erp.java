package com.myfun.repository.agencydb.param;

import com.myfun.repository.agencydb.po.AgencyBuildingInfo;
import com.myfun.repository.agencydb.po.AgencyCooperationRule;
import com.myfun.repository.agencydb.po.AgencyFunUsers;

public class AgencyBuildingInfoParam4Erp extends AgencyBuildingInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String logUid;
	private String logPwd;
	private String balance;
	private Integer bandDay;
	private Integer bandPayment;
	private Integer bandReward;
	private Integer bandRewardNum; 
	private String bandSaw;
	private Integer bandcycleType;
	private String commission;
	private Integer commissionDay;
	private Integer commissioncycleType;
	private String contractNo;
	private String cooperateStart;
	private String cooperateEnd;
	private String soleSpecial;
	private Integer repeatDay;
	private Integer id;
	private String groupSpecial;
	private Integer draw;
	private Integer defineCommissioncycle;
	private Integer paidEndDay;
	private Integer defineDealcycle;
	private Integer dealPayment;
	private Integer dealDay;
	private Integer dealReward;
	private Integer defineBandcycle;
	private Integer dealcycleType;
	private Integer dealRewardsNum;
	
	private String oldSeqNo;
	
	
	public String getOldSeqNo() {
		return oldSeqNo;
	}
	public void setOldSeqNo(String oldSeqNo) {
		this.oldSeqNo = oldSeqNo;
	}
	public Integer getDefineBandcycle() {
		return defineBandcycle;
	}
	public void setDefineBandcycle(Integer defineBandcycle) {
		this.defineBandcycle = defineBandcycle;
	}
	public Integer getDealcycleType() {
		return dealcycleType;
	}
	public void setDealcycleType(Integer dealcycleType) {
		this.dealcycleType = dealcycleType;
	}
	public Integer getDealRewardsNum() {
		return dealRewardsNum;
	}
	public void setDealRewardsNum(Integer dealRewardsNum) {
		this.dealRewardsNum = dealRewardsNum;
	}
	public Integer getPaidEndDay() {
		return paidEndDay;
	}
	public void setPaidEndDay(Integer paidEndDay) {
		this.paidEndDay = paidEndDay;
	}
	public Integer getDefineDealcycle() {
		return defineDealcycle;
	}
	public void setDefineDealcycle(Integer defineDealcycle) {
		this.defineDealcycle = defineDealcycle;
	}
	public Integer getDealPayment() {
		return dealPayment;
	}
	public void setDealPayment(Integer dealPayment) {
		this.dealPayment = dealPayment;
	}
	public Integer getDealDay() {
		return dealDay;
	}
	public void setDealDay(Integer dealDay) {
		this.dealDay = dealDay;
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
	public String getSoleSpecial() {
		return soleSpecial;
	}
	public void setSoleSpecial(String soleSpecial) {
		this.soleSpecial = soleSpecial;
	}
	public Integer getRepeatDay() {
		return repeatDay;
	}
	public void setRepeatDay(Integer repeatDay) {
		this.repeatDay = repeatDay;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGroupSpecial() {
		return groupSpecial;
	}
	public void setGroupSpecial(String groupSpecial) {
		this.groupSpecial = groupSpecial;
	}
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public Integer getDefineCommissioncycle() {
		return defineCommissioncycle;
	}
	public void setDefineCommissioncycle(Integer defineCommissioncycle) {
		this.defineCommissioncycle = defineCommissioncycle;
	}
	public String getBandSaw() {
		return bandSaw;
	}
	public void setBandSaw(String bandSaw) {
		this.bandSaw = bandSaw;
	}
	public Integer getBandcycleType() {
		return bandcycleType;
	}
	public void setBandcycleType(Integer bandcycleType) {
		this.bandcycleType = bandcycleType;
	}
	public String getCommission() {
		return commission;
	}
	public void setCommission(String commission) {
		this.commission = commission;
	}
	public Integer getCommissionDay() {
		return commissionDay;
	}
	public void setCommissionDay(Integer commissionDay) {
		this.commissionDay = commissionDay;
	}
	public Integer getCommissioncycleType() {
		return commissioncycleType;
	}
	public void setCommissioncycleType(Integer commissioncycleType) {
		this.commissioncycleType = commissioncycleType;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public Integer getBandReward() {
		return bandReward;
	}
	public void setBandReward(Integer bandReward) {
		this.bandReward = bandReward;
	}
	public Integer getBandPayment() {
		return bandPayment;
	}
	public void setBandPayment(Integer bandPayment) {
		this.bandPayment = bandPayment;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public Integer getBandDay() {
		return bandDay;
	}
	public void setBandDay(Integer bandDay) {
		this.bandDay = bandDay;
	}
	public String getLogUid() {
		return logUid;
	}
	public void setLogUid(String logUid) {
		this.logUid = logUid;
	}
	public String getLogPwd() {
		return logPwd;
	}
	public void setLogPwd(String logPwd) {
		this.logPwd = logPwd;
	}
	
	public Integer getBandRewardNum() {
		return bandRewardNum;
	}
	public void setBandRewardNum(Integer bandRewardNum) {
		this.bandRewardNum = bandRewardNum;
	}
	public AgencyFunUsers getAgencyFunUsers() {
		AgencyFunUsers agencyFunUsers = new AgencyFunUsers();
		agencyFunUsers.setLoginPwd(logPwd);
		agencyFunUsers.setLoginUid(logUid);
		return agencyFunUsers;
		
	}
	
	public AgencyCooperationRule getAgencyCooperationRule() {
		AgencyCooperationRule cooperationRulePO = new AgencyCooperationRule();
		cooperationRulePO.setBalance(getBalance());
		cooperationRulePO.setBandDay(getBandDay());
		cooperationRulePO.setBandPayment(getBandPayment());
		cooperationRulePO.setBandReward(getBandReward());
		cooperationRulePO.setBandRewardNum(getBandRewardNum());
		cooperationRulePO.setBandSaw(getBandSaw());
		cooperationRulePO.setBandcycleType(getBandcycleType());
		cooperationRulePO.setCommission(getCommission());
		cooperationRulePO.setCommissionDay(getCommissionDay());
		cooperationRulePO.setCommissioncycleType(getCommissioncycleType());
		cooperationRulePO.setContractNo(getContractNo());
		cooperationRulePO.setCooperateEnd(getCooperateEnd());
		cooperationRulePO.setCooperateStart(getCooperateStart());
		cooperationRulePO.setSoleSpecial(getSoleSpecial());
		cooperationRulePO.setRepeatDay(getRepeatDay());
		cooperationRulePO.setPaidEndDay(getPaidEndDay());
		cooperationRulePO.setId(getId());
		cooperationRulePO.setGroupSpecial(getGroupSpecial());
		cooperationRulePO.setDraw(getDraw());
		cooperationRulePO.setDevloperId(getDevloperId());
		cooperationRulePO.setDefineDealcycle(getDefineDealcycle());
		cooperationRulePO.setDefineCommissioncycle(getDefineCommissioncycle());
		cooperationRulePO.setDefineBandcycle(getDefineBandcycle());
		cooperationRulePO.setDealcycleType(getDealcycleType());
		cooperationRulePO.setDealDay(getDealDay());
		cooperationRulePO.setDealPayment(getDealPayment());
		cooperationRulePO.setDealRewardsNum(getDealRewardsNum());
		cooperationRulePO.setDealReward(getDealReward());
		cooperationRulePO.setBuildId(getBuildId());
		return cooperationRulePO;
	}
	

}