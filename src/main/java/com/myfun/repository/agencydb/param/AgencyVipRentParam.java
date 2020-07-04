package com.myfun.repository.agencydb.param;

import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.stax2.ri.typed.ValueDecoderFactory.DecimalDecoder;

import com.myfun.repository.support.param.PageParam;

public class AgencyVipRentParam extends PageParam {
	private String date1;
	private String date2;
	private String tradeTime1;
	private String tradeTime2;
	private String isphone;/* 判断用户读取电话的权限 */
	private String clientmobile;
	private Byte houseRoom1;
	private Byte houseRoom2;
	private BigDecimal price1;
	private BigDecimal price2;
	private BigDecimal houseArea1;
	private BigDecimal houseArea2;
	private String huxing;
	private String priceText;
	private String buildId;
	private String buildName;
	private String houseUseage;
	private String houseAreaText;
	private String userName;
	private String sex;
	private String phone;
	private String cellphone;
	private String houseFitment;
	private String provinceId;
	private String houseRight;
	private Integer cityId;
	private Integer caseStatus;
	private String regionName;
	private Byte newComplain;
	private Byte hasRefund;
	private Byte infoSource;
	private Date creationTime;
	private Byte purchaseCount;
	private Byte complainCount;
	private Integer creatorUid;

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getTradeTime1() {
		return tradeTime1;
	}

	public void setTradeTime1(String tradeTime1) {
		this.tradeTime1 = tradeTime1;
	}

	public String getTradeTime2() {
		return tradeTime2;
	}

	public void setTradeTime2(String tradeTime2) {
		this.tradeTime2 = tradeTime2;
	}

	public String getIsphone() {
		return isphone;
	}

	public void setIsphone(String isphone) {
		this.isphone = isphone;
	}

	public String getClientmobile() {
		return clientmobile;
	}

	public void setClientmobile(String clientmobile) {
		this.clientmobile = clientmobile;
	}

	public Byte getHouseRoom1() {
		return houseRoom1;
	}

	public void setHouseRoom1(Byte houseRoom1) {
		this.houseRoom1 = houseRoom1;
	}

	public Byte getHouseRoom2() {
		return houseRoom2;
	}

	public void setHouseRoom2(Byte houseRoom2) {
		this.houseRoom2 = houseRoom2;
	}

	public BigDecimal getPrice1() {
		return price1;
	}

	public void setPrice1(BigDecimal price1) {
		this.price1 = price1;
	}

	public BigDecimal getPrice2() {
		return price2;
	}

	public void setPrice2(BigDecimal price2) {
		this.price2 = price2;
	}

	public BigDecimal getHouseArea1() {
		return houseArea1;
	}

	public void setHouseArea1(BigDecimal houseArea1) {
		this.houseArea1 = houseArea1;
	}

	public BigDecimal getHouseArea2() {
		return houseArea2;
	}

	public void setHouseArea2(BigDecimal houseArea2) {
		this.houseArea2 = houseArea2;
	}

	public String getHuxing() {
		return huxing;
	}

	public void setHuxing(String huxing) {
		this.huxing = huxing;
	}

	public String getPriceText() {
		return priceText;
	}

	public void setPriceText(String priceText) {
		this.priceText = priceText;
	}

	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public String getHouseUseage() {
		return houseUseage;
	}

	public void setHouseUseage(String houseUseage) {
		this.houseUseage = houseUseage;
	}

	public String getHouseAreaText() {
		return houseAreaText;
	}

	public void setHouseAreaText(String houseAreaText) {
		this.houseAreaText = houseAreaText;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getHouseFitment() {
		return houseFitment;
	}

	public void setHouseFitment(String houseFitment) {
		this.houseFitment = houseFitment;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getHouseRight() {
		return houseRight;
	}

	public void setHouseRight(String houseRight) {
		this.houseRight = houseRight;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(Integer caseStatus) {
		this.caseStatus = caseStatus;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Byte getNewComplain() {
		return newComplain;
	}

	public void setNewComplain(Byte newComplain) {
		this.newComplain = newComplain;
	}

	public Byte getHasRefund() {
		return hasRefund;
	}

	public void setHasRefund(Byte hasRefund) {
		this.hasRefund = hasRefund;
	}

	public Byte getInfoSource() {
		return infoSource;
	}

	public void setInfoSource(Byte infoSource) {
		this.infoSource = infoSource;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Byte getPurchaseCount() {
		return purchaseCount;
	}

	public void setPurchaseCount(Byte purchaseCount) {
		this.purchaseCount = purchaseCount;
	}

	public Byte getComplainCount() {
		return complainCount;
	}

	public void setComplainCount(Byte complainCount) {
		this.complainCount = complainCount;
	}

	public Integer getCreatorUid() {
		return creatorUid;
	}

	public void setCreatorUid(Integer creatorUid) {
		this.creatorUid = creatorUid;
	}

}
