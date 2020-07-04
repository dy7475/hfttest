package com.myfun.erpWeb.usercenter.vo;

import io.swagger.annotations.ApiModel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @tag getAllUaInfo接口返回值
 * @author 邓永洪
 * @since 2018/5/24
 */
@ApiModel
public class AllUaInfoDto {
	private BigDecimal compAcount;
	private BigDecimal compAmountCoin;
	private Double compAmountPrice;
	private BigDecimal compCashMoney;
	private BigDecimal compExtractAmount;
	private BigDecimal compExtractAmountAll;
	private Byte compPayStatus;
	private Integer compUaId;
	private Integer contractId;
	private Integer contractStatus;
	private Byte custLevel;
	private Byte microProgramStatus;
	private Date otoEnd;
	private Integer payNum;
	private Byte payType;
	private BigDecimal perAmount;
	private BigDecimal perAmountCoin;
	private Double perAmountPrice;
	private BigDecimal perCashMoney;
	private BigDecimal perExtractAmount;
	private BigDecimal perExtractAmountAll;
	private Integer perQuanCount;
	private BigDecimal perShareMoney;
	private Date spaceEnd;
	private Date stopTime;
	private Date superEnd;
	private BigDecimal trueHouseDeposit;
	private Date tryEnd;
	private String uaUserMobile;
	private Integer weiContractId;
	private String weiContractNo;
	private BigDecimal youAmount;
	private Date custEndTime;
	private Byte microProgramVersion;
	private  Byte wxPayType;
	private Date wxEndTime;
	private String weiContractHtml;
	private Integer totalUserNumber;
	private BigDecimal perShareMoneyTotal;
	private BigDecimal compShareMoneyTotal;
	private BigDecimal compShareMoney;
	private Date plusEndTime;

	public Date getPlusEndTime() {
		return plusEndTime;
	}

	public void setPlusEndTime(Date plusEndTime) {
		this.plusEndTime = plusEndTime;
	}

	public BigDecimal getCompShareMoney() {
		return compShareMoney;
	}

	public void setCompShareMoney(BigDecimal compShareMoney) {
		this.compShareMoney = compShareMoney;
	}

	public BigDecimal getPerShareMoneyTotal() {
		return perShareMoneyTotal;
	}

	public void setPerShareMoneyTotal(BigDecimal perShareMoneyTotal) {
		this.perShareMoneyTotal = perShareMoneyTotal;
	}

	public BigDecimal getCompShareMoneyTotal() {
		return compShareMoneyTotal;
	}

	public void setCompShareMoneyTotal(BigDecimal compShareMoneyTotal) {
		this.compShareMoneyTotal = compShareMoneyTotal;
	}

	public BigDecimal getCompAcount() {
		return compAcount;
	}

	public void setCompAcount(BigDecimal compAcount) {
		this.compAcount = compAcount;
	}

	public BigDecimal getCompAmountCoin() {
		return compAmountCoin;
	}

	public void setCompAmountCoin(BigDecimal compAmountCoin) {
		this.compAmountCoin = compAmountCoin;
	}

	public Double getCompAmountPrice() {
		return compAmountPrice;
	}

	public void setCompAmountPrice(Double compAmountPrice) {
		this.compAmountPrice = compAmountPrice;
	}

	public BigDecimal getCompCashMoney() {
		return compCashMoney;
	}

	public void setCompCashMoney(BigDecimal compCashMoney) {
		this.compCashMoney = compCashMoney;
	}

	public BigDecimal getCompExtractAmount() {
		return compExtractAmount;
	}

	public void setCompExtractAmount(BigDecimal compExtractAmount) {
		this.compExtractAmount = compExtractAmount;
	}

	public BigDecimal getCompExtractAmountAll() {
		return compExtractAmountAll;
	}

	public void setCompExtractAmountAll(BigDecimal compExtractAmountAll) {
		this.compExtractAmountAll = compExtractAmountAll;
	}

	public Byte getCompPayStatus() {
		return compPayStatus;
	}

	public void setCompPayStatus(Byte compPayStatus) {
		this.compPayStatus = compPayStatus;
	}

	public Integer getCompUaId() {
		return compUaId;
	}

	public void setCompUaId(Integer compUaId) {
		this.compUaId = compUaId;
	}

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	public Integer getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(Integer contractStatus) {
		this.contractStatus = contractStatus;
	}

	public Byte getCustLevel() {
		return custLevel;
	}

	public void setCustLevel(Byte custLevel) {
		this.custLevel = custLevel;
	}

	public Byte getMicroProgramStatus() {
		return microProgramStatus;
	}

	public void setMicroProgramStatus(Byte microProgramStatus) {
		this.microProgramStatus = microProgramStatus;
	}

	public Date getOtoEnd() {
		return otoEnd;
	}

	public void setOtoEnd(Date otoEnd) {
		this.otoEnd = otoEnd;
	}

	public Integer getPayNum() {
		return payNum;
	}

	public void setPayNum(Integer payNum) {
		this.payNum = payNum;
	}

	public Byte getPayType() {
		return payType;
	}

	public void setPayType(Byte payType) {
		this.payType = payType;
	}

	public BigDecimal getPerAmount() {
		return perAmount;
	}

	public void setPerAmount(BigDecimal perAmount) {
		this.perAmount = perAmount;
	}

	public BigDecimal getPerAmountCoin() {
		return perAmountCoin;
	}

	public void setPerAmountCoin(BigDecimal perAmountCoin) {
		this.perAmountCoin = perAmountCoin;
	}

	public Double getPerAmountPrice() {
		return perAmountPrice;
	}

	public void setPerAmountPrice(Double perAmountPrice) {
		this.perAmountPrice = perAmountPrice;
	}

	public BigDecimal getPerCashMoney() {
		return perCashMoney;
	}

	public void setPerCashMoney(BigDecimal perCashMoney) {
		this.perCashMoney = perCashMoney;
	}

	public BigDecimal getPerExtractAmount() {
		return perExtractAmount;
	}

	public void setPerExtractAmount(BigDecimal perExtractAmount) {
		this.perExtractAmount = perExtractAmount;
	}

	public BigDecimal getPerExtractAmountAll() {
		return perExtractAmountAll;
	}

	public void setPerExtractAmountAll(BigDecimal perExtractAmountAll) {
		this.perExtractAmountAll = perExtractAmountAll;
	}

	public Integer getPerQuanCount() {
		return perQuanCount;
	}

	public void setPerQuanCount(Integer perQuanCount) {
		this.perQuanCount = perQuanCount;
	}

	public BigDecimal getPerShareMoney() {
		return perShareMoney;
	}

	public void setPerShareMoney(BigDecimal perShareMoney) {
		this.perShareMoney = perShareMoney;
	}

	public Date getSpaceEnd() {
		return spaceEnd;
	}

	public void setSpaceEnd(Date spaceEnd) {
		this.spaceEnd = spaceEnd;
	}

	public Date getStopTime() {
		return stopTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	public Date getSuperEnd() {
		return superEnd;
	}

	public void setSuperEnd(Date superEnd) {
		this.superEnd = superEnd;
	}

	public BigDecimal getTrueHouseDeposit() {
		return trueHouseDeposit;
	}

	public void setTrueHouseDeposit(BigDecimal trueHouseDeposit) {
		this.trueHouseDeposit = trueHouseDeposit;
	}

	public Date getTryEnd() {
		return tryEnd;
	}

	public void setTryEnd(Date tryEnd) {
		this.tryEnd = tryEnd;
	}

	public String getUaUserMobile() {
		return uaUserMobile;
	}

	public void setUaUserMobile(String uaUserMobile) {
		this.uaUserMobile = uaUserMobile;
	}

	public Integer getWeiContractId() {
		return weiContractId;
	}

	public void setWeiContractId(Integer weiContractId) {
		this.weiContractId = weiContractId;
	}

	public String getWeiContractNo() {
		return weiContractNo;
	}

	public void setWeiContractNo(String weiContractNo) {
		this.weiContractNo = weiContractNo;
	}

	public BigDecimal getYouAmount() {
		return youAmount;
	}

	public void setYouAmount(BigDecimal youAmount) {
		this.youAmount = youAmount;
	}

	public Date getCustEndTime() {
		return custEndTime;
	}

	public void setCustEndTime(Date custEndTime) {
		this.custEndTime = custEndTime;
	}

	public Byte getMicroProgramVersion() {
		return microProgramVersion;
	}

	public void setMicroProgramVersion(Byte microProgramVersion) {
		this.microProgramVersion = microProgramVersion;
	}

	public Byte getWxPayType() {
		return wxPayType;
	}

	public void setWxPayType(Byte wxPayType) {
		this.wxPayType = wxPayType;
	}

	public Date getWxEndTime() {
		return wxEndTime;
	}

	public void setWxEndTime(Date wxEndTime) {
		this.wxEndTime = wxEndTime;
	}

	public String getWeiContractHtml() {
		return weiContractHtml;
	}

	public void setWeiContractHtml(String weiContractHtml) {
		this.weiContractHtml = weiContractHtml;
	}

	public Integer getTotalUserNumber() {
		return totalUserNumber;
	}

	public void setTotalUserNumber(Integer totalUserNumber) {
		this.totalUserNumber = totalUserNumber;
	}
}
