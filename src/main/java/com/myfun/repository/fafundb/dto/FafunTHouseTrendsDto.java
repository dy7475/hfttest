package com.myfun.repository.fafundb.dto;

import com.myfun.repository.fafundb.po.FafunTHouseTrends;

public class FafunTHouseTrendsDto extends FafunTHouseTrends{

	private static final long serialVersionUID = 1L;
	private Integer saleTotalClick;//出售点击量
	private Integer leaseTotalClick;//出租点击量
	private String ShowType;
	private Integer totalClick;//总点击量
	private Integer monthCount;//月点击量
	private String month;//具体哪个月
	private Integer calculateTotalClick;//后台算出的点击量
	private Integer fourRoomCount;//大于等于4室的统计数siteName
	private String siteName;//站点名称
	private Integer saleLease;//出租出售
	private String userName;//用户名
	private String name;//统计对应的name
	private Integer value;//统计对应的value
	private String primaryName;
	private String countType;
	
	
	
	
	
	public String getCountType() {
		return countType;
	}
	public void setCountType(String countType) {
		this.countType = countType;
	}
	public String getPrimaryName() {
		return primaryName;
	}
	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public Integer getFourRoomCount() {
		return fourRoomCount;
	}
	public void setFourRoomCount(Integer fourRoomCount) {
		this.fourRoomCount = fourRoomCount;
	}
	public Integer getCalculateTotalClick() {
		return calculateTotalClick;
	}
	public void setCalculateTotalClick(Integer calculateTotalClick) {
		this.calculateTotalClick = calculateTotalClick;
	}
	public Integer getMonthCount() {
		return monthCount;
	}
	public void setMonthCount(Integer monthCount) {
		this.monthCount = monthCount;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Integer getTotalClick() {
		return totalClick;
	}
	public void setTotalClick(Integer totalClick) {
		this.totalClick = totalClick;
	}
	public String getShowType() {
		return ShowType;
	}
	public void setShowType(String showType) {
		ShowType = showType;
	}
	public Integer getSaleTotalClick() {
		return saleTotalClick;
	}
	public void setSaleTotalClick(Integer saleTotalClick) {
		this.saleTotalClick = saleTotalClick;
	}
	public Integer getLeaseTotalClick() {
		return leaseTotalClick;
	}
	public void setLeaseTotalClick(Integer leaseTotalClick) {
		this.leaseTotalClick = leaseTotalClick;
	}
	public Integer getSaleLease() {
		return saleLease;
	}
	public void setSaleLease(Integer saleLease) {
		this.saleLease = saleLease;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
