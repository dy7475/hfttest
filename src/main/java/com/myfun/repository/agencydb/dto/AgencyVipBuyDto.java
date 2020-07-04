package com.myfun.repository.agencydb.dto;

import com.myfun.repository.agencydb.po.AgencyVipBuy;

import java.util.Date;

public class AgencyVipBuyDto extends AgencyVipBuy{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cityName;
	private String isBroker;
	private String clientName;
	private String clientMobile;
	private Integer callNum;
	private Integer callCount;
	private Integer giftPrice;
	private Integer buyCount;
	private Integer perpetualFlag;
	private Date pbTime;

	public Date getPbTime() {
		return pbTime;
	}

	public void setPbTime(Date pbTime) {
		this.pbTime = pbTime;
	}

	public Integer getPerpetualFlag() {
		return perpetualFlag;
	}

	public void setPerpetualFlag(Integer perpetualFlag) {
		this.perpetualFlag = perpetualFlag;
	}

	public Integer getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(Integer buyCount) {
		this.buyCount = buyCount;
	}

	public Integer getCallCount() {
		return callCount;
	}

	public void setCallCount(Integer callCount) {
		this.callCount = callCount;
	}

	public Integer getGiftPrice() {
		return giftPrice;
	}

	public void setGiftPrice(Integer giftPrice) {
		this.giftPrice = giftPrice;
	}

	public Integer getCallNum() {
		return callNum;
	}

	public void setCallNum(Integer callNum) {
		this.callNum = callNum;
	}

	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getIsBroker() {
		return isBroker;
	}
	public void setIsBroker(String isBroker) {
		this.isBroker = isBroker;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientMobile() {
		return clientMobile;
	}
	public void setClientMobile(String clientMobile) {
		this.clientMobile = clientMobile;
	}

	
}
