package com.myfun.erpWeb.usercenter.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class UcenterIncomePayRecordParam extends AbstractEncryParam {

	@ApiModelProperty(hidden = true)
	private Integer cityId;
	@ApiModelProperty(hidden = true)
	private Integer compId;
	@ApiModelProperty(hidden = true)
	private Integer archiveId ;
	@ApiModelProperty("1:新房联动 2：收益金 3:贷款")
	private Integer balanceType;
	@ApiModelProperty(hidden = true)
	private Integer userId;
	@ApiModelProperty("收支")
	private String  incomePay;
	@ApiModelProperty("交易账户 1=个人 2=公司")
	private Integer accountType ;
	@ApiModelProperty("时间范围")
	private String timeRange;
	@ApiModelProperty(hidden = true)
	private String  startTime;
	@ApiModelProperty(hidden = true)
	private String  endTime;
	private String  isExtract;
	@ApiModelProperty(hidden = true)
	private Integer uaId ;
	@ApiModelProperty(hidden = true)
	private Integer compUaId;
	@ApiModelProperty(hidden = true)
	private String  compNo;
	private String timeString;

	public String getTimeString() {
		return timeString;
	}

	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getBalanceType() {
		return balanceType;
	}

	public void setBalanceType(Integer balanceType) {
		this.balanceType = balanceType;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getIncomePay() {
		return incomePay;
	}

	public void setIncomePay(String incomePay) {
		this.incomePay = incomePay;
	}

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public String getTimeRange() {
		return timeRange;
	}

	public void setTimeRange(String timeRange) {
		this.timeRange = timeRange;
	}

	public String getIsExtract() {
		return isExtract;
	}

	public void setIsExtract(String isExtract) {
		this.isExtract = isExtract;
	}

	public Integer getUaId() {
		return uaId;
	}

	public void setUaId(Integer uaId) {
		this.uaId = uaId;
	}

	public Integer getCompUaId() {
		return compUaId;
	}

	public void setCompUaId(Integer compUaId) {
		this.compUaId = compUaId;
	}

	public String getCompNo() {
		return compNo;
	}

	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}
}
