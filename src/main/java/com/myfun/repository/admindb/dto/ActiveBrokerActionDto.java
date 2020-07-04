package com.myfun.repository.admindb.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.myfun.repository.admindb.po.AdminFunArchive;

/**
 * 活跃经纪人列表对象
 * @author Administrator
 *
 */
public class ActiveBrokerActionDto extends AdminFunArchive{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal amount;
	private BigDecimal haofangAmount;
	private BigDecimal haofangBuy;
	private String citySuperUser;
	private String superTime;
	private String cityName;
	private String trackContent;
	private Integer trackUser;
	private Date trackTime;
	private BigDecimal discountAmount; //优惠券
	private Integer isVIP;
	
	public Integer getIsVIP() {
		return isVIP;
	}
	public void setIsVIP(Integer isVIP) {
		this.isVIP = isVIP;
	}
	public BigDecimal getHaofangBuy() {
		return haofangBuy;
	}
	public void setHaofangBuy(BigDecimal haofangBuy) {
		this.haofangBuy = haofangBuy;
	}
	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}
	public String getTrackContent() {
		return trackContent;
	}
	public void setTrackContent(String trackContent) {
		this.trackContent = trackContent;
	}
	public Integer getTrackUser() {
		return trackUser;
	}
	public void setTrackUser(Integer trackUser) {
		this.trackUser = trackUser;
	}
	public Date getTrackTime() {
		return trackTime;
	}
	public void setTrackTime(Date trackTime) {
		this.trackTime = trackTime;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getHaofangAmount() {
		return haofangAmount;
	}
	public void setHaofangAmount(BigDecimal haofangAmount) {
		this.haofangAmount = haofangAmount;
	}
	public String getCitySuperUser() {
		return citySuperUser;
	}
	public void setCitySuperUser(String citySuperUser) {
		this.citySuperUser = citySuperUser;
	}
	public String getSuperTime() {
		return superTime;
	}
	public void setSuperTime(String superTime) {
		this.superTime = superTime;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	

}
