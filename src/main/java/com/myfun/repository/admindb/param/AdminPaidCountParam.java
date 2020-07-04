package com.myfun.repository.admindb.param;

import com.myfun.repository.support.param.PageParam;

/**
 * @author 作者张卓
 * @version 创建时间：2016年4月13日 下午6:01:24 类说明
 */
public class AdminPaidCountParam extends PageParam {
	private Integer crmCompId;
	private Integer cityId;
	private String userMobile;
	private String time1;
	private String time2;
	private String flag;
	private String runFlag;
	private String statType;
	private String faaType;
	private String frmType;
	private String isDistribute;
	private String money;
	private String sQryTime;
	private String eQryTime;

	public String getFaaType() {
		return faaType;
	}

	public void setFaaType(String faaType) {
		this.faaType = faaType;
	}

	public String getFrmType() {
		return frmType;
	}

	public void setFrmType(String frmType) {
		this.frmType = frmType;
	}

	public String getIsDistribute() {
		return isDistribute;
	}

	public void setIsDistribute(String isDistribute) {
		this.isDistribute = isDistribute;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getsQryTime() {
		return sQryTime;
	}

	public void setsQryTime(String sQryTime) {
		this.sQryTime = sQryTime;
	}

	public String geteQryTime() {
		return eQryTime;
	}

	public void seteQryTime(String eQryTime) {
		this.eQryTime = eQryTime;
	}

	public String getStatType() {
		return statType;
	}

	public void setStatType(String statType) {
		this.statType = statType;
	}

	public String getRunFlag() {
		return runFlag;
	}

	public void setRunFlag(String runFlag) {
		this.runFlag = runFlag;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Integer getCrmCompId() {
		return crmCompId;
	}

	public void setCrmCompId(Integer crmCompId) {
		this.crmCompId = crmCompId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

}
