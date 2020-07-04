package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunDealOld extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer dealId;
	/**
	 * @mbggenerated
	 */
	private String agreementNo;
	/**
	 * @mbggenerated
	 */
	private Date creatorDate;
	/**
	 * @mbggenerated
	 */
	private String dealType;
	/**
	 * @mbggenerated
	 */
	private String dealStatus;
	/**
	 * @mbggenerated
	 */
	private Integer dealComplete;
	/**
	 * @mbggenerated
	 */
	private Integer dealUserId;
	/**
	 * @mbggenerated
	 */
	private String dealVerifyCon;
	/**
	 * @mbggenerated
	 */
	private Date dealVerifyTime;
	/**
	 * @mbggenerated
	 */
	private String dealBuyStyle;
	/**
	 * @mbggenerated
	 */
	private String dealSellStyle;
	/**
	 * @mbggenerated
	 */
	private String dealCustomerNo;
	/**
	 * @mbggenerated
	 */
	private String dealHouseNo;
	/**
	 * @mbggenerated
	 */
	private String sellAddress;
	/**
	 * @mbggenerated
	 */
	private String buyCustinfo;
	/**
	 * @mbggenerated
	 */
	private String sellHezuoCompname;
	/**
	 * @mbggenerated
	 */
	private String buyHezuoCompname;
	/**
	 * @mbggenerated
	 */
	private String buyContactuser;
	/**
	 * @mbggenerated
	 */
	private String sellContactuser;
	/**
	 * @mbggenerated
	 */
	private String buyOwnerName;
	/**
	 * @mbggenerated
	 */
	private String sellOwnerName;
	/**
	 * @mbggenerated
	 */
	private String buyCallPhone;
	/**
	 * @mbggenerated
	 */
	private String sellCallPhone;
	/**
	 * @mbggenerated
	 */
	private String buyIdCard;
	/**
	 * @mbggenerated
	 */
	private String sellIdCard;
	/**
	 * @mbggenerated
	 */
	private Double buyPaymoney;
	/**
	 * @mbggenerated
	 */
	private Double sellPaymoney;
	/**
	 * @mbggenerated
	 */
	private Double otherPaymoney;
	/**
	 * @mbggenerated
	 */
	private Double gainMoney;
	/**
	 * @mbggenerated
	 */
	private Double realBuyPaymoney;
	/**
	 * @mbggenerated
	 */
	private Double realSellPaymoney;
	/**
	 * @mbggenerated
	 */
	private Double realOtherPaymoney;
	/**
	 * @mbggenerated
	 */
	private Double realPaymoney;
	/**
	 * @mbggenerated
	 */
	private Double buyPriceMoney;
	/**
	 * @mbggenerated
	 */
	private String buyPayType;
	/**
	 * @mbggenerated
	 */
	private Double buyMortgageMoney;
	/**
	 * @mbggenerated
	 */
	private String buyMortgageType;
	/**
	 * @mbggenerated
	 */
	private Double sellDealMoney;
	/**
	 * @mbggenerated
	 */
	private Integer sellIshaveLoan;
	/**
	 * @mbggenerated
	 */
	private Double sellLoanMoney;
	/**
	 * @mbggenerated
	 */
	private Integer sellReturnLoan;
	/**
	 * @mbggenerated
	 */
	private String ownerStyle;
	/**
	 * @mbggenerated
	 */
	private String ownerType;
	/**
	 * @mbggenerated
	 */
	private String ownerNo;
	/**
	 * @mbggenerated
	 */
	private Integer haveLandcard;
	/**
	 * @mbggenerated
	 */
	private String landcardNo;
	/**
	 * @mbggenerated
	 */
	private Integer mangementTax;
	/**
	 * @mbggenerated
	 */
	private Integer ownerTax;
	/**
	 * @mbggenerated
	 */
	private String tax;
	/**
	 * @mbggenerated
	 */
	private String rentPayMethod;
	/**
	 * @mbggenerated
	 */
	private String rentPayEarly;
	/**
	 * @mbggenerated
	 */
	private Double rentDealMoney;
	/**
	 * @mbggenerated
	 */
	private Date rentDate;
	/**
	 * @mbggenerated
	 */
	private Date rentOverDate;
	/**
	 * @mbggenerated
	 */
	private String rentPaySpace;
	/**
	 * @mbggenerated
	 */
	private Double rentDepositPay;
	/**
	 * @mbggenerated
	 */
	private Double rentOtherMoney;
	/**
	 * @mbggenerated
	 */
	private String rentPriceUnit;
	/**
	 * @mbggenerated
	 */
	private String goodsdetailed;
	/**
	 * @mbggenerated
	 */
	private String waterlightexpenses;
	/**
	 * @mbggenerated
	 */
	private String tradeRemarkExplain;
	/**
	 * @mbggenerated
	 */
	private Date systemRecordTime;
	/**
	 * @mbggenerated
	 */
	private Integer creatorUid;
	/**
	 * @mbggenerated
	 */
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	private Integer updateUid;
	/**
	 * @mbggenerated
	 */
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	private Byte syncFlag;
	/**
	 * @mbggenerated
	 */
	private Byte lockFlag;
	/**
	 * @mbggenerated
	 */
	private Integer regId;
	/**
	 * @mbggenerated
	 */
	private Integer areaId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getDealId() {
		return dealId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	/**
	 * @mbggenerated
	 */
	public String getAgreementNo() {
		return agreementNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo == null ? null : agreementNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreatorDate() {
		return creatorDate;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreatorDate(Date creatorDate) {
		this.creatorDate = creatorDate;
	}

	/**
	 * @mbggenerated
	 */
	public String getDealType() {
		return dealType;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealType(String dealType) {
		this.dealType = dealType == null ? null : dealType.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getDealStatus() {
		return dealStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus == null ? null : dealStatus.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDealComplete() {
		return dealComplete;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealComplete(Integer dealComplete) {
		this.dealComplete = dealComplete;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDealUserId() {
		return dealUserId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealUserId(Integer dealUserId) {
		this.dealUserId = dealUserId;
	}

	/**
	 * @mbggenerated
	 */
	public String getDealVerifyCon() {
		return dealVerifyCon;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealVerifyCon(String dealVerifyCon) {
		this.dealVerifyCon = dealVerifyCon == null ? null : dealVerifyCon.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getDealVerifyTime() {
		return dealVerifyTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealVerifyTime(Date dealVerifyTime) {
		this.dealVerifyTime = dealVerifyTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getDealBuyStyle() {
		return dealBuyStyle;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealBuyStyle(String dealBuyStyle) {
		this.dealBuyStyle = dealBuyStyle == null ? null : dealBuyStyle.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getDealSellStyle() {
		return dealSellStyle;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealSellStyle(String dealSellStyle) {
		this.dealSellStyle = dealSellStyle == null ? null : dealSellStyle.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getDealCustomerNo() {
		return dealCustomerNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealCustomerNo(String dealCustomerNo) {
		this.dealCustomerNo = dealCustomerNo == null ? null : dealCustomerNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getDealHouseNo() {
		return dealHouseNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealHouseNo(String dealHouseNo) {
		this.dealHouseNo = dealHouseNo == null ? null : dealHouseNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSellAddress() {
		return sellAddress;
	}

	/**
	 * @mbggenerated
	 */
	public void setSellAddress(String sellAddress) {
		this.sellAddress = sellAddress == null ? null : sellAddress.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getBuyCustinfo() {
		return buyCustinfo;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuyCustinfo(String buyCustinfo) {
		this.buyCustinfo = buyCustinfo == null ? null : buyCustinfo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSellHezuoCompname() {
		return sellHezuoCompname;
	}

	/**
	 * @mbggenerated
	 */
	public void setSellHezuoCompname(String sellHezuoCompname) {
		this.sellHezuoCompname = sellHezuoCompname == null ? null : sellHezuoCompname.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getBuyHezuoCompname() {
		return buyHezuoCompname;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuyHezuoCompname(String buyHezuoCompname) {
		this.buyHezuoCompname = buyHezuoCompname == null ? null : buyHezuoCompname.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getBuyContactuser() {
		return buyContactuser;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuyContactuser(String buyContactuser) {
		this.buyContactuser = buyContactuser == null ? null : buyContactuser.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSellContactuser() {
		return sellContactuser;
	}

	/**
	 * @mbggenerated
	 */
	public void setSellContactuser(String sellContactuser) {
		this.sellContactuser = sellContactuser == null ? null : sellContactuser.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getBuyOwnerName() {
		return buyOwnerName;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuyOwnerName(String buyOwnerName) {
		this.buyOwnerName = buyOwnerName == null ? null : buyOwnerName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSellOwnerName() {
		return sellOwnerName;
	}

	/**
	 * @mbggenerated
	 */
	public void setSellOwnerName(String sellOwnerName) {
		this.sellOwnerName = sellOwnerName == null ? null : sellOwnerName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getBuyCallPhone() {
		return buyCallPhone;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuyCallPhone(String buyCallPhone) {
		this.buyCallPhone = buyCallPhone == null ? null : buyCallPhone.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSellCallPhone() {
		return sellCallPhone;
	}

	/**
	 * @mbggenerated
	 */
	public void setSellCallPhone(String sellCallPhone) {
		this.sellCallPhone = sellCallPhone == null ? null : sellCallPhone.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getBuyIdCard() {
		return buyIdCard;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuyIdCard(String buyIdCard) {
		this.buyIdCard = buyIdCard == null ? null : buyIdCard.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSellIdCard() {
		return sellIdCard;
	}

	/**
	 * @mbggenerated
	 */
	public void setSellIdCard(String sellIdCard) {
		this.sellIdCard = sellIdCard == null ? null : sellIdCard.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Double getBuyPaymoney() {
		return buyPaymoney;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuyPaymoney(Double buyPaymoney) {
		this.buyPaymoney = buyPaymoney;
	}

	/**
	 * @mbggenerated
	 */
	public Double getSellPaymoney() {
		return sellPaymoney;
	}

	/**
	 * @mbggenerated
	 */
	public void setSellPaymoney(Double sellPaymoney) {
		this.sellPaymoney = sellPaymoney;
	}

	/**
	 * @mbggenerated
	 */
	public Double getOtherPaymoney() {
		return otherPaymoney;
	}

	/**
	 * @mbggenerated
	 */
	public void setOtherPaymoney(Double otherPaymoney) {
		this.otherPaymoney = otherPaymoney;
	}

	/**
	 * @mbggenerated
	 */
	public Double getGainMoney() {
		return gainMoney;
	}

	/**
	 * @mbggenerated
	 */
	public void setGainMoney(Double gainMoney) {
		this.gainMoney = gainMoney;
	}

	/**
	 * @mbggenerated
	 */
	public Double getRealBuyPaymoney() {
		return realBuyPaymoney;
	}

	/**
	 * @mbggenerated
	 */
	public void setRealBuyPaymoney(Double realBuyPaymoney) {
		this.realBuyPaymoney = realBuyPaymoney;
	}

	/**
	 * @mbggenerated
	 */
	public Double getRealSellPaymoney() {
		return realSellPaymoney;
	}

	/**
	 * @mbggenerated
	 */
	public void setRealSellPaymoney(Double realSellPaymoney) {
		this.realSellPaymoney = realSellPaymoney;
	}

	/**
	 * @mbggenerated
	 */
	public Double getRealOtherPaymoney() {
		return realOtherPaymoney;
	}

	/**
	 * @mbggenerated
	 */
	public void setRealOtherPaymoney(Double realOtherPaymoney) {
		this.realOtherPaymoney = realOtherPaymoney;
	}

	/**
	 * @mbggenerated
	 */
	public Double getRealPaymoney() {
		return realPaymoney;
	}

	/**
	 * @mbggenerated
	 */
	public void setRealPaymoney(Double realPaymoney) {
		this.realPaymoney = realPaymoney;
	}

	/**
	 * @mbggenerated
	 */
	public Double getBuyPriceMoney() {
		return buyPriceMoney;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuyPriceMoney(Double buyPriceMoney) {
		this.buyPriceMoney = buyPriceMoney;
	}

	/**
	 * @mbggenerated
	 */
	public String getBuyPayType() {
		return buyPayType;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuyPayType(String buyPayType) {
		this.buyPayType = buyPayType == null ? null : buyPayType.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Double getBuyMortgageMoney() {
		return buyMortgageMoney;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuyMortgageMoney(Double buyMortgageMoney) {
		this.buyMortgageMoney = buyMortgageMoney;
	}

	/**
	 * @mbggenerated
	 */
	public String getBuyMortgageType() {
		return buyMortgageType;
	}

	/**
	 * @mbggenerated
	 */
	public void setBuyMortgageType(String buyMortgageType) {
		this.buyMortgageType = buyMortgageType == null ? null : buyMortgageType.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Double getSellDealMoney() {
		return sellDealMoney;
	}

	/**
	 * @mbggenerated
	 */
	public void setSellDealMoney(Double sellDealMoney) {
		this.sellDealMoney = sellDealMoney;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSellIshaveLoan() {
		return sellIshaveLoan;
	}

	/**
	 * @mbggenerated
	 */
	public void setSellIshaveLoan(Integer sellIshaveLoan) {
		this.sellIshaveLoan = sellIshaveLoan;
	}

	/**
	 * @mbggenerated
	 */
	public Double getSellLoanMoney() {
		return sellLoanMoney;
	}

	/**
	 * @mbggenerated
	 */
	public void setSellLoanMoney(Double sellLoanMoney) {
		this.sellLoanMoney = sellLoanMoney;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getSellReturnLoan() {
		return sellReturnLoan;
	}

	/**
	 * @mbggenerated
	 */
	public void setSellReturnLoan(Integer sellReturnLoan) {
		this.sellReturnLoan = sellReturnLoan;
	}

	/**
	 * @mbggenerated
	 */
	public String getOwnerStyle() {
		return ownerStyle;
	}

	/**
	 * @mbggenerated
	 */
	public void setOwnerStyle(String ownerStyle) {
		this.ownerStyle = ownerStyle == null ? null : ownerStyle.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOwnerType() {
		return ownerType;
	}

	/**
	 * @mbggenerated
	 */
	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType == null ? null : ownerType.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOwnerNo() {
		return ownerNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setOwnerNo(String ownerNo) {
		this.ownerNo = ownerNo == null ? null : ownerNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getHaveLandcard() {
		return haveLandcard;
	}

	/**
	 * @mbggenerated
	 */
	public void setHaveLandcard(Integer haveLandcard) {
		this.haveLandcard = haveLandcard;
	}

	/**
	 * @mbggenerated
	 */
	public String getLandcardNo() {
		return landcardNo;
	}

	/**
	 * @mbggenerated
	 */
	public void setLandcardNo(String landcardNo) {
		this.landcardNo = landcardNo == null ? null : landcardNo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getMangementTax() {
		return mangementTax;
	}

	/**
	 * @mbggenerated
	 */
	public void setMangementTax(Integer mangementTax) {
		this.mangementTax = mangementTax;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getOwnerTax() {
		return ownerTax;
	}

	/**
	 * @mbggenerated
	 */
	public void setOwnerTax(Integer ownerTax) {
		this.ownerTax = ownerTax;
	}

	/**
	 * @mbggenerated
	 */
	public String getTax() {
		return tax;
	}

	/**
	 * @mbggenerated
	 */
	public void setTax(String tax) {
		this.tax = tax == null ? null : tax.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getRentPayMethod() {
		return rentPayMethod;
	}

	/**
	 * @mbggenerated
	 */
	public void setRentPayMethod(String rentPayMethod) {
		this.rentPayMethod = rentPayMethod == null ? null : rentPayMethod.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getRentPayEarly() {
		return rentPayEarly;
	}

	/**
	 * @mbggenerated
	 */
	public void setRentPayEarly(String rentPayEarly) {
		this.rentPayEarly = rentPayEarly == null ? null : rentPayEarly.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Double getRentDealMoney() {
		return rentDealMoney;
	}

	/**
	 * @mbggenerated
	 */
	public void setRentDealMoney(Double rentDealMoney) {
		this.rentDealMoney = rentDealMoney;
	}

	/**
	 * @mbggenerated
	 */
	public Date getRentDate() {
		return rentDate;
	}

	/**
	 * @mbggenerated
	 */
	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	/**
	 * @mbggenerated
	 */
	public Date getRentOverDate() {
		return rentOverDate;
	}

	/**
	 * @mbggenerated
	 */
	public void setRentOverDate(Date rentOverDate) {
		this.rentOverDate = rentOverDate;
	}

	/**
	 * @mbggenerated
	 */
	public String getRentPaySpace() {
		return rentPaySpace;
	}

	/**
	 * @mbggenerated
	 */
	public void setRentPaySpace(String rentPaySpace) {
		this.rentPaySpace = rentPaySpace == null ? null : rentPaySpace.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Double getRentDepositPay() {
		return rentDepositPay;
	}

	/**
	 * @mbggenerated
	 */
	public void setRentDepositPay(Double rentDepositPay) {
		this.rentDepositPay = rentDepositPay;
	}

	/**
	 * @mbggenerated
	 */
	public Double getRentOtherMoney() {
		return rentOtherMoney;
	}

	/**
	 * @mbggenerated
	 */
	public void setRentOtherMoney(Double rentOtherMoney) {
		this.rentOtherMoney = rentOtherMoney;
	}

	/**
	 * @mbggenerated
	 */
	public String getRentPriceUnit() {
		return rentPriceUnit;
	}

	/**
	 * @mbggenerated
	 */
	public void setRentPriceUnit(String rentPriceUnit) {
		this.rentPriceUnit = rentPriceUnit == null ? null : rentPriceUnit.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getGoodsdetailed() {
		return goodsdetailed;
	}

	/**
	 * @mbggenerated
	 */
	public void setGoodsdetailed(String goodsdetailed) {
		this.goodsdetailed = goodsdetailed == null ? null : goodsdetailed.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getWaterlightexpenses() {
		return waterlightexpenses;
	}

	/**
	 * @mbggenerated
	 */
	public void setWaterlightexpenses(String waterlightexpenses) {
		this.waterlightexpenses = waterlightexpenses == null ? null : waterlightexpenses.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getTradeRemarkExplain() {
		return tradeRemarkExplain;
	}

	/**
	 * @mbggenerated
	 */
	public void setTradeRemarkExplain(String tradeRemarkExplain) {
		this.tradeRemarkExplain = tradeRemarkExplain == null ? null : tradeRemarkExplain.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Date getSystemRecordTime() {
		return systemRecordTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setSystemRecordTime(Date systemRecordTime) {
		this.systemRecordTime = systemRecordTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCreatorUid() {
		return creatorUid;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreatorUid(Integer creatorUid) {
		this.creatorUid = creatorUid;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getUpdateUid() {
		return updateUid;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateUid(Integer updateUid) {
		this.updateUid = updateUid;
	}

	/**
	 * @mbggenerated
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getSyncFlag() {
		return syncFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setSyncFlag(Byte syncFlag) {
		this.syncFlag = syncFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getLockFlag() {
		return lockFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setLockFlag(Byte lockFlag) {
		this.lockFlag = lockFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunDealOld() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunDealOld(Integer shardCityId, Integer dealId) {
		super(shardCityId);
		this.dealId = dealId;
	}
}