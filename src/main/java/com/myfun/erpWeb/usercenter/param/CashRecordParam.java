package com.myfun.erpWeb.usercenter.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CashRecordParam extends AbstractEncryParam implements DaoBaseParam{

	@ApiModelProperty("时间类型")
	private String dateType;
	@ApiModelProperty("账户类型，1 = 个人 2 = 公司")
	private Integer uaType;

	@ApiModelProperty(hidden = true)
	private String startTime;
	@ApiModelProperty(hidden = true)
	private String endTime;
	@ApiModelProperty(hidden = true)
	private Integer isGeneralManager;
	@ApiModelProperty(hidden = true)
	private Integer selfCompType;
	@ApiModelProperty(hidden = true)
	private Integer selfUserId;
	@ApiModelProperty(hidden = true)
	private Integer selfCityId;
	@ApiModelProperty(hidden = true)
	private Integer selfArchiveId;
	@ApiModelProperty(hidden = true)
	private Integer selfUaId;
	@ApiModelProperty(hidden = true)
	private Integer selfCompUaId;
	@ApiModelProperty(hidden = true)
	private String selfCompNo;
	@ApiModelProperty(hidden = true)
	private String selfDeptNo;
	@ApiModelProperty(hidden = true)
	private Integer selfAdminDeptId;

	public String getDateType() {
		return dateType;
	}
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	public Integer getUaType() {
		return uaType;
	}
	public void setUaType(Integer uaType) {
		this.uaType = uaType;
	}
	public Integer getSelfUserId() {
		return selfUserId;
	}
	public void setSelfUserId(Integer selfUserId) {
		this.selfUserId = selfUserId;
	}
	public Integer getSelfArchiveId() {
		return selfArchiveId;
	}
	public void setSelfArchiveId(Integer selfArchiveId) {
		this.selfArchiveId = selfArchiveId;
	}
	public Integer getSelfUaId() {
		return selfUaId;
	}
	public void setSelfUaId(Integer selfUaId) {
		this.selfUaId = selfUaId;
	}
	public Integer getSelfCompUaId() {
		return selfCompUaId;
	}
	public void setSelfCompUaId(Integer selfCompUaId) {
		this.selfCompUaId = selfCompUaId;
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
	public Integer getSelfCityId() {
		return selfCityId;
	}
	public void setSelfCityId(Integer selfCityId) {
		this.selfCityId = selfCityId;
	}
	public Integer getSelfCompType() {
		return selfCompType;
	}
	public void setSelfCompType(Integer selfCompType) {
		this.selfCompType = selfCompType;
	}
	public Integer getIsGeneralManager() {
		return isGeneralManager;
	}
	public void setIsGeneralManager(Integer isGeneralManager) {
		this.isGeneralManager = isGeneralManager;
	}
	public String getSelfCompNo() {
		return selfCompNo;
	}
	public void setSelfCompNo(String selfCompNo) {
		this.selfCompNo = selfCompNo;
	}
	public String getSelfDeptNo() {
		return selfDeptNo;
	}
	public void setSelfDeptNo(String selfDeptNo) {
		this.selfDeptNo = selfDeptNo;
	}
	public Integer getSelfAdminDeptId() {
		return selfAdminDeptId;
	}
	public void setSelfAdminDeptId(Integer selfAdminDeptId) {
		this.selfAdminDeptId = selfAdminDeptId;
	}
}
