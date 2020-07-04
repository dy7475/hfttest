package com.myfun.erpWeb.managecenter.transaction.vo;



import com.myfun.repository.erpdb.po.ErpFunDealTaxesFather;
import com.myfun.repository.erpdb.po.ErpFunDealTaxesSub;

import java.math.BigDecimal;
import java.util.List;

public class DealContractDto  {
	private String contractNo;
	private Integer dealId;
	private String creatorName;
	private String signUserName;
	private String sellAddress;
	private String signDate;
	private String buyOwnerName;
	private String sellOwnerName;
	private BigDecimal rentDealMoney;
	private Integer dealType;
	private BigDecimal sellDealMoney;
	private Byte rentPriceUnit;
	private Byte salePriceUnit;
	private String dealUserName;
	private Integer dealUserId;
	private Integer creatorUid;
	private Integer custUserUid;
	private Integer houseUserUid;
	private String modelName;
	private Byte processStatus;
	private String signUserDeptName;
	private BigDecimal commercialLoanMoney;
	private Integer stepSeq;
	private String stepName;
	private Byte runstepStatus;
	private Integer updateUser;
	private String updateUserName;
	private String flowcontent;
	private String timelimitdate;
	private String updateTime;

	private List<ErpFunDealTaxesFather>  gettaxestypedata;
	private List<ErpFunDealTaxesSub> gettaxesdetaileddata;

	public List<ErpFunDealTaxesFather> getGettaxestypedata() {
		return gettaxestypedata;
	}

	public void setGettaxestypedata(List<ErpFunDealTaxesFather> gettaxestypedata) {
		this.gettaxestypedata = gettaxestypedata;
	}

	public List<ErpFunDealTaxesSub> getGettaxesdetaileddata() {
		return gettaxesdetaileddata;
	}

	public void setGettaxesdetaileddata(List<ErpFunDealTaxesSub> gettaxesdetaileddata) {
		this.gettaxesdetaileddata = gettaxesdetaileddata;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getSignUserName() {
		return signUserName;
	}

	public void setSignUserName(String signUserName) {
		this.signUserName = signUserName;
	}

	public String getSellAddress() {
		return sellAddress;
	}

	public void setSellAddress(String sellAddress) {
		this.sellAddress = sellAddress;
	}

	public String getSignDate() {
		return signDate;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}

	public String getBuyOwnerName() {
		return buyOwnerName;
	}

	public void setBuyOwnerName(String buyOwnerName) {
		this.buyOwnerName = buyOwnerName;
	}

	public String getSellOwnerName() {
		return sellOwnerName;
	}

	public void setSellOwnerName(String sellOwnerName) {
		this.sellOwnerName = sellOwnerName;
	}

	public BigDecimal getRentDealMoney() {
		return rentDealMoney;
	}

	public void setRentDealMoney(BigDecimal rentDealMoney) {
		this.rentDealMoney = rentDealMoney;
	}

	public Integer getDealType() {
		return dealType;
	}

	public void setDealType(Integer dealType) {
		this.dealType = dealType;
	}

	public BigDecimal getSellDealMoney() {
		return sellDealMoney;
	}

	public void setSellDealMoney(BigDecimal sellDealMoney) {
		this.sellDealMoney = sellDealMoney;
	}

	public Byte getRentPriceUnit() {
		return rentPriceUnit;
	}

	public void setRentPriceUnit(Byte rentPriceUnit) {
		this.rentPriceUnit = rentPriceUnit;
	}

	public Byte getSalePriceUnit() {
		return salePriceUnit;
	}

	public void setSalePriceUnit(Byte salePriceUnit) {
		this.salePriceUnit = salePriceUnit;
	}

	public String getDealUserName() {
		return dealUserName;
	}

	public void setDealUserName(String dealUserName) {
		this.dealUserName = dealUserName;
	}

	public Integer getDealUserId() {
		return dealUserId;
	}

	public void setDealUserId(Integer dealUserId) {
		this.dealUserId = dealUserId;
	}

	public Integer getCreatorUid() {
		return creatorUid;
	}

	public void setCreatorUid(Integer creatorUid) {
		this.creatorUid = creatorUid;
	}

	public Integer getCustUserUid() {
		return custUserUid;
	}

	public void setCustUserUid(Integer custUserUid) {
		this.custUserUid = custUserUid;
	}

	public Integer getHouseUserUid() {
		return houseUserUid;
	}

	public void setHouseUserUid(Integer houseUserUid) {
		this.houseUserUid = houseUserUid;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Byte getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(Byte processStatus) {
		this.processStatus = processStatus;
	}

	public String getSignUserDeptName() {
		return signUserDeptName;
	}

	public void setSignUserDeptName(String signUserDeptName) {
		this.signUserDeptName = signUserDeptName;
	}

	public BigDecimal getCommercialLoanMoney() {
		return commercialLoanMoney;
	}

	public void setCommercialLoanMoney(BigDecimal commercialLoanMoney) {
		this.commercialLoanMoney = commercialLoanMoney;
	}

	public Integer getStepSeq() {
		return stepSeq;
	}

	public void setStepSeq(Integer stepSeq) {
		this.stepSeq = stepSeq;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public Byte getRunstepStatus() {
		return runstepStatus;
	}

	public void setRunstepStatus(Byte runstepStatus) {
		this.runstepStatus = runstepStatus;
	}

	public Integer getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public String getFlowcontent() {
		return flowcontent;
	}

	public void setFlowcontent(String flowcontent) {
		this.flowcontent = flowcontent;
	}

	public String getTimelimitdate() {
		return timelimitdate;
	}

	public void setTimelimitdate(String timelimitdate) {
		this.timelimitdate = timelimitdate;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
